package com.eureka.app.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceController {
	
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/getSchoolDetails/{schoolname}", method = RequestMethod.GET)
	public String getStudents(@PathVariable String schoolname) {
		System.out.println("Getting School details for " + schoolname);
		String response = restTemplate.exchange("http://school-service/getSchoolDetails/{schoolname}",
				HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
				}, schoolname).getBody();

		System.out.println("Response Received as " + response);

		return "School Name -  " + schoolname + " \n Student Details " + response;
	}

	@RequestMapping(value = "/getScore/{bId}", method = RequestMethod.GET)
	public int getScore(@PathVariable int bId) {
		System.out.println("Getting Borrower details for " + bId);
		String response = restTemplate.exchange("http://scorecheck/scorecheck/score/{bId}",
				HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
				}, bId).getBody();

		System.out.println("Response Received as " + response);

		return Integer.parseInt(response);
	}
	
	@RequestMapping(value = "/getScore", method = RequestMethod.GET)
	public int gettinscore() {
		String response = restTemplate.exchange("http://scorecheck/scorecheck/score/12",
				HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
				}).getBody();

		System.out.println("Response Received as " + response);
        
		return Integer.parseInt(response);
	}
	
	@RequestMapping(value = "/getScorelc", method = RequestMethod.GET)
	public int gettinscorelc() {
		String response = restTemplate.exchange("http://loan-connect/borrower/calculateScore",
				HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
				}).getBody();

        
		return Integer.parseInt(response);
	}
	
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String say() {

		return "Hello";
	}


	

}
