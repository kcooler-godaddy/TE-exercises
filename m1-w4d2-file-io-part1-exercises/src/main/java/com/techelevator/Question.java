package com.techelevator;

import java.util.ArrayList;

public class Question {
	
	private String question;
	private ArrayList<String> responses = new ArrayList<String>();
	private int answerIndex;
	
	public Question(String questionSignature) {
		String[] questionArray = questionSignature.split("\\|");
		this.question = questionArray[0];
		
		for(int i = 1; i < questionArray.length; i++) {
			if(questionArray[i].endsWith("*")) {
				 String fixed = questionArray[i].substring(0, questionArray.length - 1);
				 if (fixed.endsWith("*")) fixed = fixed.substring(0,  fixed.length() - 1);
				 questionArray[i] = fixed;
				answerIndex = i;
			} 
			responses.add(questionArray[i]);
		}
	}

	public String getQuestion() {
		return question;
	}

	public ArrayList<String> getResponses() {
		return responses;
	}

	public int getAnswerIndex() {
		return answerIndex;
	}

}
