package FakeClasses;

import com.acmetelecom.customer.Customer;
import com.acmetelecom.database.ICustomer;

public class FakeCustomer implements ICustomer {
	private String phoneNumber;
	private String fullName;
	private String pricePlan;
	
	public FakeCustomer(String phoneNumber, String fullName, String pricePlan) {
		this.phoneNumber = phoneNumber;
		this.fullName = fullName;
		this.pricePlan = pricePlan;
	}
	
	@Override
	public String getPhoneNumber() {
		return phoneNumber;
	}

	@Override
	public String getFullName() {
		return fullName;
	}

	@Override
	public String getPricePlan() {
		return pricePlan;
	}

	@Override
	public Customer getExternalCustomer() {
		return null;
	}

}
