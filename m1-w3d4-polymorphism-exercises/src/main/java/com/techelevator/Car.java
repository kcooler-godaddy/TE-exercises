package com.techelevator;

import java.math.BigDecimal;

public class Car implements Vehicle{
	
	private boolean isPullingTrailer;
	private double toll;
	
	public Car(boolean isPullingTrailer) {
		this.isPullingTrailer = isPullingTrailer;
	}

	public boolean isPullingTrailer() {
		return isPullingTrailer;
	}
	
	public double calculateToll(double distance){
		toll = distance * 0.020;
		if (this.isPullingTrailer) toll += 1.00;
		return new BigDecimal(toll).setScale(2,  BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	@Override
	public String toString() {
		return "Car";
	}
 
}
