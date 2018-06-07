package com.techelevator;
import java.math.BigDecimal;

public class Truck implements Vehicle{
	
	private int axles;
	private double perMile;
	
	public Truck(int axles) {
		this.axles = axles;
	}
	
	public int getAxles() {
		return this.axles;
	}

	@Override
	public double calculateToll(double distance) {
		if (axles == 4) perMile = 0.040;
		else if(axles == 6) perMile = 0.045;
		else perMile = 0.048;
		return new BigDecimal(distance * perMile).setScale(2,  BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	@Override
	public String toString() {
		return "Truck";
	}
	
	

}
