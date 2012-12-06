/**
 *
 */
package com.acmetelecom.generator;

import com.acmetelecom.database.ICustomer;

import java.util.List;

/**
 * Generic bill generator taking generic type
 * of ListContent.
 *
 * @author farhanrahman
 */
public interface IBillGenerator<ListContent>
{
    /**
     * Classes implementing this method should be able to
     * generate a bill and output it in any form
     *
     * @param customer
     * @param calls     : this is a list of ListContent types
     * @param totalBill
     */
    public void send(ICustomer customer, List<ListContent> calls, String totalBill);
}
