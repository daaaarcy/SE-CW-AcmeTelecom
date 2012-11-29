package com.acmetelecom.test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.acmetelecom.time.Clock;

public class TestClock implements Clock {
	
	private GregorianCalendar cal;
	
	public TestClock(int year, int month, int day) {
		this(year, month - 1, day, 0, 0, 0);
	}
	
	public TestClock(int year, int month, int day, String time) {
		String[] hrmins = time.split(":");
		
		cal = new GregorianCalendar(year, month - 1, day, Integer.parseInt(hrmins[0]), 
				Integer.parseInt(hrmins[1]), Integer.parseInt(hrmins[2]));
	}
	
	public TestClock(int year, int month, int day, int hr, int min, int sec) {		
		cal = new GregorianCalendar(year, month - 1, day, hr, min, sec);
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
