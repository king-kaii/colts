package com.colt.loanhistory.loanhistory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.colt.loanhistory.loanhistory.entities.Payments;
import com.colt.loanhistory.loanhistory.repository.PaymentsRepository;

@RestController
public class LoanHistoryController {
	@Autowired
	PaymentsRepository paymentsRepository;
	
	@GetMapping("/Hi")
	public String getDetails() {
		return  "Hello LH";
	}
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	  public Payments saveCustomer(@RequestBody Payments customer) {
	    customer = paymentsRepository.save(customer);
	    return customer;
	  }

	  @RequestMapping(value = "/read", method = RequestMethod.GET)
	  public List<Payments> readCustomer() {
	    return paymentsRepository.findAll();
	  }
	  
	  
	  @RequestMapping(value = "/get", method = RequestMethod.GET)
	  public List<Payments> modifyByID(@RequestParam int loanId) {
		 return paymentsRepository.findByLoanId(loanId);

	  }
}
