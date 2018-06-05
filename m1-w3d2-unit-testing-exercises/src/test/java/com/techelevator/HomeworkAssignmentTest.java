package com.techelevator;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class HomeworkAssignmentTest { 
	
	private HomeworkAssignment hw;
	
	@Before
	public void setup() {
		hw = new HomeworkAssignment(100); 
	}
	
	@Test 
	public void a_95_returns_A() {
		hw.setTotalMarks(95);
		Assert.assertEquals("A",  hw.getLetterGrade());
	}
	
	@Test 
	public void a_100_returns_A() {
		hw.setTotalMarks(100);
		Assert.assertEquals("A",  hw.getLetterGrade());
	}
	
	@Test 
	public void a_90_returns_A() {
		hw.setTotalMarks(90);
		Assert.assertEquals("A",  hw.getLetterGrade());
	}
	
	@Test 
	public void a_50_returns_F() {
		hw.setTotalMarks(50);
		Assert.assertEquals("F",  hw.getLetterGrade());
	}
	
	@Test 
	public void a_60_returns_D() {
		hw.setTotalMarks(60);
		Assert.assertEquals("D",  hw.getLetterGrade());
	}
	
	@Test 
	public void a_75_returns_C() {
		hw.setTotalMarks(75);
		Assert.assertEquals("C",  hw.getLetterGrade());
	}
	
	@Test 
	public void a_85_returns_B() {
		hw.setTotalMarks(85);
		Assert.assertEquals("B",  hw.getLetterGrade());
	}
	
	@Test
	public void invalid_total_marks_value() {
		hw.setTotalMarks(-5);
		Assert.assertEquals(0,  hw.getTotalMarks());
	}

}
