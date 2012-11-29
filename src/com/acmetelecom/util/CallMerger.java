package com.acmetelecom.util;

import java.util.ArrayList;
import java.util.List;

import com.acmetelecom.Call;
import com.acmetelecom.CallEnd;
import com.acmetelecom.CallEvent;
import com.acmetelecom.CallStart;

public class CallMerger {
	/**
	 * 
	 * @param customerEvents
	 * @return
	 */
	public static List<Call> mergeCallEvents(List<CallEvent> customerEvents) {
		List<Call> calls = new ArrayList<Call>();

        CallEvent start = null;
        for (CallEvent event : customerEvents) {
            if (event instanceof CallStart) {
                start = event;
            }
            if (event instanceof CallEnd && start != null) {
                calls.add(new Call(start, event));
                start = null;
            }
        }
		return calls;
	}	
}
