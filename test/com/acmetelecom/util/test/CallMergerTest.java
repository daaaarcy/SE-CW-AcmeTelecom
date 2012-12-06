package com.acmetelecom.util.test;

import com.acmetelecom.Call;
import com.acmetelecom.CallEnd;
import com.acmetelecom.CallEvent;
import com.acmetelecom.CallStart;
import com.acmetelecom.test.TestClock;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.acmetelecom.util.CallMerger.mergeCallEvents;
import static org.junit.Assert.assertTrue;

public class CallMergerTest
{


    @Test
    public void testCallMerger()
    {
        TestClock clock = new TestClock(2012, 1, 1);
        List<CallEvent> customerEvents = new ArrayList<CallEvent>();
        prepareCustomerEvents(customerEvents, clock);

        List<Call> calls = mergeCallEvents(customerEvents);

        assertTrue(customerEvents.size() % 2 == 0);
        assertTrue(calls.size() == customerEvents.size() / 2);
    }

    private void prepareCustomerEvents(List<CallEvent> customerEvents, TestClock clock)
    {
        clock.incrementTime(6, 20, 0);
        customerEvents.add(new CallStart("447777765432", "447711111111", clock));
        clock.incrementTime(0, 30, 0);
        customerEvents.add(new CallEnd("447777765432", "447711111111", clock));

        // 30 min off peak to peak border call - 6:50 to 7:20
        customerEvents.add(new CallStart("447777765432", "447711111111", clock));
        clock.incrementTime(0, 30, 0);
        customerEvents.add(new CallEnd("447777765432", "447711111111", clock));

        // 30 min peak call - 7:20 to 7:50
        customerEvents.add(new CallStart("447777765432", "447711111111", clock));
        clock.incrementTime(0, 30, 0);
        customerEvents.add(new CallEnd("447777765432", "447711111111", clock));

        // 30 min peak to off peak border call - 18:50 to 19:20
        clock.incrementTime(11, 0, 0);
        customerEvents.add(new CallStart("447777765432", "447711111111", clock));
        clock.incrementTime(0, 30, 0);
        customerEvents.add(new CallEnd("447777765432", "447711111111", clock));

        // 30 min off peak call after peak time - 19:20 to 19:50
        customerEvents.add(new CallStart("447777765432", "447711111111", clock));
        clock.incrementTime(0, 30, 0);
        customerEvents.add(new CallEnd("447777765432", "447711111111", clock));
    }
}
