package com.techelevator;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class FruitTreeTest {

	private FruitTree fruitTree;
	
	@Before
	public void setup() {
		fruitTree = new FruitTree("Orange", 20);
	}
	
	@Test
	public void verify_fruit_tree_has_oranges() {
		// Arrange
		// Act
		String fruitType = fruitTree.getTypeOfFruit();
		// Assert
		Assert.assertEquals("Fruit Tree has wrong type of Fruit", "Orange", fruitType);
	}
	
	@Test
	public void verify_fruit_tree_starts_with_20_fruits() {
		// Arrange
		// Act
		// Act with an Assert
		Assert.assertEquals(20, fruitTree.getPiecesOfFruitLeft());
	}
	
	@Test
	public void pick_5_fruits() {
		// Arrange
		// Act
		boolean success = fruitTree.PickFruit(5);
		// Assert
		Assert.assertTrue(success);
		Assert.assertEquals(15, fruitTree.getPiecesOfFruitLeft());
	}
	
	@Test
	public void pick_more_than_available_fruit() {
		// Arrange
		fruitTree.PickFruit(10);
		// Act
		boolean success = fruitTree.PickFruit(11);
		// Assert
		Assert.assertFalse(success);
		Assert.assertEquals(10, fruitTree.getPiecesOfFruitLeft());
	}
	
	@Test
	public void pick_all_the_fruit() {
		Assert.assertTrue(fruitTree.PickFruit(20));
		Assert.assertEquals(0,  fruitTree.getPiecesOfFruitLeft());
		
	}
	
	@Test
	public void pick_negative_fruit() {
		Assert.assertFalse(fruitTree.PickFruit(-1));
		Assert.assertEquals(20, fruitTree.getPiecesOfFruitLeft());
	}
}
