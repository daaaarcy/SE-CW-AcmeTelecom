package com.acmetelecom;

import java.util.*;

import com.acmetelecom.customer.*;

public class CentralDatabase implements ICentralDatabase {
	@Override
	public List<ICustomer> getCustomers() {
		List<Customer> customers = CentralCustomerDatabase.getInstance().getCustomers();
		List<ICustomer> databaseCustomers = new ArrayList<ICustomer>();
		
		for (Customer customer : customers) {
			databaseCustomers.add(new DatabaseCustomer(customer));
		}
		
		return databaseCustomers;
	}

	@Override
	public ITariff tarriffFor(ICustomer customer) {
		return new DatabaseTariff(CentralTariffDatabase
				.getInstance().tarriffFor(customer.getExternalCustomer()));
	}
}
