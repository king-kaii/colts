package com.colt.lbconnect.dtos;

public class ApplyLoanDTO {

	private int  borrowerId;
	private int amount;
	private int LenderId;
	public int getBorrowerId() {
		return borrowerId;
	}
	public void setBorrowerId(int borrowerId) {
		this.borrowerId = borrowerId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getLenderId() {
		return LenderId;
	}
	public void setLenderId(int lenderId) {
		LenderId = lenderId;
	}
	

}
