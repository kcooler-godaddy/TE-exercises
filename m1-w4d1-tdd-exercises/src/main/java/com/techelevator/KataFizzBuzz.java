package com.techelevator;

/***
 * 
 * @author brianlauvray
 *
 */
public class KataFizzBuzz {

	private final static int FIZZABLE = 3;
	private final static int BUZZABLE = 5;
	private final static int RANGE_FLOOR = 1;
	private final static int RANGE_CEILING = 100;
	private final static String FIZZ = "Fizz";
	private final static String BUZZ = "Buzz";
	
	/***
	 * 
	 * @param value
	 * @return
	 */
	public String fizzBuzz(int value) {
		
		String returnValue = "";
		
		if (value < RANGE_FLOOR || value > RANGE_CEILING) {
			return returnValue;
		}
			
		if (isDivisibleBy(FIZZABLE, value) || containsDigit(FIZZABLE, value)) {
			returnValue += FIZZ;
		}
		
		if (isDivisibleBy(BUZZABLE, value) || containsDigit(BUZZABLE, value)) {
			returnValue += BUZZ;
		}
		
		return returnValue.length() < 1 ? String.valueOf(value) : returnValue;

	}
	
	private boolean isDivisibleBy(int multiple, int number) {
		return number % multiple == 0;
	}
	
	private boolean containsDigit(int digit, int number) {
		return String.valueOf(number).contains(String.valueOf(digit));
	}
	
}
