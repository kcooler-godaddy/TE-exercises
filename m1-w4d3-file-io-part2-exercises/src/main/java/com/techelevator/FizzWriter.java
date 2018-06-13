package com.techelevator;

import java.io.*;

public class FizzWriter {

	public static void main(String[] args) throws IOException {
		String dirPath = "/Users/kcooler/Development/kevincooler-java-blue-exercises/m1-w4d3-file-io-part2-exercises";
		File file = new File(dirPath, "FizzBuzz.txt");
		
		file.createNewFile();
		
		if(file.exists() && file.isFile()) {
			try(PrintWriter printWriter = new PrintWriter(file);
					BufferedWriter bufferedWriter = new BufferedWriter(printWriter)){
				for (int i = 1; i <= 300; i++) {
					bufferedWriter.write(fizzBuzz(i) + "\n");
				}
			}
		}
		
		

	}
	
	public static String fizzBuzz(int number) {
		String result = "";
		String numStr = Integer.toString(number);
		
		if(number < 1 || number > 300) {
			return result;
		}
		
		if(number % 3 == 0 || numStr.contains("3")) {
			result += "Fizz";
		}
		
		if(number % 5 == 0 || numStr.contains("5")) {
			result += "Buzz";
		}
		
		if(result.equals("")) {
			result = numStr;
		}
		
		return result;
	}

}
