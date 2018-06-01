package com.techelevator.dog;

public class Dog {

	private boolean sleeping;
	
	public boolean isSleeping() {
		return this.sleeping;
	}
	
	public String makeSound() {
		if (this.sleeping) return "Zzzzz...";
		return "Woof!";
	}
	
	public void sleep() {
		this.sleeping = true;
	}
	
	public void wakeUp() {
		this.sleeping = false;
	}
	
}
