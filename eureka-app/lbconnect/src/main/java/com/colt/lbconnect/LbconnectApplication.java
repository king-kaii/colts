package com.colt.lbconnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LbconnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(LbconnectApplication.class, args);
	}

}
