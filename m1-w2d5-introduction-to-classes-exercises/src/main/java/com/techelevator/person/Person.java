package com.techelevator.person;

public class Person {

	private String firstName;
	private String lastName;
	private int age;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getFullName() {
		return lastName + ", " + firstName;
	}
	
	public boolean isAdult() {
		if (this.getAge() >= 18) return true;
		return false;
	}
	
	
}
