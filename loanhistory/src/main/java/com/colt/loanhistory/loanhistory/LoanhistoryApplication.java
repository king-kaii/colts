package com.colt.loanhistory.loanhistory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LoanhistoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanhistoryApplication.class, args);
	}

}
