package com.colt.lbconnect.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
public class Lender {

	@Id
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column
	private long mobile;
	
	@Column
	private int amount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Lender [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", amount=" + amount
				+ "]";
	}
	
	
	
	
	

}
