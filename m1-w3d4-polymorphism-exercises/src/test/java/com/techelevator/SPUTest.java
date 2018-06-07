package com.techelevator;
import org.junit.Assert;
import org.junit.Test;

public class SPUTest {
	
	SPU spu;
	
	@Test
	public void accuracy_of_4_day_rate_10oz_100miles_is_5() {
		//setup
		spu = new SPU(4);
		//act and assert
		Assert.assertEquals(new Double(5.00), new Double(spu.calculateRate(100,  10)));
	}
	
	@Test
	public void accuracy_of_2_day_rate_10oz_100miles_is_50() {
		//setup
		spu = new SPU(2);
		//act and assert
		Assert.assertEquals(new Double(50.00), new Double(spu.calculateRate(100,  10)));
	}
	
	@Test
	public void accuracy_of_next_day_rate_10oz_100miles_is_75() {
		//setup
		spu = new SPU(1);
		//act and assert
		Assert.assertEquals(new Double(75.00), new Double(spu.calculateRate(100,  10)));
	}

}
