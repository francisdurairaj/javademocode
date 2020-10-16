package com.ameya.models;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Employee {
	
	@Id
	private Integer empId;
	private String firstName;
	private String midName;
	private String lastName;
	private Double salary;
	private String userName;
	private String password;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer empId, String firstName, String midName, String lastName, Double salary,String userName,String password) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.midName = midName;
		this.lastName = lastName;
		this.salary = salary;
		this.userName=userName;
		this.password=password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMidName() {
		return midName;
	}

	public void setMidName(String midName) {
		this.midName = midName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

}
