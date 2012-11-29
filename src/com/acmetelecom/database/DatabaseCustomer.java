package com.acmetelecom.database;

import com.acmetelecom.customer.Customer;

public class DatabaseCustomer implements ICustomer {
	private Customer customer;
	
	public DatabaseCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@Override
	public String getPhoneNumber() {
		return customer.getPhoneNumber();
	}
	
	@Override
	public Customer getExternalCustomer() {
		return customer;
	}

	@Override
	public String getFullName() {
		return customer.getFullName();
	}

	@Override
	public String getPricePlan() {
		return customer.getPricePlan();
	}
}
