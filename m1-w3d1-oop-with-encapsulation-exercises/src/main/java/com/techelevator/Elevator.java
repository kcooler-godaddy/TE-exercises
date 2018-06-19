package com.techelevator;

public class Elevator {
	
	private int currentFloor = 1;
	private int numberOfFloors;
	private boolean doorOpen;
	
	public Elevator(int totalNumberOfFloors) {
		this.numberOfFloors = totalNumberOfFloors;
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
	
	public void openDoor() {
		this.doorOpen = true;
	}
	
	public void closeDoor() {
		this.doorOpen = false;
	}
	
	public void goUp(int desiredFloor) {
		if (!doorOpen) {
			if (desiredFloor <= this.numberOfFloors && desiredFloor > this.currentFloor) {
				this.currentFloor = desiredFloor;
			}
		}
	}
	
	public void goDown(int desiredFloor) {
		if (!doorOpen) {
			if (desiredFloor >= 1 && desiredFloor < this.currentFloor) {
				this.currentFloor = desiredFloor;
			}
		}
	}

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
