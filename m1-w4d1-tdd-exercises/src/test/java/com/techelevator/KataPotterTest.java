package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.HashMap;

public class KataPotterTest { 
	
	KataPotter kataPotter;
	
	@Before
	public void setup() {
		kataPotter = new KataPotter();
	}
	
	@Test
	public void return_$8_when_buy_just_1_of_any_book() {
		int[] firstBook = {1};
		int[] secondBook = {2};
		int[] thirdBook = {3};
		int[] fourthBook = {4};
		int[] fifthBook = {5};
		Assert.assertEquals(new BigDecimal(8.00),  new BigDecimal(kataPotter.getCost(firstBook)));
		Assert.assertEquals(new BigDecimal(8.00),  new BigDecimal(kataPotter.getCost(secondBook)));
		Assert.assertEquals(new BigDecimal(8.00),  new BigDecimal(kataPotter.getCost(thirdBook)));
		Assert.assertEquals(new BigDecimal(8.00),  new BigDecimal(kataPotter.getCost(fourthBook)));
		Assert.assertEquals(new BigDecimal(8.00),  new BigDecimal(kataPotter.getCost(fifthBook)));
	}
	
	@Test
	public void five_percent_discount_when_buy_2_different_books() {
		int[] first = {1, 2};
		int[] second = {2, 4};
		int[] third = {3, 5};
		Assert.assertEquals(new BigDecimal(15.20),  new BigDecimal(kataPotter.getCost(first)));
		Assert.assertEquals(new BigDecimal(15.20),  new BigDecimal(kataPotter.getCost(second)));
		Assert.assertEquals(new BigDecimal(15.20),  new BigDecimal(kataPotter.getCost(third)));
	}
	
	@Test
	public void ten_percent_discount_when_buy_3_different_books() {
		int[] first = {1, 2, 3};
		int[] second = {2, 4, 5};
		int[] third = {3, 5, 1};
		Assert.assertEquals(new BigDecimal(21.60),  new BigDecimal(kataPotter.getCost(first)));
		Assert.assertEquals(new BigDecimal(21.60),  new BigDecimal(kataPotter.getCost(second)));
		Assert.assertEquals(new BigDecimal(21.60),  new BigDecimal(kataPotter.getCost(third)));
	}
	
	@Test
	public void twenty_percent_discount_when_buy_4_different_books() {
		int[] first = {1, 2, 3, 4};
		int[] second = {2, 3, 4, 5};
		int[] third = {3, 4, 5, 1};
		Assert.assertEquals(new BigDecimal(25.60),  new BigDecimal(kataPotter.getCost(first)));
		Assert.assertEquals(new BigDecimal(25.60),  new BigDecimal(kataPotter.getCost(second)));
		Assert.assertEquals(new BigDecimal(25.60),  new BigDecimal(kataPotter.getCost(third)));
	}
	
	@Test
	public void twenty_five_percent_discount_when_buy_5_different_books() {
		int[] first = {1, 2, 3, 4, 5};
		Assert.assertEquals(new BigDecimal(30),  new BigDecimal(kataPotter.getCost(first)));
	}
	
	@Test
	public void return_8_times_number_of_books_for_repeat_copies() {
		int[] first = {1, 1};
		int[] second = {2, 2, 2};
		int[] third = {5, 5, 5, 5, 5, 5, 5, 5, 5};
		Assert.assertEquals(new BigDecimal(16),  new BigDecimal(kataPotter.getCost(first)));
		Assert.assertEquals(new BigDecimal(24),  new BigDecimal(kataPotter.getCost(second)));
		Assert.assertEquals(new BigDecimal(72),  new BigDecimal(kataPotter.getCost(third)));
	}
	
	@Test
	public void discount_only_applies_to_unique_book_set() {
		int[] first = {1, 1, 2};
		int[] second = {2, 2, 2, 3};
		int[] third = {3, 3, 3, 3, 4, 5};
		Assert.assertEquals(new BigDecimal(23.20),  new BigDecimal(kataPotter.getCost(first)));
		Assert.assertEquals(new BigDecimal(31.20),  new BigDecimal(kataPotter.getCost(second)));
		Assert.assertEquals(new BigDecimal(45.60),  new BigDecimal(kataPotter.getCost(third)));
	}
	
	@Test
	public void returns_true_when_has_set_of_5() {
		HashMap<Integer, Integer> bookQuantityMap = new HashMap<Integer, Integer>();
		bookQuantityMap.put(1,  1); 
		bookQuantityMap.put(2,  1); 
		bookQuantityMap.put(3,  1); 
		bookQuantityMap.put(4,  1); 
		bookQuantityMap.put(5,  1);

		Assert.assertTrue(kataPotter.hasSetOf(5, bookQuantityMap));
	}
	
	@Test
	public void returns_true_when_has_set_of_3() {
		HashMap<Integer, Integer> bookQuantityMap = new HashMap<Integer, Integer>();
		bookQuantityMap.put(1,  3); 
		bookQuantityMap.put(2,  0); 
		bookQuantityMap.put(3,  4); 
		bookQuantityMap.put(4,  0); 
		bookQuantityMap.put(5,  1);

		Assert.assertTrue(kataPotter.hasSetOf(3, bookQuantityMap));
	}
	
	@Test
	public void returns_map_without_keys_with_value_zero() {
		HashMap<Integer, Integer> originalMap = new HashMap<Integer, Integer>();
		originalMap.put(1,  3); 
		originalMap.put(2,  0); 
		originalMap.put(3,  4); 
		originalMap.put(4,  0); 
		originalMap.put(5,  1);
		
		HashMap<Integer, Integer> newMap = new HashMap<Integer, Integer>();
		newMap.put(1,  3); 
		newMap.put(3,  4); 
		newMap.put(5,  1);

		Assert.assertEquals(newMap, kataPotter.removeEmptyBooks(originalMap));
	}
	
	@Test
	public void returns_discout_multiplier_for_set_sizes() {
		Assert.assertEquals(new BigDecimal(1),  new BigDecimal(kataPotter.getDiscountMultiplier(1)));
		Assert.assertEquals(new BigDecimal(0.95),  new BigDecimal(kataPotter.getDiscountMultiplier(2)));
		Assert.assertEquals(new BigDecimal(0.90),  new BigDecimal(kataPotter.getDiscountMultiplier(3)));
		Assert.assertEquals(new BigDecimal(0.80),  new BigDecimal(kataPotter.getDiscountMultiplier(4)));
		Assert.assertEquals(new BigDecimal(0.75),  new BigDecimal(kataPotter.getDiscountMultiplier(5)));
		
	}
	
	@Test
	public void returns_map_of_quantity_of_each_book() {
		int[] books = {3, 4, 5, 1, 5, 5, 5};
		HashMap<Integer, Integer> testMap = new HashMap<Integer, Integer>();
		
		testMap.put(1,  1); 
		testMap.put(2,  0); 
		testMap.put(3,  1); 
		testMap.put(4,  1); 
		testMap.put(5,  4); 
		
		Assert.assertEquals(testMap, kataPotter.createBookQuantityMap(books));
	}
	
	@Test
	public void returns_map_of_set_quantity() {
		HashMap<Integer, Integer> bookQuantityMap = new HashMap<Integer, Integer>();
		bookQuantityMap.put(1,  5); 
		bookQuantityMap.put(2,  4); 
		bookQuantityMap.put(3,  3); 
		bookQuantityMap.put(4,  3); 
		bookQuantityMap.put(5,  2); 
		
		HashMap<Integer, Integer> setQuantityMap = new HashMap<Integer, Integer>();
		setQuantityMap.put(1,  1); 
		setQuantityMap.put(2,  1); 
		setQuantityMap.put(3,  0); 
		setQuantityMap.put(4,  1); 
		setQuantityMap.put(5,  2); 
		
		Assert.assertEquals(setQuantityMap, kataPotter.createSetQuantityMap(bookQuantityMap));
	}
	
	@Test
	public void trades_set_of_3_and_5_for_two_sets_of_4() {
		int[] first = {1, 1, 2, 2, 3, 3, 4, 5};
		Assert.assertEquals(new BigDecimal(51.2),  new BigDecimal(kataPotter.getCost(first)));
	}

} 
