package com.colt.lbconnect.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.colt.lbconnect.dtos.BorrowerRegistrationDTO;
import com.colt.lbconnect.entities.Borrower;
import com.colt.lbconnect.repository.BorrowerRepository;

@Component
public class BorrowerService {

	@Autowired
	BorrowerRepository borrowerRepository;

	RestTemplate restTemplate = new RestTemplate();

	public Iterable<Borrower> getBorrowers() {
		// TODO Auto-generated method stub
		return borrowerRepository.findAll();

	}

	public Borrower saveBorrower(Borrower borrower) {
		return borrowerRepository.save(borrower);

	}

	public boolean registerBorrower(BorrowerRegistrationDTO borrowerDTO) {
		int score =calculateScore(borrowerDTO.getAaadhaar());
		if(score<730) {
			return false;
		}
		Borrower borrower = new Borrower();
		borrower.setId(borrowerDTO.getAaadhaar());
		borrower.setName(borrowerDTO.getName());
		borrower.setDob(borrowerDTO.getDob());
		borrower.setEmail(borrowerDTO.getEmail());
		borrower.setAddress(borrowerDTO.getAddress());
		borrower.setNominee(borrowerDTO.getNominee());
		borrower.setMobile(borrowerDTO.getMobile());
		borrower.setScore(score);
		borrower.setEligibility(borrowerDTO.getSalary() / 2);
		borrower.setActive(false);
		if (borrowerRepository.save(borrower).equals(borrower))
			return true;
		else
			return false;
	}

	private int calculateScore(int id) {

		ResponseEntity<String> result = restTemplate.exchange("http://localhost:8081/scorecheck/score/" + id,
				HttpMethod.GET, null, String.class);

		return Integer.parseInt(result.getBody().toString());

	}

}
