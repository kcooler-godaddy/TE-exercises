package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FexEdTest {
	
	private FexEd fexEd;
	
	@Before
	public void setup() {
		fexEd = new FexEd();
	}
	
	@Test
	public void rate_accuracy_100_miles_20oz() {
		Assert.assertEquals(new Double(20.00), new Double(fexEd.calculateRate(100,  20)));
	}
	
	@Test
	public void rate_accuracy_1000_miles_20oz() {
		Assert.assertEquals(new Double(25.00), new Double(fexEd.calculateRate(1000,  20)));
	}
	
	@Test
	public void rate_accuracy_100_miles_100oz() {
		Assert.assertEquals(new Double(23.00), new Double(fexEd.calculateRate(100,  100)));
	}
	
	@Test
	public void rate_accuracy_1000_miles_100oz() {
		Assert.assertEquals(new Double(28.00), new Double(fexEd.calculateRate(1000, 100)));
	}

}
