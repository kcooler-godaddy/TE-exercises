package com.techelevator;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class TelevisionTest {
	
	private Television tv;
	
	@Before
	public void setup() {
		tv = new Television();
	}
	
	@Test
	public void lowest_volume_is_0() {
		tv.TurnOn();
		for (int i = 0; i < 20; i++) {
			tv.LowerVolume();
		}
		Assert.assertEquals(0,  tv.getCurrentVolume());
	}
	
	@Test
	public void highest_volume_is_10() {
		tv.TurnOn();
		for (int i = 0; i < 20; i++) {
			tv.RaiseVolume();
		}
		Assert.assertEquals(10,  tv.getCurrentVolume());
	}
	
	@Test
	public void volume_resets_to_0_when_turned_on() {
		tv.TurnOn();
		for (int i = 0; i < 5; i++) {
			tv.RaiseVolume();
		}
		tv.TurnOff();
		tv.TurnOn();
		Assert.assertEquals(0,  tv.getCurrentVolume());
	}
	
	@Test
	public void cannot_change_channel_when_off() {
		tv.TurnOff();
		tv.ChangeChannel(8);
		Assert.assertEquals(3,  tv.getSelectedChannel());
	}
	
	@Test
	public void change_channel_to_18_when_on() {
		tv.TurnOn();
		tv.ChangeChannel(18);
		Assert.assertEquals(18,  tv.getSelectedChannel());
	}
	
	@Test
	public void cannot_change_channel_higher_than_18() {
		tv.TurnOn();
		tv.ChangeChannel(20);
		Assert.assertFalse(tv.getSelectedChannel() == 20);
	}
	
	@Test
	public void cannot_change_channel_lower_than_3() {
		tv.TurnOn();
		tv.ChangeChannel(2);
		Assert.assertFalse(tv.getSelectedChannel() == 2);
	}

}
 