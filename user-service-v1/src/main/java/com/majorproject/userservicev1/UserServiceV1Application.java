package com.majorproject.userservicev1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceV1Application {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceV1Application.class, args);
	}
}
