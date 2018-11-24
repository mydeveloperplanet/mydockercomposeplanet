package com.mydeveloperplanet.mydockercomposeplanet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class MyDockerComposeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyDockerComposeApplication.class, args);
	}

}
