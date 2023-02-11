package com.colt.loanhistory.loanhistory.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Payments {
	
	private int paymentId;
	
	
	private int loanId;
	
	
	private LocalDate paymentDate;
	
	
	private long UTR;
	
	@JsonProperty("emi")
	private int amount;

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public long getUTR() {
		return UTR;
	}

	public void setUTR(long uTR) {
		UTR = uTR;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Payments(int paymentId, int loanId, LocalDate paymentDate, long UTR, int amount) {
		super();
		this.paymentId = paymentId;
		this.loanId = loanId;
		this.paymentDate = paymentDate;
		UTR = UTR;
		this.amount = amount;
	}
	
	
}
