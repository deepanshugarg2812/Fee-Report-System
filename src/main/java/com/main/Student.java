package com.main;

public class Student {
	int id = 0;
	String name = "";
	String email = "";
	String gender = "";
	String course = "";
	int feeTotal = 0;
	int feePaid = 0;
	int feeDue = 0;
	String address = "";
	String phone = "";
	

	public Student() {
		super();
	}
	
	public Student(int id,String name, String email, String gender, String course, int feeTotal, int feePaid, int feeDue,
			String address, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.course = course;
		this.feeTotal = feeTotal;
		this.feePaid = feePaid;
		this.feeDue = feeDue;
		this.address = address;
		this.phone = phone;
	}
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getFeeTotal() {
		return feeTotal;
	}
	public void setFeeTotal(int feeTotal) {
		this.feeTotal = feeTotal;
	}
	public int getFeePaid() {
		return feePaid;
	}
	public void setFeePaid(int feePaid) {
		this.feePaid = feePaid;
	}
	public int getFeeDue() {
		return feeDue;
	}
	public void setFeeDue(int feeDue) {
		this.feeDue = feeDue;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
