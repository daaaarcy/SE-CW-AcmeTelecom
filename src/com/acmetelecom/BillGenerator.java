package com.acmetelecom;

import com.acmetelecom.database.ICustomer;
import com.acmetelecom.generator.IBillGenerator;

import java.util.List;

public class BillGenerator implements IBillGenerator<BillingSystem.LineItem>{
	
	private Printer printer;
	
	public BillGenerator() {
		printer = HtmlPrinter.getInstance();
	}
	
	public BillGenerator(Printer printer) {
		this.printer = printer;
	}

    public void send(ICustomer customer, List<BillingSystem.LineItem> calls, String totalBill) {

        printer.printHeading(customer.getFullName(), customer.getPhoneNumber(), customer.getPricePlan());
        for (BillingSystem.LineItem call : calls) {
            printer.printItem(call.date(), call.callee(), call.durationMinutes(), MoneyFormatter.penceToPounds(call.cost()));
        }
        printer.printTotal(totalBill);
    }

}
