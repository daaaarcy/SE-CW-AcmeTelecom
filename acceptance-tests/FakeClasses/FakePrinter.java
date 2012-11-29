package FakeClasses;
import com.acmetelecom.Printer;


public class FakePrinter implements Printer {

	@Override
	public void printHeading(String name, String phoneNumber, String pricePlan) {
		System.out.println("Customer: " + phoneNumber);
	}

	@Override
	public void printItem(String time, String callee, String duration,
			String cost) {
		System.out.println("Call to " + callee + " at " + time + " for " +  duration + " = " + cost);
	}

	@Override
	public void printTotal(String total) {
		System.out.println("Total Charge = " + total);
	}

}
