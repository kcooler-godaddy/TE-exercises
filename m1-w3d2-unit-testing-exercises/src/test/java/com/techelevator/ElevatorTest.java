package com.techelevator;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class ElevatorTest {
	
	private Elevator elevator;
	
	@Before
	public void setup() {
		elevator = new Elevator(1,10);
	}
	
	@Test
	public void cannot_go_past_highest_floor() {
		elevator.CloseDoor();
		elevator.GoUp(15);
		Assert.assertFalse(elevator.getCurrentLevel() == 15);
	}
	
	@Test
	public void no_moving_up_when_door_is_open() {
		elevator.OpenDoor();
		Assert.assertFalse(elevator.GoUp(8));
	}
	
	@Test
	public void no_moving_down_when_door_is_open() {
		elevator.CloseDoor();
		elevator.GoUp(8);
		elevator.OpenDoor();
		Assert.assertFalse(elevator.GoDown(3));
	}
	
	@Test
	public void cannot_go_to_floor_0() {
		elevator.CloseDoor();
		elevator.GoUp(8);
		Assert.assertFalse(elevator.GoDown(0));
	}
	
	@Test
	public void go_up_to_floor_8() {
		elevator.CloseDoor();
		elevator.GoUp(8);
		Assert.assertEquals(8, elevator.getCurrentLevel());
	}
	
	@Test
	public void close_door() {
		elevator.CloseDoor();
		Assert.assertFalse(elevator.isDoorOpen());
	}
	
	@Test
	public void open_door() {
		elevator.OpenDoor();
		Assert.assertTrue(elevator.isDoorOpen());
	}

}
