package com.techelevator;

import java.math.BigDecimal;

public class FexEd implements DeliveryDriver{
	
	private double rate = 20.00;
	
	public double calculateRate(double distance, double weight) {
		if (distance > 500) {
			rate += 5.00;
		}
		if (weight > 48) {
			rate += 3.00;
		}
		
		BigDecimal bd = new BigDecimal(rate);
		bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		return bd.doubleValue();
	}

}
