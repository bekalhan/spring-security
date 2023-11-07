package com.kalhan.jwtsecurity;

import com.kalhan.jwtsecurity.service.AuthenticationService;
import com.kalhan.jwtsecurity.request.RegisterRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.kalhan.jwtsecurity.enumPackage.Role.ADMIN;
import static com.kalhan.jwtsecurity.enumPackage.Role.MANAGER;

@SpringBootApplication
public class JwtSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtSecurityApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service
	) {
		return args -> {
			/*var admin = RegisterRequest.builder()
					.firstname("Admin")
					.lastname("Admin")
					.email("admin@mail.com")
					.password("password")
					.role(ADMIN)
					.build();*/
			var admin = RegisterRequest.builder()
							.firstname("Admin")
									.lastname("Admin")
											.email("admin@gmail.com")
													.password("password")
															.role(ADMIN)
																	.build();
			//System.out.println("Admin token: " + service.register(admin).getAccessToken());

			var manager = RegisterRequest.builder()
					.firstname("Admin")
					.lastname("Admin")
					.email("manager@mail.com")
					.password("password")
					.role(MANAGER)
					.build();
			//System.out.println("Manager token: " + service.register(manager).getAccessToken());

		};
	}
}
