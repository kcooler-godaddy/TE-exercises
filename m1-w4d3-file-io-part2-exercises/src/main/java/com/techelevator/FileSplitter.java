package com.techelevator;

import java.io.*;
import java.util.Scanner;

public class FileSplitter {

	public static void main(String[] args) throws IOException {
		
		int maxLines;
		String inputFilePath;
		
		try(Scanner in = new Scanner(System.in)){
			System.out.println("Enter the file path of .txt file: ");
			inputFilePath = in.nextLine();
			System.out.println("Enter the desired number of lines per file: ");
			maxLines = in.nextInt();
			in.nextLine();
		
		
			File inputFile = new File(inputFilePath);
			
			if(inputFile.exists() && inputFile.isFile()) {
				try(Scanner input = new Scanner(inputFile)){
					int fileCounter = 0;
					while(input.hasNextLine()) {
						fileCounter += 1;
						int lineCounter = 0;
						File currentWriteFile = new File(incrementFileName(inputFilePath, fileCounter));
						currentWriteFile.createNewFile();
						System.out.println(incrementFileName(inputFilePath, fileCounter));
						if (currentWriteFile.exists() && currentWriteFile.isFile()) {
							try(PrintWriter printWriter = new PrintWriter(currentWriteFile)){
								while(lineCounter < maxLines) {
									if(input.hasNextLine()) {
										lineCounter += 1;
										String line = input.nextLine();
										printWriter.println(line);
									}
									else break;
								}
							}
						}
					}
				}
			}
			else System.out.println("could not find file");
		}
	}
	
	public static String incrementFileName(String originalName, int increment) {
		String name = originalName.substring(0,  originalName.length() - 4);
		name += "-" + increment + ".txt";
		return name;
	}

}
