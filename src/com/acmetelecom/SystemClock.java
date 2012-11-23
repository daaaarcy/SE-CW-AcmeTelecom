/**
 * 
 */
package com.acmetelecom;

import time.Clock;

/**
 * @author farhanrahman
 *
 */
public class SystemClock implements Clock{
	
	@Override
	public long currentTime() {
		return System.currentTimeMillis();
	}

}
