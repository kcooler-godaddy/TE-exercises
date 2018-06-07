package com.techelevator;

import java.util.Scanner;

public class ShipmentCostDemo {
	
	private static final DeliveryDriver[] deliveryDrivers = {new PostalService(1), new PostalService(2), new PostalService(3), new FexEd(), new SPU(1), new SPU(2), new SPU(4)};
	private static final String[] descriptions = {"Postal Service (1st Class)", "Postal Service (2nd Class)", "Postal Service (3rd Class)", "FexEd", "SPU (next-day)", "SPU (2-day business)", "SPU (4-day ground)"}; 
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		while (true) {
		
			System.out.println("Please enter the weight of the package:");
			System.out.print(">>>");
			double weight = in.nextDouble();
			in.nextLine();
			
			System.out.println("(P)ounds or (O)unces?");
			System.out.print(">>>");
			String unit = in.nextLine().toLowerCase();
			if(unit.equals("p")) weight *= 16;
			
			System.out.println("What distance will it be traveling?");
			System.out.print(">>>");
			double distance = in.nextDouble();
			in.nextLine();
			
			System.out.println();
			System.out.println();
			
			System.out.printf("%-30s%-20s\n","Delivery Method","$ cost");
			System.out.println("------------------------------------");
			
			for (int i = 0; i < descriptions.length; i++) {
				double cost = deliveryDrivers[i].calculateRate(distance, weight);
				System.out.printf("%-30s%-20.2f\n", descriptions[i], cost);
			}
			System.out.println();
			
		}
		
	}

}
