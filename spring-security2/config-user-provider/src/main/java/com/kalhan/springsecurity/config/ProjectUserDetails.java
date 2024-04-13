package com.kalhan.springsecurity.config;

import com.kalhan.springsecurity.model.Customer;
import com.kalhan.springsecurity.repository.CustomerRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//service olarak işaretlenmeli
@Service
public class ProjectUserDetails implements UserDetailsService {
    private final CustomerRepository customerRepository;

    public ProjectUserDetails(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //kendi custome servisimizi yazdıktan sonra method overrde ve custom logic yazdık
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("entered");
        String userName, password;
        List<GrantedAuthority> authorities;
        List<Customer> customer = customerRepository.findByEmail(username);
        System.out.println("customer"+customer);
        if (customer.size() == 0) {
            throw new UsernameNotFoundException("User details not found for the user : " + username);
        } else{
            userName = customer.get(0).getEmail();
            password = customer.get(0).getPwd();
            System.out.println("username : "+username+" password "+password);
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(customer.get(0).getRole()));
        }
        return new User(userName,password,authorities);
    }
}
