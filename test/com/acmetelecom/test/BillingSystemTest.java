/**
 * 
 */
package com.acmetelecom.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.acmetelecom.BillingSystem;
import com.acmetelecom.test.fakeobjects.FakeBillGenerator;

/**
 * @author farhanrahman
 *
 */
public class BillingSystemTest {
	@Test
	public void testForInitialSpecification(){
		TestClock clock = new TestClock(2012,1,1);
		FakeBillGenerator billGenerator = new FakeBillGenerator();
		BillingSystem billingSystem = new BillingSystem(clock, billGenerator);
        // 30 min off peak call before peak time - 6:20 to 6:50
        clock.incrementTime(6, 20, 0);
        billingSystem.callInitiated("447777765432", "447711111111");
        clock.incrementTime(0, 30, 0);
        billingSystem.callCompleted("447777765432", "447711111111");
        
        // 30 min off peak to peak border call - 6:50 to 7:20
        billingSystem.callInitiated("447777765432", "447711111111");
        clock.incrementTime(0, 30, 0);
        billingSystem.callCompleted("447777765432", "447711111111");
        
        // 30 min peak call - 7:20 to 7:50
        billingSystem.callInitiated("447777765432", "447711111111");
        clock.incrementTime(0, 30, 0);
        billingSystem.callCompleted("447777765432", "447711111111");
        
        // 30 min peak to off peak border call - 18:50 to 19:20
        clock.incrementTime(11, 0, 0);
        billingSystem.callInitiated("447777765432", "447711111111");
        clock.incrementTime(0, 30, 0);
        billingSystem.callCompleted("447777765432", "447711111111");
        
        // 30 min off peak call after peak time - 19:20 to 19:50
        billingSystem.callInitiated("447777765432", "447711111111");
        clock.incrementTime(0, 30, 0);
        billingSystem.callCompleted("447777765432", "447711111111");
        
        billingSystem.createCustomerBills();
        assertTrue(billGenerator.getSendPassed());
	}
}
