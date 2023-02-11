package com.colts.loanbatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LoanbatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanbatchApplication.class, args);
	}

}
