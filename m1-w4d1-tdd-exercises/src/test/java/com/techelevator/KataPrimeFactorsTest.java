package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class KataPrimeFactorsTest {
	
	KataPrimeFactors kata;
	
	@Before
	public void setup() {
		kata = new KataPrimeFactors();
	}
	
	@Test
	public void returns_2_for_2() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(2);
		
		Assert.assertEquals(testList,  kata.factorize(2));
	}
	@Test
	public void returns_3_for_3() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(3);
		
		Assert.assertEquals(testList,  kata.factorize(3));
	}
	@Test
	public void returns_2_3_for_6() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(2);
		testList.add(3);
		
		Assert.assertEquals(testList,  kata.factorize(6));
	}
	@Test
	public void returns_2_2_for_4() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(2);
		testList.add(2);
		
		Assert.assertEquals(testList,  kata.factorize(4));
	}
	@Test
	public void returns_2_2_2_for_8() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(2);
		testList.add(2);
		testList.add(2);
		
		Assert.assertEquals(testList,  kata.factorize(8));
	}
	
	@Test
	public void returns_2_2_3_for_12() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(2);
		testList.add(2);
		testList.add(3);
		
		Assert.assertEquals(testList,  kata.factorize(12));
	}
	
	@Test
	public void returns_2_3_7_23_for_966() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(2);
		testList.add(3);
		testList.add(7);
		testList.add(23);
		
		Assert.assertEquals(testList,  kata.factorize(966));
	}
	
	@Test
	public void returns_true_for_prime_numbers() {
		Assert.assertTrue(kata.isPrime(2));
		Assert.assertTrue(kata.isPrime(5));
		Assert.assertTrue(kata.isPrime(23));
		Assert.assertTrue(kata.isPrime(31));
	}
	
	@Test
	public void returns_false_for_compound_numbers() {
		Assert.assertFalse(kata.isPrime(4));
		Assert.assertFalse(kata.isPrime(12));
		Assert.assertFalse(kata.isPrime(40));
		Assert.assertFalse(kata.isPrime(108));
	}
	
	@Test
	public void returns_factors_2_3_for_6() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(2);
		testList.add(3);
		
		Assert.assertEquals(testList,  kata.getTwoFactors(6));
	}
	
	@Test
	public void returns_factors_3_5_for_15() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(3);
		testList.add(5);
		
		Assert.assertEquals(testList,  kata.getTwoFactors(15));
	}
	
	@Test
	public void returns_factors_2_12_for_24() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(2);
		testList.add(12);
		
		Assert.assertEquals(testList,  kata.getTwoFactors(24));
	}
	
	@Test
	public void returns_factors_empty_for_7() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		
		Assert.assertEquals(testList,  kata.getTwoFactors(7));
	}
	
	

}
