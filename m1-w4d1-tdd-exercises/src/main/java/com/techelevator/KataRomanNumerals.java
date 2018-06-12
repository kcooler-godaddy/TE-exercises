package com.techelevator;
import java.util.LinkedHashMap;

public class KataRomanNumerals {
	
	public LinkedHashMap<String, Integer> getRomanValues(){
		LinkedHashMap<String, Integer> romanValues = new LinkedHashMap<String, Integer>();
		romanValues.put("M", 1000);
		romanValues.put("CM", 900);
		romanValues.put("D", 500);
		romanValues.put("CD", 400);
		romanValues.put("C", 100);
		romanValues.put("XC", 90);
		romanValues.put("L", 50);
		romanValues.put("XL", 40); 
		romanValues.put("X", 10);
		romanValues.put("IX", 9);
		romanValues.put("V", 5); 
		romanValues.put("IV", 4);
		romanValues.put("I", 1);
		
		return romanValues;
	}
	
	public int toArabic(String inputNumeral) {
		int arabic = 0;
		LinkedHashMap<String, Integer> romanValues = getRomanValues();
		
		for (String keyNumeral: romanValues.keySet()) {
			while(inputNumeral.startsWith(keyNumeral)) {
				
					arabic += romanValues.get(keyNumeral);
					if(inputNumeral.length() - keyNumeral.length() == 0) {
						inputNumeral = "";
						break;
					}
					inputNumeral = inputNumeral.substring(0 + keyNumeral.length());
			}
		}
		
		
		return arabic;
	}
		
	public String toRomanNumerals(int arabic) {
		String romanNumerals = "";
		
		LinkedHashMap<String, Integer> romanCounters = getRomanCounters(arabic);
		
		for (String numeral: romanCounters.keySet()) {

			for(int i = 0; i < romanCounters.get(numeral); i++) {
				romanNumerals += numeral;		
			}
		}

		return romanNumerals;
	}
	
	public LinkedHashMap<String, Integer> getRomanCounters(int arabic){
		LinkedHashMap<String, Integer> romanCounters = new LinkedHashMap<String, Integer>();
		romanCounters.put("M", 0);
		romanCounters.put("CM", 0);
		romanCounters.put("D", 0);
		romanCounters.put("CD", 0);
		romanCounters.put("C", 0);
		romanCounters.put("XC", 0);
		romanCounters.put("L", 0);
		romanCounters.put("XL", 0);
		romanCounters.put("X", 0);
		romanCounters.put("IX", 0);
		romanCounters.put("V", 0);
		romanCounters.put("IV", 0);
		romanCounters.put("I", 0);
		
		LinkedHashMap<String, Integer> romanValues = getRomanValues(); 
		
		for(String numeral: romanValues.keySet()) {
			while(arabic - romanValues.get(numeral) >= 0) {
				romanCounters.put(numeral,  romanCounters.get(numeral) + 1);
				arabic -= romanValues.get(numeral);
			}
		}
		
		return romanCounters;
	}
	
	

}
