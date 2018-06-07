package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class VehicleTollDemo {

	public static void main(String[] args) {
		
		double totalMiles = 0d;
		double revenue = 0d;
		
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		vehicles.add(new Car(false));
		vehicles.add(new Car(true));
		vehicles.add(new Truck(4));
		vehicles.add(new Truck(6));
		vehicles.add(new Truck(10));
		vehicles.add(new Tank());
		
		System.out.printf("%-15s%-25s%-10s\n","Vehicle","Distance Traveled", "Toll $");
		System.out.println("----------------------------------------------");
		
		for (Vehicle vehicle: vehicles) {
			int distance = (int)((Math.random() * 231) + 10);
			totalMiles += distance;
			double toll = vehicle.calculateToll(distance);
			revenue += toll;
			System.out.printf("%-15s%-25d%-10.2f\n", vehicle.toString(), distance, toll);
		}
		
		System.out.println();
		System.out.println("Total Distance: " + totalMiles);	
		System.out.println("Total Toll Revenue: $" + revenue);
		
	

	}

}
