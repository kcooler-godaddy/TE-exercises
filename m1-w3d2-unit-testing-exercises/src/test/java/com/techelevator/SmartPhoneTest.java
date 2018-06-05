package com.techelevator;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class SmartPhoneTest {  
	
	private SmartPhone smartPhone;
	
	@Before
	public void setup() {
		smartPhone = new SmartPhone("614-123-4567", "Verizon");
	}
	
	@Test
	public void recharge_sets_battery_to_100() {
		smartPhone.RechargeBattery();
		Assert.assertEquals(100,  smartPhone.getBatteryCharge());
	}
	
	@Test
	public void cannot_talk_longer_than_battery_allows() {
		Assert.assertFalse(smartPhone.Call("6141231234",  120));
	}
	
	@Test
	public void cannot_call_number_without_10_digits() {
		Assert.assertFalse(smartPhone.Call("1234567",  20));
	}
	
	@Test
	public void cannot_call_number_with_more_than_10_digits() {
		Assert.assertFalse(smartPhone.Call("12345678912345",  20));
	}
	
	@Test
	public void battery_accuracy_after_10_minute_call() {
		smartPhone.Call("6141234567",  10);
		Assert.assertEquals(90,  smartPhone.getBatteryCharge());
	}
	
	@Test
	public void after_answer_phone_hangUp_makes_onCall_false() {
		smartPhone.AnswerPhone();
		smartPhone.HangUp();
		Assert.assertFalse(smartPhone.isOnCall());
	}
	
	@Test 
	public void repeated_hang_up_keeps_onCall_false() {
		smartPhone.HangUp();
		smartPhone.HangUp();
		smartPhone.HangUp();
		Assert.assertFalse(smartPhone.isOnCall());
	}

}
