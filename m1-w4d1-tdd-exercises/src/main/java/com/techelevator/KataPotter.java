package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class KataPotter {
	
	private final static double price = 8d;
	
	double getCost(int[] books) {

		
		double cost = 0.00;
		int quantity = books.length;
		
		//how many of each book
		HashMap<Integer, Integer>bookQuantityMap = createBookQuantityMap(books);
		
		//how many of each number of set
		HashMap<Integer, Integer> setQuantityMap = createSetQuantityMap(bookQuantityMap);
		
		//while there is a set of 5 and a set of 3, remove them and add two sets of 4
		while (setQuantityMap.get(3) > 0 && setQuantityMap.get(5) > 0) {
			setQuantityMap.put(3, setQuantityMap.get(3) - 1);
			setQuantityMap.put(5, setQuantityMap.get(5) - 1);
			setQuantityMap.put(4, setQuantityMap.get(4) + 2);
		}
		
		//add pricing for the number of sets
		for (int key: setQuantityMap.keySet()) {
			cost += price * getDiscountMultiplier(key) * setQuantityMap.get(key) * key;
		}
		
		return new BigDecimal(cost).setScale(2,  BigDecimal.ROUND_HALF_UP).doubleValue();
		
		
		
		
		
	}
	

	
	public boolean hasSetOf(int setNumber, HashMap<Integer, Integer> quantityMap) {
		int count = 0;
		for (int key: quantityMap.keySet()) {
			if(quantityMap.get(key) != 0) {
				count += 1;
			}
		}
		if (count == setNumber) {
			return true;
		}
		return false;
	}
	
	public HashMap<Integer, Integer> removeEmptyBooks(HashMap<Integer, Integer> originalMap){
		HashMap<Integer, Integer> newMap = new HashMap<Integer, Integer>();
		for (int key: originalMap.keySet()) {
			if(originalMap.get(key) != 0) {
				newMap.put(key, originalMap.get(key));
			}
		}
		return newMap;
	}
	
	public double getDiscountMultiplier(int numberOfBooksInSet) {
		double discount = 1;
		switch (numberOfBooksInSet) {
		case 2:
			discount = 0.95;
			break;
		case 3:
			discount = 0.90;
			break;
		case 4:
			discount = .80;
			break;
		case 5:
			discount = .75;
			break;
		}
		return discount;
	}
	
	public HashMap<Integer, Integer> createBookQuantityMap(int[] books){
		HashMap<Integer, Integer> bookQuantityMap = new HashMap<Integer, Integer>();
		
		bookQuantityMap.put(1,  0); 
		bookQuantityMap.put(2,  0); 
		bookQuantityMap.put(3,  0); 
		bookQuantityMap.put(4,  0); 
		bookQuantityMap.put(5,  0); 
		
		
		for (int book: books) {
			bookQuantityMap.put(book, bookQuantityMap.get(book) + 1);
		}

		return bookQuantityMap;
	}
	
	public HashMap<Integer, Integer> createSetQuantityMap(HashMap<Integer, Integer> bookQuantityMap){
		HashMap<Integer, Integer> setQuantityMap = new HashMap<Integer, Integer>();
		setQuantityMap.put(1,  0); 
		setQuantityMap.put(2,  0); 
		setQuantityMap.put(3,  0); 
		setQuantityMap.put(4,  0); 
		setQuantityMap.put(5,  0);
		
		bookQuantityMap = removeEmptyBooks(bookQuantityMap);
		
		while (hasSetOf(bookQuantityMap.size(), bookQuantityMap)) {
			
			for (int book: bookQuantityMap.keySet()) {
				bookQuantityMap.put(book,  bookQuantityMap.get(book) - 1);		//Subtract 1 from each book quantity
			}
			setQuantityMap.put(bookQuantityMap.size(),  setQuantityMap.get(bookQuantityMap.size()) + 1);		//add one to the set of (the map size)
			
			bookQuantityMap = removeEmptyBooks(bookQuantityMap);		//clear out empty books
			if(bookQuantityMap.isEmpty()) break;
		}
		
		return setQuantityMap;
	}
	 
	
	

}
