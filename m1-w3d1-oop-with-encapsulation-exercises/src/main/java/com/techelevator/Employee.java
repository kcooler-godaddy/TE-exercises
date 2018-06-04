package com.techelevator;

public class Employee {
	
	private int EmployeeId;
	private String firstName;
	private String lastName;
	private String department;
	private double annualSalary;
	
	public Employee(int employeeId, String firstName, String lastName, double salary) {
		this.EmployeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.annualSalary = salary;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getEmployeeId() {
		return EmployeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public double getAnnualSalary() {
		return annualSalary;
	}
	
	public void raiseSalary(double percent) {
		this.annualSalary += (this.annualSalary * percent / 100);
	}
	
	public String getFullName() {
		return lastName + ", " + firstName;
	}

}
