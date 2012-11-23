package com.acmetelecom.test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.acmetelecom.time.Clock;

public class TestClock implements Clock {
	
	private GregorianCalendar cal;
	
	public TestClock(int year, int month, int day) {
		cal = new GregorianCalendar(year, month - 1, day, 0, 0, 0);
	}

	@Override
	public long currentTime() {
		return cal.getTimeInMillis();
	}
	
	public void incrementTime(int hour, int min, int sec) {
		cal.add(Calendar.HOUR_OF_DAY, hour);
		cal.add(Calendar.MINUTE, min);
		cal.add(Calendar.SECOND, sec);
	}

}
