package com.techelevator;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class AirplaneTest {
	
	private Airplane airplane;
	
	@Before
	public void setup() {
		airplane = new Airplane(20, 80);  
	}
	
	@Test
	public void cannot_book_more_than_available_first_class_seats() {
		boolean check = airplane.Reserve(true,  30);
		Assert.assertFalse(check);
	}
	
	@Test
	public void cannot_book_more_than_available_coach_seats() {
		boolean check = airplane.Reserve(false,  100);
		Assert.assertFalse(check);
	}
	
	@Test
	public void accuray_after_book_5_first_class_seats() {
		airplane.Reserve(true,  5);
		Assert.assertEquals(15,  airplane.getAvailableFirstClassSeats());
	}
	
	@Test
	public void accuray_after_book_5_coach_seats() {
		airplane.Reserve(false,  5);
		Assert.assertEquals(95,  airplane.getAvailableFirstClassSeats());
	}
	
	@Test
	public void accuracy_of_count_of_available_coach_seats() {
		Assert.assertEquals(80,  airplane.getAvailableCoachSeats());
	}
	 
	@Test
	public void accuracy_of_count_of_available_first_class_seats() {
		Assert.assertEquals(20,  airplane.getAvailableFirstClassSeats());
	}


}
