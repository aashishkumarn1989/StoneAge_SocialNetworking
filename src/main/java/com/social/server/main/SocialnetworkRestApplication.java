package com.social.server.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.social"})
public class SocialnetworkRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialnetworkRestApplication.class, args);
	}
}
