package com.techelevator.calculator;

public class Calculator {

	private int currentValue;
	
	public int getCurrentValue() {
		return this.currentValue;
	}
	
	public int add(int addend) {
		return this.currentValue += addend;
	}
	
	public int multiply(int multiplier) {
		return this.currentValue *= multiplier;
	}
	
	public int subtract(int subtrahend) {
		return this.currentValue -= subtrahend;
	}
	
	public int power(int exponent) {
		this.currentValue = (int) Math.pow(this.getCurrentValue(), exponent);
		return this.currentValue;
	}
	
	public void reset() {
		this.currentValue = 0;
	}
	
}
