/**
 *
 */
package com.acmetelecom.test;

import com.acmetelecom.Call;
import com.acmetelecom.CallEnd;
import com.acmetelecom.CallEvent;
import com.acmetelecom.CallStart;
import com.acmetelecom.database.CentralDatabase;
import com.acmetelecom.database.ICustomer;
import com.acmetelecom.database.ITariff;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.acmetelecom.util.Calculator.calculateCost;
import static com.acmetelecom.util.CallMerger.mergeCallEvents;
import static org.junit.Assert.assertEquals;

/**
 * @author farhanrahman
 */
public class CalculatorTest
{
    private static final double EPSILON = 0.001;

    @Test
    public void testForCalls0()
    {
        int startTime = 6;
        int duration = 14;
        int offPeakTime = 2;
        int peakTime = 12;
        //6:00 to 20:00
        checkForCost(startTime, duration, offPeakTime, peakTime);
    }


    @Test
    public void testForCalls1()
    {
        int startTime = 7;
        int duration = 12;
        int offPeakTime = 0;
        int peakTime = 12;
        //7:00 to 19:00
        checkForCost(startTime, duration, offPeakTime, peakTime);
    }

    @Test
    public void testForCalls2()
    {
        int startTime = 9;
        int duration = 6;
        int offPeakTime = 0;
        int peakTime = 6;
        //9:00 to 15:00
        checkForCost(startTime, duration, offPeakTime, peakTime);
    }

    @Test
    public void testForCalls3()
    {
        int startTime = 9;
        int duration = 11;
        int offPeakTime = 1;
        int peakTime = 10;
        //9:00 to 20:00
        checkForCost(startTime, duration, offPeakTime, peakTime);
    }

    @Test
    public void testForCalls4()
    {
        int startTime = 9;
        int duration = 21;
        int offPeakTime = 11;
        int peakTime = 10;
        //9:00 to 6:00
        checkForCost(startTime, duration, offPeakTime, peakTime);
    }

    @Test
    public void testForCalls5()
    {
        int startTime = 9;
        int duration = 23;
        int offPeakTime = 12;
        int peakTime = 11;
        //9:00 to 8:00
        checkForCost(startTime, duration, offPeakTime, peakTime);
    }

    @Test
    public void testForCalls6()
    {
        int startTime = 6;
        int duration = 6;
        int offPeakTime = 1;
        int peakTime = 5;
        //6:00 to 12:00
        checkForCost(startTime, duration, offPeakTime, peakTime);
    }

    @Test
    public void testForCalls7()
    {
        int startTime = 5;
        int duration = 1;
        int offPeakTime = 1;
        int peakTime = 0;
        //5:00 to 6:00
        checkForCost(startTime, duration, offPeakTime, peakTime);
    }

    @Test
    public void testForCalls8()
    {
        int startTime = 6;
        int duration = 23;
        int offPeakTime = 11;
        int peakTime = 12;
        //6:00 to 5:00
        checkForCost(startTime, duration, offPeakTime, peakTime);
    }

    @Test
    public void testForCalls9()
    {
        int startTime = 20;
        int duration = 3;
        int offPeakTime = 3;
        int peakTime = 0;
        //20:00 to 23:00
        checkForCost(startTime, duration, offPeakTime, peakTime);
    }

    @Test
    public void testForCalls10()
    {
        int startTime = 20;
        int duration = 9;
        int offPeakTime = 9;
        int peakTime = 0;
        //20:00 to 5:00
        checkForCost(startTime, duration, offPeakTime, peakTime);
    }

    @Test
    public void testForCalls11()
    {
        int startTime = 20;
        int duration = 16;
        int offPeakTime = 11;
        int peakTime = 5;
        //20:00 to 12:00
        checkForCost(startTime, duration, offPeakTime, peakTime);
    }

    @Test
    public void testForCalls12()
    {
        int startTime = 23;
        int duration = 21;
        int offPeakTime = 9;
        int peakTime = 12;
        //23:00 to 20:00
        checkForCost(startTime, duration, offPeakTime, peakTime);
    }

    @Test
    public void testForCalls13()
    {
        int startTime = 6;
        int duration = 17;
        int offPeakTime = 5;
        int peakTime = 12;
        //6:00 to 23:00
        checkForCost(startTime, duration, offPeakTime, peakTime);
    }

    @Test
    public void testForCalls14()
    {
        int startTime = 6;
        int duration = 24;
        int offPeakTime = 12;
        int peakTime = 12;
        //6:00 to 6:00
        checkForCost(startTime, duration, offPeakTime, peakTime);
    }

    @Test
    public void testForCalls15()
    {
        int startTime = 10;
        int duration = 24;
        int offPeakTime = 12;
        int peakTime = 12;
        //10:00 to 10:00
        checkForCost(startTime, duration, offPeakTime, peakTime);
    }

    @Test
    public void testForCalls16()
    {
        int startTime = 20;
        int duration = 24;
        int offPeakTime = 12;
        int peakTime = 12;
        //20:00 to 20:00
        checkForCost(startTime, duration, offPeakTime, peakTime);
    }

    private void checkForCost(int startTime, int duration, int offPeakTime, int peakTime)
    {
        TestClock clock = new TestClock(2012, 1, 1);
        List<CallEvent> customerEvents = new ArrayList<CallEvent>();
        clock.incrementTime(startTime, 0, 0);
        /*Peak time between 7 & 19*/
        customerEvents.add(new CallStart("447777765432", "447711111111", clock));
        clock.incrementTime(duration, 0, 0);
        customerEvents.add(new CallEnd("447777765432", "447711111111", clock));

        CentralDatabase db = new CentralDatabase();
        List<ICustomer> customers = db.getCustomers();
        List<Call> calls = mergeCallEvents(customerEvents);

        for (ICustomer customer : customers)
        {
            if (customer.getPhoneNumber().equalsIgnoreCase("447777765432"))
            {
                ITariff tariff = db.tarriffFor(customer);
                double cost = calculateCost(calls.get(0), tariff).doubleValue();
                double expected = offPeakTime * 3600 * tariff.offPeakRate().doubleValue() + peakTime * 3600 * tariff.peakRate().doubleValue();
                assertEquals(expected, cost, EPSILON);
                break;
            }
        }
    }

}
