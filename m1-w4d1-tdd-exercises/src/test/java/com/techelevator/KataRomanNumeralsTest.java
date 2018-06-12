package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.LinkedHashMap;

public class KataRomanNumeralsTest {
	
	KataRomanNumerals kata;
	
	@Before
	public void setup() {
		kata = new KataRomanNumerals();
	}
	
	@Test
	public void returns_I_for_1(){
		Assert.assertEquals("I",  kata.toRomanNumerals(1));
	}
	@Test
	public void returns_V_for_5(){
		Assert.assertEquals("V",  kata.toRomanNumerals(5));
	}
	@Test
	public void returns_X_for_10(){
		Assert.assertEquals("X",  kata.toRomanNumerals(10));
	}
	@Test
	public void returns_L_for_50(){
		Assert.assertEquals("L",  kata.toRomanNumerals(50));
	}
	@Test
	public void returns_C_for_100(){
		Assert.assertEquals("C",  kata.toRomanNumerals(100));
	}
	@Test
	public void returns_D_for_500(){
		Assert.assertEquals("D",  kata.toRomanNumerals(500));
	}
	@Test
	public void returns_M_for_1000(){
		Assert.assertEquals("M",  kata.toRomanNumerals(1000));
	}
	
	@Test
	public void returns_map_of_roman_numeral_counts_in_263() {
		int arabic = 263;
		LinkedHashMap<String, Integer> tester = new LinkedHashMap<String, Integer>();
		tester.put("M", 0);
		tester.put("CM", 0);
		tester.put("D", 0);
		tester.put("CD", 0);
		tester.put("C", 2);
		tester.put("XC", 0);
		tester.put("L", 1);
		tester.put("XL", 0);
		tester.put("X", 1); 
		tester.put("IX", 0); 
		tester.put("V", 0);
		tester.put("IV", 0);
		tester.put("I", 3);
		
		Assert.assertEquals(tester, kata.getRomanCounters(arabic));
	}
	@Test
	public void returns_IV_for_4(){
		Assert.assertEquals("IV",  kata.toRomanNumerals(4));
	}
	@Test
	public void returns_IX_for_9(){
		Assert.assertEquals("IX",  kata.toRomanNumerals(9));
	}
	@Test
	public void returns_CCCLXIX_for_369(){
		Assert.assertEquals("CCCLXIX",  kata.toRomanNumerals(369));
	}
	@Test
	public void returns_MCMXCVIII_for_1998(){
		Assert.assertEquals("MCMXCVIII",  kata.toRomanNumerals(1998));
	}
	
	@Test
	public void returns_1000_for_M(){
		Assert.assertEquals(new Integer(1000), new Integer(kata.toArabic("M")));
	}
	@Test
	public void returns_1998_for_MCMXCVIII(){
		Assert.assertEquals(new Integer(1998), new Integer(kata.toArabic("MCMXCVIII")));
	}
	@Test
	public void returns_369_for_CCCLXIX(){
		Assert.assertEquals(new Integer(369), new Integer(kata.toArabic("CCCLXIX")));
	}

}
