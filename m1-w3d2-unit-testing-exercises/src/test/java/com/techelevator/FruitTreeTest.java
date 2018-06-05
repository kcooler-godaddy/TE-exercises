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
		//Arrange
		//Act
		String fruitType = fruitTree.getTypeOfFruit();
		//Assert
		Assert.assertEquals("Fruit tree has wrong type of fruit", "Orange", fruitType);
		
	}
	
	@Test
	public void verify_fruit_tree_starts_with_20_fruits() {
		//arrange
		//act with assert
		Assert.assertEquals(20,  fruitTree.getPiecesOfFruitLeft());
	}
	
	@Test
	public void pick_5_fruits() {
		//arrange
		//act
		boolean success = fruitTree.PickFruit(5); 
		//assert
		Assert.assertTrue(success);
		Assert.assertEquals(15,  fruitTree.getPiecesOfFruitLeft());
	}
	
	@Test
	public void pick_more_than_available_fruit() {
		//arrange
		fruitTree.PickFruit(10);
		//act
		boolean success = fruitTree.PickFruit(11);
		//assert
		Assert.assertFalse(success);
		Assert.assertEquals(10, fruitTree.getPiecesOfFruitLeft());
	}

}
