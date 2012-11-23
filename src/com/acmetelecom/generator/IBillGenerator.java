/**
 * 
 */
package com.acmetelecom.generator;

import java.util.List;

import com.acmetelecom.customer.Customer;

/**
 * Generic bill generator taking generic type
 * of ListContent.
 * @author farhanrahman
 *
 */
public interface IBillGenerator <ListContent> {
	/**
	 * Classes implementing this method should be able to
	 * generate a bill and output it in any form
	 * @param customer
	 * @param calls : this is a list of ListContent types
	 * @param totalBill
	 */
	public void send(Customer customer, List<ListContent> calls, String totalBill);
}