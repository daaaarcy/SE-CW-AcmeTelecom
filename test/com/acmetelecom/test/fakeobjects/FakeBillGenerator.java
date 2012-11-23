/**
 * 
 */
package com.acmetelecom.test.fakeobjects;

import java.math.BigDecimal;
import java.util.List;

import com.acmetelecom.BillingSystem;
import com.acmetelecom.BillingSystem.LineItem;
import com.acmetelecom.customer.Customer;
import com.acmetelecom.generator.IBillGenerator;

/**
 * @author farhanrahman
 *
 */
public class FakeBillGenerator implements IBillGenerator<BillingSystem.LineItem>{

	private boolean sendPassed = false;
	
	@Override
	public void send(Customer customer, List<LineItem> calls, String totalBill) {
        System.out.println("Customer name: " + customer.getFullName() 
        		+ " Customer phone number: " + customer.getPhoneNumber() 
        		+ " Price plan: " + customer.getPricePlan());
        for (BillingSystem.LineItem call : calls) {
            System.out.println("Date: " + call.date() + " Callee: " + call.callee() + " Duration mins: " + call.durationMinutes()
            		+ " Cost: " + this.penceToPounds(call.cost()));
        }
        System.out.println(totalBill);	
        sendPassed = true;
	}
	
	/**
	 * 
	 * @return if the test passed then this will return true
	 * otherwise will return false
	 */
	public boolean getSendPassed(){
		return this.sendPassed;
	}
	
	public String penceToPounds(BigDecimal cost){
        BigDecimal pounds = cost.divide(new BigDecimal(100));
        return String.format("%.2f", pounds.doubleValue());
	}

}
