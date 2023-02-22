package com.colt.scorecheck;

import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ScorecheckApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScorecheckApplication.class, args);

	}

}
