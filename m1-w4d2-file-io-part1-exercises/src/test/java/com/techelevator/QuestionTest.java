package com.techelevator;
import java.util.ArrayList;

import org.junit.*;

public class QuestionTest {
	
	Question question;
	
	@Test
	public void constructor_returns_all_values() {
		ArrayList<String> testResp = new ArrayList<String>();
		testResp.add("Yellow");
		testResp.add("Blue");
		testResp.add("Green");
		testResp.add("Red");
		
		question = new Question("What color is the sky?|Yellow|Blue*|Green|Red");
		
		Assert.assertEquals("What color is the sky?", question.getQuestion());
		Assert.assertEquals(new Integer(2), new Integer(question.getAnswerIndex()));
		Assert.assertEquals(testResp, question.getResponses());
	}
	
	@Test
	public void constructor_returns_all_values_for_second() {
		ArrayList<String> testResp = new ArrayList<String>();
		testResp.add("hair brush");
		testResp.add("dry erase marker");
		testResp.add("mop");
		testResp.add("yo-yo");
		
		question = new Question("A skeleton walks into a bar, and says to the bartender, \"Give me a beer and a ...\"|hair brush|dry erase marker|mop*|yo-yo");
		
		Assert.assertEquals(new Integer(3), new Integer(question.getAnswerIndex()));
		Assert.assertEquals(testResp, question.getResponses());
	}

}
