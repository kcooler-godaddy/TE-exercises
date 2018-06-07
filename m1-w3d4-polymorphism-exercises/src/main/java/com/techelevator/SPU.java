package com.techelevator;

import java.math.BigDecimal;

public class SPU implements DeliveryDriver{
	
	private int daysToDeliver;
	private double multi;

	
	public SPU(int daysToDeliver) {
		this.daysToDeliver = daysToDeliver;
	}
	
	public int getDaysToDeliver() {
		return this.daysToDeliver;
	}
	
	public double calculateRate(double distance, double weight) {
		
		switch (daysToDeliver){
		case 4:
			multi = 0.005;
			break;
		case 2:
			multi = 0.050;
			break;
		case 1:
			multi = 0.075;
			break;
		}
		
		BigDecimal bd = new BigDecimal(weight * multi * distance);
		bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		return bd.doubleValue();
	}

}
