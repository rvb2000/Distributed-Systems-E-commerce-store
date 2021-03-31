package com.apurva.gatewayservicev1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class GatewayServiceV1Application {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceV1Application.class, args);
	}

}
