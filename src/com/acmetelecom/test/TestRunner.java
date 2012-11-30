package com.acmetelecom.test;

import com.acmetelecom.BillingSystem;

public class TestRunner {
    public static void main(String[] args) throws Exception
    {
    	// init
    	TestClock clock = new TestClock(2012, 6, 15);
        BillingSystem billingSystem = new BillingSystem(clock);

        // 30 min off peak call before peak time - 6:20 to 6:50
    	String startString[] = "20:00:00".trim().split(":");
        clock.setTime(Integer.parseInt(startString[0]),
				  Integer.parseInt(startString[1]),
				  Integer.parseInt(startString[2]));
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
    }
}
