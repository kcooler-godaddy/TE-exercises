package com.techelevator;

public class HomeworkAssignment {
	
	//instance variables
	private int totalMarks;
	private int possibleMarks;
	private String submitterName;
	
	//constructor
	public HomeworkAssignment(int possibleMarks) {
		this.possibleMarks = possibleMarks;
	}
	
	//getters and setters
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	public String getSubmitterName() {
		return submitterName;
	}
	public void setSubmitterName(String submitterName) {
		this.submitterName = submitterName;
	}
	public int getPossibleMarks() {
		return possibleMarks;
	}
	public String getLetterGrade() {
		double numGrade = ((double)totalMarks / (double)possibleMarks) * 100;
		if (numGrade >= 90) return "A";
		else if (numGrade >= 80) return "B";
		else if (numGrade >= 70) return "C";
		else if (numGrade >= 60) return "D";
		else return "F";
	}
	

	

	
	
	

}
