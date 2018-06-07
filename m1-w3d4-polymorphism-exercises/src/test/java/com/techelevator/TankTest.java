package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TankTest {
	
	Tank tank;
	
	@Before
	public void setup() {
		tank = new Tank();
	}
	
	@Test
	public void toll_is_0_with_all_distances() {
		Assert.assertEquals(new Double(0.00), new Double(tank.calculateToll(20)));
		Assert.assertEquals(new Double(0.00), new Double(tank.calculateToll(80)));
		Assert.assertEquals(new Double(0.00), new Double(tank.calculateToll(110)));
	}

}
