package com.colt.lbconnect.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colt.lbconnect.dtos.ApplyLoanDTO;
import com.colt.lbconnect.dtos.EligibleLoanREsponseDTO;
import com.colt.lbconnect.entities.Lender;
import com.colt.lbconnect.entities.LoanDetails;
import com.colt.lbconnect.repository.BorrowerRepository;
import com.colt.lbconnect.repository.LenderRepository;
import com.colt.lbconnect.repository.LoanDetailsRepository;


@Service
public class LoanDetailsService {
	
	@Autowired
	LoanDetailsRepository loanDetailsRepository;
	@Autowired
	LenderRepository lenderRepository;
	
	@Autowired
	BorrowerRepository borrowerREpository;
	
	private final ArtemisProducer producer;
	
	public LoanDetailsService(ArtemisProducer producer) {
        this.producer = producer;
    }
	public Iterable<LoanDetails> getLoanDetails(){
		return loanDetailsRepository.findAll();
	}
	
	public LoanDetails saveLoanDetails(LoanDetails loanDetails) {
		return loanDetailsRepository.save(loanDetails);
	}

	//Checking Eligiblity bt talking to borrower and Lender repos
	public List<EligibleLoanREsponseDTO> checkEligibility(int borrowerId) {
		int eligibleAmount = 0;
		List<EligibleLoanREsponseDTO> eligibleList = new ArrayList<>();
		if (borrowerREpository.findById(borrowerId).isPresent()) {
			eligibleAmount = borrowerREpository.findById(borrowerId).get().getEligibility();
		}
		
		for (Lender ld : lenderRepository.findAll()) {

			EligibleLoanREsponseDTO eligible = new EligibleLoanREsponseDTO();
			eligible.setEligibleAmount(eligibleAmount);
			eligible.setLenderId(ld.getId());
			eligible.setLenderName(ld.getName());
			eligible.setProcessingFee(10000);
			eligibleList.add(eligible);
		}
		
		return eligibleList;
	}

	
	//applying loans
	//accepts appplyLoand DTO and saves loan Details objects
	public int  applyLoan(ApplyLoanDTO applyLoanDTO) {
		LoanDetails loanDetails = new LoanDetails();
		LoanDetails savedloanDetails = new LoanDetails();
		//id	int
		loanDetails.setLenderId(applyLoanDTO.getLenderId());
		loanDetails.setBorrowerId(applyLoanDTO.getBorrowerId());
		if(lenderRepository.findById(applyLoanDTO.getLenderId()).isPresent()) {
		loanDetails.setLenderName(lenderRepository.findById(applyLoanDTO.getLenderId()).get().getName());
		}
		
		if(borrowerREpository.findById(applyLoanDTO.getBorrowerId()).isPresent()) {
			loanDetails.setBorrowerName(borrowerREpository.findById(applyLoanDTO.getBorrowerId()).get().getName());
			}
		
		loanDetails.setLoanAmount(applyLoanDTO.getAmount());
		loanDetails.setAgreementDate(LocalDate.now());
		loanDetails.setBalanceAmount(applyLoanDTO.getAmount());
		loanDetails.setEmis(10);
		loanDetails.setEmiAmount(applyLoanDTO.getAmount()/10);
		loanDetails.setPaidEmis(0);
		loanDetails.setBalanceEmis(0);
        loanDetails.setProcessingFee(1000);
        savedloanDetails=loanDetailsRepository.save(loanDetails);
        
        String email =borrowerREpository.findById(applyLoanDTO.getBorrowerId()).get().getEmail();
        prepareMessageAndSend(email,loanDetails.toString());
		return savedloanDetails.getLoanId();
	}

	private void prepareMessageAndSend(String email, String loanDetails) {
		
		producer.send(email+":"+loanDetails);
		
	}
	 
}