package com.colt.lbconnect.dtos;

import java.time.LocalDate;

public class BorrowerRegistrationDTO {
	private String name;
	private LocalDate dob;
	private String email;
	private String address;	
	private String nominee;
	private long mobile;
	private int salary;	
	private int Aaadhaar;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNominee() {
		return nominee;
	}
	public void setNominee(String nominee) {
		this.nominee = nominee;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getAaadhaar() {
		return Aaadhaar;
	}
	public void setAaadhaar(int aaadhaar) {
		Aaadhaar = aaadhaar;
	}
	

}
