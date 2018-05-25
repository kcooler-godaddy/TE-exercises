package com.techelevator;

import java.util.Scanner;

/*
 The Fahrenheit to Celsius conversion formula is:
 	Tc = (Tf - 32) / 1.8
 	where 'Tc' is the temperature in Celsius, and 'Tf' is the temperature in Fahrenheit
 	
 The Celsius to Fahrenheit conversion formula is:
 	Tf = Tc * 1.8 + 32
 	
 Write a command line program which prompts a user to enter a temperature, and whether its in degrees (C)elsius or (F)arenheit.
 Convert the temperature to the opposite degrees, and display the old and new temperatures to the console.
  
 $ java TempConvert
 Please enter the temperature: 58
 Is the temperature in (C)elcius, or (F)arenheit? F
 58F is 14C.
 
 Note why Tf - 32 above is enclosed in parentheses with a comment inside your code. You'll feel better for it, 
 and will start building some good programming habits while you're at it.
 */
public class TempConvert {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		double Tc;
		double Tf;
		
		// get temp from user
		System.out.print("Please enter the temperature: ");
		String tempStr = in.nextLine();
		System.out.println();
		float temp = Float.parseFloat(tempStr); 
		
		// get unit from user
		System.out.print("Is the temperature in (C)elcius, or (F)arenheit? ");
		String unitStr = in.nextLine().toUpperCase();
		System.out.println();
		
		// cases for depending on units
		switch (unitStr) {
		case "C":
			Tc = temp;
			Tf = Tc * 1.8 + 32;
			System.out.printf("%5.0fC is %.0fF.", Tc, Tf);
			break;
		case "F":
			Tf = temp;
			Tc = (Tf - 32) / 1.8; 	//(Tf - 32) is enclosed in parenthesis to force a non-standard order of operations. 
			System.out.printf("%5.0fF is %.0fC.", Tf, Tc);
			break;
		default:
			System.out.println("Error: You did not input a valid unit of measurement.");
			break;
		}

	}

}
