package com.sia.localiza.api.modules.users.seed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.sia.localiza.api.modules.users.entities.User;
import com.sia.localiza.api.modules.users.enums.Role;
import com.sia.localiza.api.modules.users.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserDataLoader implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	private final PasswordEncoder passwordEncoder;

	@Value("${app.env}")
	private String env;

	@Override
	public void run(String... args) throws Exception {
		if(this.env.equals("development")) {
			loadUserData();
		}
	}

	private void loadUserData() {
        
		if (userRepository.count() == 0) {
			System.out.println("##### Seed usuarios #####");
			var user1 = User.builder()
                .name("John")
                .email("jhon@gmail.com")
                .password(passwordEncoder.encode("123"))
                .role(Role.ADMIN)
                .build();
			var user2 = User.builder()
                .name("Felipe")
                .email("felipe@gmail.com")
                .password(passwordEncoder.encode("123"))
                .role(Role.ADMIN)
                .build();

			userRepository.save(user1);
			userRepository.save(user2);

			System.out.println("usuarios cadastrados: " + userRepository.count());
        	System.out.println("#########################");
		}
	}
}