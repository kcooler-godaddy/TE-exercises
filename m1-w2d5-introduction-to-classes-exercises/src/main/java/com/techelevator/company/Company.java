package com.techelevator.company;

public class Company {

	private String name;
	private int numberOfEmployees;
	private double revenue;
	private double expenses;

	public String getCompanySize() {
		// small <= 50,  medium  51 - 250], large > 250
		if (this.numberOfEmployees <= 50) {
			return "small";
		}
		if (this.numberOfEmployees <= 250) {
			return "medium";
		}
		return "large";
		
	}
	public double getProfit() {
		// revenue - expenses
		return this.revenue - this.expenses;
	}
	
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}
	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}
	public double getRevenue() {
		return revenue;
	}
	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}
	public double getExpenses() {
		return expenses;
	}
	public void setExpenses(double expenses) {
		this.expenses = expenses;
	}
	
	
	
}
