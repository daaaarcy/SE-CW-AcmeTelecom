package com.acmetelecom;

import static com.acmetelecom.util.Calculator.calculateCost;
import static com.acmetelecom.util.CallMerger.mergeCallEvents;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.acmetelecom.generator.IBillGenerator;
import com.acmetelecom.time.Clock;


public class BillingSystem {

    private List<CallEvent> callLog = new ArrayList<CallEvent>();
    private Clock clock;
    private IBillGenerator<LineItem> generator;
    private ICentralDatabase database;

    /**
     * Default constructor that initialises the variables.
     */
    public BillingSystem(){
    	this(new SystemClock(), new BillGenerator());
    }
    
    /**
     * Temporary constructor to make other code passing in Clock
     * as a constructor parameter to work.
     * @param clock
     */
    public BillingSystem(Clock clock){
    	this(clock, new BillGenerator(), new CentralDatabase());
    }
    
    public BillingSystem(Clock clock, IBillGenerator<LineItem> generator) {
    	this(clock, generator, new CentralDatabase());
    }

    public BillingSystem(Clock clock, IBillGenerator<LineItem> generator, ICentralDatabase db) {
    	this.clock = clock;
    	this.generator = generator;
    	this.database = db;
	}

	public void callInitiated(String caller, String callee) {
        callLog.add(new CallStart(caller, callee, clock));
    }

    public void callCompleted(String caller, String callee) {
        callLog.add(new CallEnd(caller, callee, clock));
    }

    public void createCustomerBills() {
        List<ICustomer> customers = database.getCustomers();
        for (ICustomer customer : customers) {
            createBillFor(customer);
        }
        callLog.clear();
    }

    private void createBillFor(ICustomer customer) {
        List<CallEvent> customerEvents = new ArrayList<CallEvent>();
        for (CallEvent callEvent : callLog) {
            if (callEvent.getCaller().equals(customer.getPhoneNumber())) {
                customerEvents.add(callEvent);
            }
        }

        List<Call> calls = mergeCallEvents(customerEvents);

        BigDecimal totalBill = new BigDecimal(0);
        List<LineItem> items = new ArrayList<LineItem>();

        for (Call call : calls) {
            ITariff tariff = database.tarriffFor(customer);

            BigDecimal cost = calculateCost(call, tariff);
            totalBill = totalBill.add(cost);
            items.add(new LineItem(call, cost));
        }

        this.generator.send(customer, items, MoneyFormatter.penceToPounds(totalBill));
    }

    public static class LineItem {
        private Call call;
        private BigDecimal callCost;

        public LineItem(Call call, BigDecimal callCost) {
            this.call = call;
            this.callCost = callCost;
        }

        public String date() {
            return call.date();
        }

        public String callee() {
            return call.callee();
        }

        public String durationMinutes() {
            return "" + call.durationSeconds() / 60 + ":" + String.format("%02d", call.durationSeconds() % 60);
        }

        public BigDecimal cost() {
            return callCost;
        }
    }
}
