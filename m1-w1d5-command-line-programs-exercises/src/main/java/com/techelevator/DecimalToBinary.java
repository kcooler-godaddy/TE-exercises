package com.techelevator;

import java.util.Scanner;

/*
Write a command line program which prompts the user for a series of decimal integer values  
and displays each decimal value as itself and its binary equivalent

$ DecimalToBinary 

Please enter in a series of decimal values (separated by spaces): 460 8218 1 31313 987654321

460 in binary is 111001100
8218 in binary is 10000000011010
1 in binary is 1
31313 in binary is 111101001010001
987654321 in binary is 111010110111100110100010110001
*/
public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		//get string of decimal values
		System.out.print("Please enter in a series of decimal values (separated by spaces): ");
		String inputString = in.nextLine();
		System.out.println();
		
		//split string into array of decimal strings
		String [] strValues = inputString.split(" ");
		
		String [] binaryValues = new String[strValues.length];
		
		//loop through each decimal string
		for (int i = 0; i < strValues.length; i++) {
			int tempInt = Integer.parseInt(strValues[i]);
			binaryValues[i] = Integer.toBinaryString(tempInt);
			
			//convert decimal integer to a binary string
			/*
			while (tempInt > 1) {
				if (tempInt % 2 == 0) {
					tempInt /= 2;
					binaryString = "1" + binaryString;
				}
				else if 
			}
			*/
		}
		
		//loop through binary values to print
		
		for (int i = 0; i < binaryValues.length; i++) {
			System.out.println(strValues[i] + " in binary is " + binaryValues[i]);
		}
		
		

	}

}
