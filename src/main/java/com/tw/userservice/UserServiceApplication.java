package com.tw.userservice;

import com.tw.userservice.Model.User;
import com.tw.userservice.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);

	}


	/*@Bean
	public CommandLineRunner setup(UserRepository repository) {
		return (args) -> {
			repository.save(new User("A", 100));
			repository.save(new User("B", 110));
			repository.save(new User("C", 120));
			repository.save(new User("D", 130));
		};*/

	//}

}
