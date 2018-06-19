package com.techelevator;

public class Elevator {

	private int currentFloor	;
	private int numberOfFloors;
	private boolean doorOpen;
	

		
	public Elevator(int totalNumberOfFloors) {
		this.currentFloor = 1;
		this.numberOfFloors = totalNumberOfFloors;
	}
	
	public void openDoor() {
		doorOpen = true;
	}
	
	public void closeDoor() {
		doorOpen = false;
	}
	
	/*
	 * sends the elevator upward to the desired floor as long as the door is not open. Cannot go past last floor.
	 */
	public void goUp(int desiredFloor) {
		if (!doorOpen && desiredFloor >= this.currentFloor && desiredFloor <= numberOfFloors) {
			this.currentFloor = desiredFloor;
		}
	}
	
	/*
	 *  sends the elevator downward to the desired floor as long as the door is not open. Cannot go past floor 1.
	 */
	public void goDown(int desiredFloor) {
		if (!doorOpen && desiredFloor <= this.currentFloor && desiredFloor > 0) {
			this.currentFloor = desiredFloor;
		}	
	}
	
	public int getCurrentFloor() {
		return currentFloor;
	}
	public int getNumberOfFloors() {
		return numberOfFloors;
	}
	public boolean isDoorOpen() {
		return doorOpen;
	}
	
	
	
	
}
