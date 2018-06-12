package com.techelevator;

import java.util.ArrayList;

public class KataPrimeFactors {
	
	public ArrayList<Integer> factorize(int number) {
	
		ArrayList<Integer> primeFactorList = new ArrayList<Integer>();
		ArrayList<Integer> factorList = new ArrayList<Integer>();
		
		
		factorList.add(number);											//add number to factor list
		
		while(!factorList.isEmpty()) {								//loop while factor list has values
			
			for (int i = 0; i < factorList.size(); i++) {				//loop through numbers in factor list
				if(isPrime(factorList.get(i))) {						//if first number is prime, add it to the prime list and remove from factor list
					primeFactorList.add(factorList.get(i));
					factorList.remove(i);
					i--;
				}
			}
																		
			if(!factorList.isEmpty()) {									//if factor list still not empty
				factorList.addAll(getTwoFactors(factorList.get(0)));	//get 2 factors of the first number and add to list
				factorList.remove(0);									//remove the first number
			}
			
		}
		
		return primeFactorList;
	}
	
	public boolean isPrime(int number) {
		for (int possibleFactor = 2; possibleFactor < number; possibleFactor++) {
			if(number % possibleFactor == 0) {
				return false;
			}
		}
		return true;
	}
	
	public ArrayList<Integer> getTwoFactors(int number){
		ArrayList<Integer> factorList = new ArrayList<Integer>();
		for (int possibleFactor = 2; possibleFactor < number; possibleFactor++) {
			if(number % possibleFactor == 0) {
				factorList.add(possibleFactor);
				factorList.add(number / possibleFactor);
				break;
			}
		}
		return factorList;
	}
	

}
