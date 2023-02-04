package com.colt.lbconnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.colt.lbconnect.dtos.BorrowerRegistrationDTO;
import com.colt.lbconnect.entities.Borrower;
import com.colt.lbconnect.repository.BorrowerRepository;

@Component
public class BorrowerService {

	@Autowired
	BorrowerRepository borrowerRepository;
	
	public Iterable<Borrower> getBorrowers() {
		// TODO Auto-generated method stub
		return borrowerRepository.findAll();
		
	}

	public Borrower saveBorrower(Borrower borrower) {
		return borrowerRepository.save(borrower);
		
	}

	public boolean registerBorrower(BorrowerRegistrationDTO borrowerDTO) {
		Borrower borrower = new Borrower();
		borrower.setId(borrowerDTO.getAaadhaar());
		borrower.setName(borrowerDTO.getName());
		borrower.setDob(borrowerDTO.getDob());
		borrower.setEmail(borrowerDTO.getEmail());
		borrower.setAddress(borrowerDTO.getAddress());
		borrower.setNominee(borrowerDTO.getNominee());
		borrower.setMobile(borrowerDTO.getMobile());
		borrower.setScore(calculateScore(borrowerDTO.getAaadhaar()));
		borrower.setEligibility(borrowerDTO.getSalary()/2);
		borrower.setActive(false);
		if(borrowerRepository.save(borrower).equals(borrower))
		return true;
		else
		return false;
	}
	
	private int calculateScore(int id) {
		return 800;
	}

	
}
