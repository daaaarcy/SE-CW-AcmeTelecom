/**
 *
 */
package com.acmetelecom.test.fakeobjects;

import com.acmetelecom.BillingSystem;
import com.acmetelecom.BillingSystem.LineItem;
import com.acmetelecom.database.ICustomer;
import com.acmetelecom.generator.IBillGenerator;

import java.util.List;

/**
 * @author farhanrahman
 */
public class FakeBillGenerator implements IBillGenerator<BillingSystem.LineItem>
{

    private boolean sendPassed = false;

    @Override
    public void send(ICustomer customer, List<LineItem> calls, String totalBill)
    {
        sendPassed = true;
    }

    /**
     * @return if the test passed then this will return true
     *         otherwise will return false
     */
    public boolean getSendPassed()
    {
        return this.sendPassed;
    }
}
