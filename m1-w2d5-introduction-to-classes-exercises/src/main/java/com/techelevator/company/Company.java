package com.techelevator.company;

public class Company {

	private String name;
	private int numberOfEmployees;
	private double revenue;
	private double expenses;
<<<<<<< HEAD
	
=======

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
>>>>>>> 32d65dd7eaf7f86c3d869a9bb59f91054e44ece4
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
<<<<<<< HEAD
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCompanySize() {
		if (this.getNumberOfEmployees() <= 50) return "small";
		if (this.getNumberOfEmployees() <= 250) return "medium";
		return "large";
	}
	
	public double getProfit() {
		return this.getRevenue() - this.getExpenses();
	}
=======
	
	
>>>>>>> 32d65dd7eaf7f86c3d869a9bb59f91054e44ece4
	
}
