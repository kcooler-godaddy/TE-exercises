package com.techelevator;

import java.math.BigDecimal;

public class PostalService implements DeliveryDriver{
	
	private int shippingClass;
	private double perMileRate;
	
	//constructor get the class of shipment
	public PostalService(int shippingClass) {
		this.shippingClass = shippingClass;
	}
	
	//getters
	public int getShippingClass() {
		return shippingClass;
	}
	public double getPerMileRate() {
		return perMileRate;
	}

	//required for interface and sets perMileRate
	public double calculateRate(double distance, double weight) {
		switch (shippingClass){
			case 1:
				if(weight >= 0 && weight <= 2) perMileRate = 0.035;
				else if(weight <= 8) perMileRate = 0.040;
				else if(weight <= 15) perMileRate = 0.047;
				else if(weight <= 48) perMileRate = 0.195;
				else if(weight <= 128) perMileRate = 0.450;
				else perMileRate = 0.500;
				break;
			case 2:
				if(weight >= 0 && weight <= 2) perMileRate = 0.0035;
				else if(weight <= 8) perMileRate = 0.0040;
				else if(weight <= 15) perMileRate = 0.0047;
				else if(weight <= 48) perMileRate = 0.0195;
				else if(weight <= 128) perMileRate = 0.0450;
				else perMileRate = 0.0500;
				break;
			case 3:
				if(weight >= 0 && weight <= 2) perMileRate = 0.0020;
				else if(weight <= 8) perMileRate = 0.0022;
				else if(weight <= 15) perMileRate = 0.0024;
				else if(weight <= 48) perMileRate = 0.0150;
				else if(weight <= 128) perMileRate = 0.0160;
				else perMileRate = 0.0170;
				break;
		}
		BigDecimal bd = new BigDecimal(perMileRate * distance) ;
		bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		return bd.doubleValue();
		
	}
	
	

}
