package com.techelevator;

import java.util.Scanner;

/*
 The foot to meter conversion formula is:
 	m = f * 0.3048
 	
 The meter to foot conversion formula is:
 	f = m * 3.2808399
 	
 Write a command line program which prompts a user to enter a length, and whether the measurement is in (m)eters or (f)eet.
 Convert the length to the opposite measurement, and display the old and new measurements to the console.
  
 $ java LinearConvert
 Please enter the length: 58
 Is the measurement in (m)eter, or (f)eet? f
 58f is 17m.
 */

public class LinearConvert {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double feet;
		double meters;
		
		// get length from user
		System.out.print("Please enter the length: ");
		String lengthStr = in.nextLine();
		System.out.println();
		float length = Float.parseFloat(lengthStr); 
		
		// get unit from user
		System.out.print("Is the measurement in (m)eters or (f)eet? ");
		String unitStr = in.nextLine();
		System.out.println();
		
		// cases for depending on units
		switch (unitStr) {
		case "m":
			meters = length;
			feet = meters * 3.2808399;
			System.out.printf("%5.0f meters is %.0f feet.", meters, feet);
			break;
		case "f":
			feet = length;
			meters = feet * 0.3048;
			System.out.printf("%5.0f feet is %.0f meters.", feet, meters);
			break;
		default:
			System.out.println("You did not input a valid unit of measurement");
			break;
		}
		

	}

}
