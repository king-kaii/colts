package com.colt.lbconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colt.lbconnect.dtos.BorrowerRegistrationDTO;
import com.colt.lbconnect.entities.Borrower;
import com.colt.lbconnect.service.BorrowerService;

@RestController
@RequestMapping("/borrower")
public class BorrrowerController {

	@Autowired
	BorrowerService borrowerService;

	
	@GetMapping("/getborrower")
	public Iterable<Borrower> getAll() {
		return borrowerService.getBorrowers();
	}

	@PostMapping("/save")
	public Borrower saveBorrower(@RequestBody Borrower borrower) {
		return borrowerService.saveBorrower(borrower);

	}
	@PostMapping("/register")
	public String saveBorrower(@RequestBody BorrowerRegistrationDTO borrower) {
		 if(borrowerService.registerBorrower(borrower)) {
		 return "Successfully Registered";
		 }else {
			 return "Borrower NOt registered check with Customer care";
		 }
		

	}
	@GetMapping("/calculateScore")
	public int calculateScore() {
		System.out.println("Inside LB BC");
		return borrowerService.calculateScore(12);
	}
	
	

}
