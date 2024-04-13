package com.kalhan.springsecurity;

import com.kalhan.springsecurity.dto.CreateUserRequest;
import com.kalhan.springsecurity.model.Role;
import com.kalhan.springsecurity.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class SpringSecurity implements CommandLineRunner {
	private final UserService userService;

	public SpringSecurity(UserService userService) {
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurity.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createDummyData();
	}

	private void createDummyData() {
		CreateUserRequest request = CreateUserRequest.builder()
				.name("user1")
				.username("usersurname1")
				.password("pass1")
				.authorities(Set.of(Role.ROLE_USER))
				.build();
		userService.createUser(request);

		CreateUserRequest request2 = CreateUserRequest.builder()
				.name("kalhanname")
				.username("kalhansurname")
				.password("pass2")
				.authorities(Set.of(Role.ROLE_KALHAN))
				.build();
		userService.createUser(request2);


		CreateUserRequest request3 = CreateUserRequest.builder()
				.name("No Name")
				.username("noname")
				.password("pass")
				.authorities(Set.of(Role.ROLE_ADMIN))
				.build();
		userService.createUser(request3);
	}
}
