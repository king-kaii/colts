package com.colt.lbconnect.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_Loans")
public class LoanDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int loanId;
	
	@Column
	private int lenderId;
	
	@Column
	private int borrowerId;
	
	@Column
	private String lenderName;
	
	@Column
	private String borrowerName;
	
	@Column
	private LocalDate agreementDate;
	
	@Column
	private int loanAmount;
	
	@Column
	private int paidAmount;
	
	@Column
	private int balanceAmount;
	
	@Column
	private int emiAmount;
	
	@Column
	private int emis;
	
	@Column
	private int paidEmis;
	
	@Column
	private int balanceEmis;
	
	@Column
	private int processingFee;

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public int getLenderId() {
		return lenderId;
	}

	public void setLenderId(int lenderId) {
		this.lenderId = lenderId;
	}

	public int getBorrowerId() {
		return borrowerId;
	}

	public void setBorrowerId(int borrowerId) {
		this.borrowerId = borrowerId;
	}

	public String getLenderName() {
		return lenderName;
	}

	public void setLenderName(String lenderName) {
		this.lenderName = lenderName;
	}

	public String getBorrowerName() {
		return borrowerName;
	}

	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}

	public LocalDate getAgreementDate() {
		return agreementDate;
	}

	public void setAgreementDate(LocalDate agreementDate) {
		this.agreementDate = agreementDate;
	}

	public int getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}

	public int getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(int paidAmount) {
		this.paidAmount = paidAmount;
	}

	public int getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(int balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public int getEmiAmount() {
		return emiAmount;
	}

	public void setEmiAmount(int emiAmount) {
		this.emiAmount = emiAmount;
	}

	public int getEmis() {
		return emis;
	}

	public void setEmis(int emis) {
		this.emis = emis;
	}

	public int getPaidEmis() {
		return paidEmis;
	}

	public void setPaidEmis(int paidEmis) {
		this.paidEmis = paidEmis;
	}

	public int getBalanceEmis() {
		return balanceEmis;
	}

	public void setBalanceEmis(int balanceEmis) {
		this.balanceEmis = balanceEmis;
	}

	public int getProcessingFee() {
		return processingFee;
	}

	public void setProcessingFee(int processingFee) {
		this.processingFee = processingFee;
	}
	
	
	
}