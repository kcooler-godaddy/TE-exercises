package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CarTest {
	
	Car car;
	
	@Test
	public void accuracy_of_toll_for_100miles_without_trailer() {
		//setup
		car = new Car(false);
		//act and assert
		Assert.assertEquals(new Double(2.00), new Double(car.calculateToll(100)));
	}
	
	@Test
	public void accuracy_of_toll_for_100miles_with_trailer() {
		//setup
		car = new Car(true);
		//act and assert
		Assert.assertEquals(new Double(3.00), new Double(car.calculateToll(100)));
	}

}
