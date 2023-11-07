package com.kalhan.jwtsecurity.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kalhan.jwtsecurity.request.AuthenticationRequest;
import com.kalhan.jwtsecurity.request.RegisterRequest;
import com.kalhan.jwtsecurity.request.VerificationRequest;
import com.kalhan.jwtsecurity.response.AuthenticationResponse;
import com.kalhan.jwtsecurity.tfa.TwoFactorAuthenticationService;
import com.kalhan.jwtsecurity.entity.Token;
import com.kalhan.jwtsecurity.repository.TokenRepository;
import com.kalhan.jwtsecurity.enumPackage.TokenType;
import com.kalhan.jwtsecurity.entity.User;
import com.kalhan.jwtsecurity.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;

    private final TokenRepository tokenRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    private TwoFactorAuthenticationService twoFactorAuthenticationService;

    public AuthenticationResponse register(RegisterRequest request){
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                //.mfaEnabled(request.getMfaEnabled())
                .build();
        // if MFA enbaled -> Generate secret
        /*if(request.getMfaEnabled()){
            user.setSecret(twoFactorAuthenticationService.generateNewString());
        }*/
        User savedUser = userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        saveUserToken(savedUser,jwtToken);
       /* return AuthenticationResponse.builder()
                .secretImageUri(twoFactorAuthenticationService.generateQrCodeImageUri(user.getSecret()))
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .mfaEnabled(user.getMfaEnabled())
                .build();*/
                return AuthenticationResponse.builder()
                .secretImageUri(twoFactorAuthenticationService.generateQrCodeImageUri(user.getSecret()))
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request){
       authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        /*if(user.getMfaEnabled()){
            return AuthenticationResponse.builder()
                    .accessToken("")
                    .refreshToken("")
                    .mfaEnabled(true).build();
        }*/
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user,jwtToken);
        return new AuthenticationResponse().builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                //.mfaEnabled(false)
                .build();
    }

    private void revokeAllUserTokens(User user){
        var validUserTokens = tokenRepository.findByValidTokenByUser(user.getId());
        if(validUserTokens.isEmpty()) return;

        validUserTokens.forEach(t ->{
            t.setExpired(true);
            t.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    private void saveUserToken(User user,String jwtToken){
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .revoked(false)
                .expired(false)
                .build();

        tokenRepository.save(token);
    }

    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail != null) {
            var user = this.userRepository.findByEmail(userEmail)
                    .orElseThrow();
            if (jwtService.isTokenValid(refreshToken, user)) {
                var accessToken = jwtService.generateToken(user);
                revokeAllUserTokens(user);
                saveUserToken(user, accessToken);
                var authResponse = AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .mfaEnabled(false)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }

    public AuthenticationResponse verifyCode(VerificationRequest verificationRequest) {
        User user = userRepository.findByEmail(verificationRequest.getEmail())
                .orElseThrow(() -> new EntityNotFoundException(String.format("no user found %s"+verificationRequest.getEmail())));
        if(twoFactorAuthenticationService.isOtpValid(user.getSecret(), verificationRequest.getCode())){
            throw new BadCredentialsException("Code is not correct");
        }
        var jwtToken = jwtService.generateToken(user);
        var refresh = jwtService.generateRefreshToken(user);

        return AuthenticationResponse.builder()
            .accessToken(jwtToken)
                .refreshToken(refresh)
            .mfaEnabled(user.getMfaEnabled())
            .build()
            ;
    }
}
