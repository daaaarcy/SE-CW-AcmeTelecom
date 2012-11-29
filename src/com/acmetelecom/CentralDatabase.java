package com.acmetelecom;

import java.util.List;

import com.acmetelecom.customer.*;

public class CentralDatabase implements ICentralDatabase {
	@Override
	public List<Customer> getCustomers() {
		return CentralCustomerDatabase.getInstance().getCustomers();
	}

	@Override
	public Tariff tarriffFor(Customer customer) {
		return CentralTariffDatabase.getInstance().tarriffFor(customer);
	}

}
