package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) throws FileNotFoundException {
		int lineCounter = 1;
		try(Scanner userInput = new Scanner(System.in)){
		
			System.out.println("Input the file path:");
			System.out.println(">>>");
			String path = userInput.nextLine();
			
			System.out.println("Should the search be case sensitive? (Y)es or (N)o.");
			System.out.println(">>>");
			String caseMatter = userInput.nextLine();
	
			System.out.println("Input the search word:");
			System.out.println(">>>");
			String word = userInput.nextLine();
		
		
			File file = new File(path);
			
			if (file.exists() && file.isFile()) {
				try(Scanner fileScanner = new Scanner(file)){
					while(fileScanner.hasNextLine()) {
						String line = fileScanner.nextLine();
						
						if(caseMatter.toLowerCase().equals("n")) {						//if case doesn't matters
							if(line.toLowerCase().contains(word.toLowerCase())){
								System.out.println("Line " + lineCounter + ": " + line);
							}
						}
						
						else if(line.contains(word)) {										//if case matters
							System.out.println("Line " + lineCounter + ": " + line);
						}
						lineCounter ++;
					}
				}
			} else {
				System.out.println("File could not be read; please try again.");
			}
		}

	}

}
