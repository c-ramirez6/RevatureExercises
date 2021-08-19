package com.employee;

public class Employee {

	private int id;
	private String name;
	private String email;
	private String gender;
	private String country;
	
	public Employee(String name, String email, String gender, String country) {
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.country = country;
	}
	
	public Employee(int id, String name, String email, String gender, String country) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.country = country;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getGender() {
		return gender;
	}

	public String getCountry() {
		return country;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", gender=" + gender + ", country="
				+ country + "]";
	}
	
	
}
