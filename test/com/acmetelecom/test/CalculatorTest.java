/**
 * 
 */
package com.acmetelecom.test;

import static com.acmetelecom.util.Calculator.calculateCost;
import static com.acmetelecom.util.CallMerger.mergeCallEvents;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.acmetelecom.Call;
import com.acmetelecom.CallEnd;
import com.acmetelecom.CallEvent;
import com.acmetelecom.CallStart;
import com.acmetelecom.database.CentralDatabase;
import com.acmetelecom.database.ICustomer;
import com.acmetelecom.database.ITariff;

/**
 * @author farhanrahman
 *
 */
public class CalculatorTest {
	private static final double EPSILON = 0.001;
	
	@Test
	public void testForCalls0(){
		TestClock clock = new TestClock(2012,1,1);
		List<CallEvent> customerEvents = new ArrayList<CallEvent>();
		clock.incrementTime(6, 0, 0);
		/*Peak time between 7 & 19*/
        // 30 min off peak to peak border call - 6:00 to 20:00
        customerEvents.add(new CallStart("447777765432", "447711111111", clock));
        clock.incrementTime(14, 0, 0);
        customerEvents.add(new CallEnd("447777765432", "447711111111", clock));
        
        CentralDatabase db = new CentralDatabase();
        List<ICustomer> customers = db.getCustomers();
        List<Call> calls = mergeCallEvents(customerEvents);
        
        for(ICustomer customer : customers){
        	if(customer.getPhoneNumber().equalsIgnoreCase("447777765432")){
        		ITariff tariff = db.tarriffFor(customer);
        		double cost = calculateCost(calls.get(0), tariff).doubleValue();
        		double expected = 2.0*3600*tariff.offPeakRate().doubleValue() + 12.0*3600*tariff.peakRate().doubleValue();
        		System.out.println(cost);
        		System.out.println(expected);
        		assertEquals(expected, cost, EPSILON);
        		break;
        	}
        }
        
	}	
}
