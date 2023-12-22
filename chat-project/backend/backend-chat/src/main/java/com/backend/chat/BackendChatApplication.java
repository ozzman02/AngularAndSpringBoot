package com.backend.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class BackendChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendChatApplication.class, args);
	}

}
