package com.techelevator;

import org.junit.*;

public class FileSplitterTest {
	
	FileSplitter splitter = new FileSplitter();
	
	@Test
	public void incrementsFileName() {
		Assert.assertEquals("input-1.txt", splitter.incrementFileName("input.txt",  1));
	}

}
