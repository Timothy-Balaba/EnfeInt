package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public RestOperations restTemplate(){
		return new RestTemplate();
	}

	@Override
	public void run(String... args) throws Exception {
		List<User> result = userService.fetchData();
//		System.out.println(result);
		result.forEach( responseObject -> {
			System.out.println("------------------------------");
			System.out.println("Username: " + responseObject.getUsername());
			System.out.println("Email: " + responseObject.getEmail());
			System.out.println("Zip Code: " + responseObject.getZipcode());
			System.out.println("------------------------------");
			System.out.println("------------------------------");
		});
	}
}
