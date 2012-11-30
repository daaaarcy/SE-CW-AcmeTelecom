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
        //6:00 to 20:00
        checkForCost(6, 14, 2, 12);
    }


    @Test
    public void testForCalls1()
    {
        //7:00 to 19:00
        checkForCost(7, 12, 0, 12);
    }

    @Test
    public void testForCalls2()
    {
        //9:00 to 15:00
        checkForCost(9, 6, 0, 6);
    }

    @Test
    public void testForCalls3()
    {
        //9:00 to 20:00
        checkForCost(9, 11, 1, 10);
    }

    @Test
    public void testForCalls4()
    {
        //9:00 to 6:00
        checkForCost(9, 21, 11, 10);
    }

    @Test
    public void testForCalls5()
    {
        //9:00 to 8:00
        checkForCost(9,23,12,11);
    }
    
    private void checkForCost(int startTime, int duration, int offPeakTime, int peakTime){
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
