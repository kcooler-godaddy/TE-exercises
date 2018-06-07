package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class PostalServiceTest {
	
	private PostalService postalService;
	
	@Test
	public void first_class_rate_accuracy_for_each_range() {
		//setup
		postalService = new PostalService(1);
		//act
		//assert
		Assert.assertEquals(new Double(3.50), new Double(postalService.calculateRate(100, 0)));
		Assert.assertEquals(new Double(4.00), new Double(postalService.calculateRate(100, 3)));
		Assert.assertEquals(new Double(4.70), new Double(postalService.calculateRate(100, 15)));
		Assert.assertEquals(new Double(19.50), new Double(postalService.calculateRate(100, 25)));
		Assert.assertEquals(new Double(45.00), new Double(postalService.calculateRate(100, 100)));
		Assert.assertEquals(new Double(50.00), new Double(postalService.calculateRate(100, 300)));
	}
	@Test
	public void second_class_rate_accuracy_for_each_range() {
		//setup
		postalService = new PostalService(2);
		//act
		//assert
		Assert.assertEquals(new Double(3.50), new Double(postalService.calculateRate(1000, 0)));
		Assert.assertEquals(new Double(4.00), new Double(postalService.calculateRate(1000, 3)));
		Assert.assertEquals(new Double(4.70), new Double(postalService.calculateRate(1000, 15)));
		Assert.assertEquals(new Double(19.50), new Double(postalService.calculateRate(1000, 25)));
		Assert.assertEquals(new Double(45.00), new Double(postalService.calculateRate(1000, 100)));
		Assert.assertEquals(new Double(50.00), new Double(postalService.calculateRate(1000, 300)));
	}
	
	@Test
	public void third_class_rate_accuracy_for_each_range() {
		//setup
		postalService = new PostalService(3);
		//act
		//assert
		Assert.assertEquals(new Double(2.00), new Double(postalService.calculateRate(1000, 0)));
		Assert.assertEquals(new Double(2.20), new Double(postalService.calculateRate(1000, 3)));
		Assert.assertEquals(new Double(2.40), new Double(postalService.calculateRate(1000, 15)));
		Assert.assertEquals(new Double(15.00), new Double(postalService.calculateRate(1000, 25)));
		Assert.assertEquals(new Double(16.00), new Double(postalService.calculateRate(1000, 100)));
		Assert.assertEquals(new Double(17.00), new Double(postalService.calculateRate(1000, 300)));
	}

}
