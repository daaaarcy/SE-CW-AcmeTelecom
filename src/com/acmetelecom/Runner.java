package com.acmetelecom;

/**
 * Created with IntelliJ IDEA.
 * User: darcy
 * Date: 23/11/2012
 * Time: 11:12
 * To change this template use File | Settings | File Templates.
 */
public class Runner
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("Running...");
        BillingSystem billingSystem = new BillingSystem(new SystemClock());
        billingSystem.callInitiated("447722113434", "447766511332");
        sleepSeconds(20);
        billingSystem.callCompleted("447722113434", "447766511332");
        billingSystem.callInitiated("447722113434", "447711111111");
        sleepSeconds(30);
        billingSystem.callCompleted("447722113434", "447711111111");
        billingSystem.callInitiated("447777765432", "447711111111");
        sleepSeconds(60);
        billingSystem.callCompleted("447777765432", "447711111111");
        billingSystem.createCustomerBills();
    }

    private static void sleepSeconds(int n) throws InterruptedException
    {
        Thread.sleep(n * 1000);
    }
}
