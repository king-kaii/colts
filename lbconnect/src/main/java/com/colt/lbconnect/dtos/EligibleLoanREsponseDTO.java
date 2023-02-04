package com.colt.lbconnect.dtos;

public class EligibleLoanREsponseDTO {
	private int LenderId;
	private String LenderName;
	private int EligibleAmount;
	private int ProcessingFee;
	public int getLenderId() {
		return LenderId;
	}
	public void setLenderId(int lenderId) {
		LenderId = lenderId;
	}
	public String getLenderName() {
		return LenderName;
	}
	public void setLenderName(String lenderName) {
		LenderName = lenderName;
	}
	public int getEligibleAmount() {
		return EligibleAmount;
	}
	public void setEligibleAmount(int eligibleAmount) {
		EligibleAmount = eligibleAmount;
	}
	public int getProcessingFee() {
		return ProcessingFee;
	}
	public void setProcessingFee(int processingFee) {
		ProcessingFee = processingFee;
	}

	

}
