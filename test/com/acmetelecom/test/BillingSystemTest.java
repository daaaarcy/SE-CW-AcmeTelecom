/**
 * 
 */
package com.acmetelecom.test;

import org.junit.Test;

import com.acmetelecom.BillingSystem;
import com.acmetelecom.test.fakeobjects.FakeClock;

/**
 * @author farhanrahman
 *
 */
public class BillingSystemTest {
	@Test
	public void testForInitialSpecification(){
		FakeClock clock = new FakeClock(0);
		BillingSystem billingSystem = new BillingSystem();
        billingSystem.callInitiated("447722113434", "447766511332");
        clock.incrementTimeBy(20);
        billingSystem.callCompleted("447722113434", "447766511332");
        billingSystem.callInitiated("447722113434", "447711111111");
        clock.incrementTimeBy(30);
        billingSystem.callCompleted("447722113434", "447711111111");
        billingSystem.callInitiated("447777765432", "447711111111");
        clock.incrementTimeBy(60);
        billingSystem.callCompleted("447777765432", "447711111111");
        billingSystem.createCustomerBills();		
	}
}
