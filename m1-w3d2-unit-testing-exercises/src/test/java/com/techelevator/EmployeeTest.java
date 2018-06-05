package com.techelevator;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class EmployeeTest {
	
	private Employee employee;
	
	@Before
	public void setup() {
		employee = new Employee(123, "Kevin", "Cooler", 50000.0); 
	}
	
	@Test
	public void is_salaray_correct_after_10_percent_raise() {
		employee.RaiseSalary(10);
		Double newSalary = employee.getAnnualSalary();
		Double check = 55000d;
		Assert.assertEquals(check, newSalary);
	} 
	
	@Test
	public void is_salaray_correct_after_0_percent_raise() {
		employee.RaiseSalary(0);
		Double newSalary = employee.getAnnualSalary();
		Double check = 50000d;
		Assert.assertEquals(check, newSalary);
	}
	
	@Test
	public void is_salaray_correct_after_negative_10_percent_raise() {
		employee.RaiseSalary(-10);
		Double newSalary = employee.getAnnualSalary();
		Double check = 45000d;
		Assert.assertEquals(check, newSalary);
	}

}
