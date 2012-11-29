package FakeClasses;
import com.acmetelecom.Printer;


public class FakePrinter implements Printer {
	
	private StringBuilder output = new StringBuilder();

	@Override
	public void printHeading(String name, String phoneNumber, String pricePlan) {
		output.append("Customer: " + phoneNumber + "\n");
	}

	@Override
	public void printItem(String time, String callee, String duration,
			String cost) {
		output.append("Call to " + callee + " at " + time + " for " +  duration + " = £" + cost + "\n");
	}

	@Override
	public void printTotal(String total) {
		output.append("Total Charge = £" + total + "\n");
	}
	
	public String output() {
		return output.toString();
	}
	
	public void clearOutput() {
		output = new StringBuilder();
	}

}
