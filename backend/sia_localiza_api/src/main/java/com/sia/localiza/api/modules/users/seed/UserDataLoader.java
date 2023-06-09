package com.sia.localiza.api.modules.users.seed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sia.localiza.api.modules.users.entities.User;
import com.sia.localiza.api.modules.users.repositories.UserRepository;

@Component
public class UserDataLoader implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Value("${app.env}")
	private String env;

	@Override
	public void run(String... args) throws Exception {
		if(this.env.equals("development")) {
			loadUserData();
		}
	}

	private void loadUserData() {
        System.out.println("##### Seed usuarios #####");
		if (userRepository.count() == 0) {
			User user1 = new User("John", "jhon@gmail.com", "123");
			User user2 = new User("Felipe", "felipe@gmail.com", "123");
			userRepository.save(user1);
			userRepository.save(user2);
		}
		System.out.println("usuarios cadastrados: " + userRepository.count());
        System.out.println("############################");
	}
}