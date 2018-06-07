package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class TruckTest {
	
	Truck truck;
	
	@Test
	public void accuracy_of_toll_for_100miles_with_4_axles() {
		//setup
		truck = new Truck(4);
		//act and assert
		Assert.assertEquals(new Double(4.00), new Double(truck.calculateToll(100)));
	}
	
	@Test
	public void accuracy_of_toll_for_100miles_with_6_axles() {
		//setup
		truck = new Truck(6);
		//act and assert
		Assert.assertEquals(new Double(4.50), new Double(truck.calculateToll(100)));
	}
	
	@Test
	public void accuracy_of_toll_for_100miles_with_8_axles() {
		//setup
		truck = new Truck(8);
		//act and assert
		Assert.assertEquals(new Double(4.80), new Double(truck.calculateToll(100)));
	}

}
