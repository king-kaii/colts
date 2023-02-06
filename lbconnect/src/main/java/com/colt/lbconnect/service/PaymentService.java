package com.colt.lbconnect.service;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colt.lbconnect.entities.LoanDetails;
import com.colt.lbconnect.entities.Payments;
import com.colt.lbconnect.repository.LoanDetailsRepository;
import com.colt.lbconnect.repository.PaymentsRepository;

@Service
public class PaymentService {

	@Autowired
	PaymentsRepository paymentsRepository;

	@Autowired
	LoanDetailsRepository loanDetailsRepository;

	@Transactional
	public int pay(int id, long uTR, int amount) {
		LoanDetails loanDetails = loanDetailsRepository.findById(id).get();
		int currentBalance = loanDetails.getBalanceAmount();
		int balanceEMIs = loanDetails.getBalanceEmis();
		int paymentId = 0;

		Payments payments = new Payments();
		payments.setAmount(amount);
		payments.setLoanId(id);
		payments.setPaymentDate(LocalDate.now());
		payments.setUTR(uTR);
		if ((amount >= loanDetails.getEmiAmount()) && (amount <= currentBalance)) {
			paymentId = processPayments(amount, loanDetails, currentBalance, balanceEMIs, payments);
		}
		return paymentId;
	}

	private int processPayments(int amount, LoanDetails loanDetails, int currentBalance, int balanceEMIs,
			Payments payments) {
		int paymentId;
		int updatedBalance = currentBalance - amount;
		int updatedEMIS = balanceEMIs - 1;
		int updatedEMIAmount = loanDetails.getEmiAmount();
		updatedEMIAmount = check(amount, currentBalance, updatedBalance, updatedEMIS, updatedEMIAmount);
		loanDetails.setBalanceAmount(updatedBalance);
		loanDetails.setBalanceEmis(updatedEMIS);
		loanDetails.setEmiAmount(updatedEMIAmount);
		paymentId = saveDetails(loanDetails, payments);
		return paymentId;
	}

	private int saveDetails(LoanDetails loanDetails, Payments payments) {
		int paymentId;
		paymentId = paymentsRepository.save(payments).getPaymentId();
		loanDetailsRepository.save(loanDetails);
		return paymentId;
	}

	private int check(int amount, int currentBalance, int updatedBalance, int updatedEMIS, int updatedEMIAmount) {
		if (amount >= currentBalance) {
			updatedEMIAmount = updatedBalance / updatedEMIS;
		}
		return updatedEMIAmount;
	}

}
