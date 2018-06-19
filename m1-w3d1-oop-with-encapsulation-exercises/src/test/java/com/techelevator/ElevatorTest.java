package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ElevatorTest {

	Elevator elevator;
	
	@Before
	public void setup() {
		elevator = new Elevator(13);
	}
	
	@Test
	public void elevator_should_not_go_up_with_door_open() {
		// Arrange or Setup - Open the Door
		elevator.openDoor();
		
		// Act or Test - Try to move the elevator
		elevator.goUp(5);
		
		// Assert or Verification
		int currentFloor = elevator.getCurrentFloor();
		Assert.assertEquals(1, currentFloor);
		
	}
}
