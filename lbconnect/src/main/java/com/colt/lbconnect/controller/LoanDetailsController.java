package com.colt.lbconnect.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colt.lbconnect.dtos.ApplyLoanDTO;
import com.colt.lbconnect.dtos.EligibleLoanREsponseDTO;
import com.colt.lbconnect.entities.LoanDetails;
import com.colt.lbconnect.service.LoanDetailsService;

@RestController
@RequestMapping("/loans")
public class LoanDetailsController {
	
	@Autowired
	LoanDetailsService loanDetailsService;
	
	@GetMapping("/getLoans")
	public Iterable<LoanDetails> getLoans(){
		return loanDetailsService.getLoanDetails();
	}
	
	@PostMapping("/saveLoans")
	public LoanDetails saveloans(@RequestBody LoanDetails loanDetails) {
		return loanDetailsService.saveLoanDetails(loanDetails);
	}
	
	@GetMapping("/eligibleLoans/{borrowerId}")
	public List<EligibleLoanREsponseDTO> checkEligibility(@PathVariable int borrowerId){
		return loanDetailsService.checkEligibility(borrowerId);
	}
	
	@PostMapping("/applyLoan")
	public String  applyLoan(@RequestBody ApplyLoanDTO applyLoanDTO) {
		int LoanNumber = loanDetailsService.applyLoan(applyLoanDTO);
		return "Loan No :" + LoanNumber +"successfully Appled and Amount will be disbursed soon";
	}
	
	
	
	
}