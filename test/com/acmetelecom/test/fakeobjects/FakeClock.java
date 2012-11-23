/**
 * 
 */
package com.acmetelecom.test.fakeobjects;

import com.acmetelecom.time.Clock;

/**
 * @author farhanrahman
 *
 */
public class FakeClock implements Clock {
	private long time;

	/**Default constructor taking an initial
	 * time parameter
	 * */
	public FakeClock(long initTime){
		this.time = initTime;
	}
	
	/**
	 * Returns the current time of the clock. (Time needs to be incremented
	 * by separate provided method avaialble to unit test classes)
	 */
	@Override
	public long currentTime() {
		return this.time;
	}
	
	/**
	 * Setter function for this.time.
	 * @param time
	 */
	public void setTime(long time){
		this.time = time;
	}
	
	/**
	 * Increments the time by delta.
	 * @param delta
	 */
	public void incrementTimeBy(long delta){
		this.time += delta;
	}
}
