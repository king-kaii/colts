package com.colts.loanbatch.mysql;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Payments {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int paymentId;
	
	@Column
	private int loanId;
	
	@Column
	private LocalDate paymentDate;
	
	@Column
	private long UTR;
	
	@Column
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

	
}
