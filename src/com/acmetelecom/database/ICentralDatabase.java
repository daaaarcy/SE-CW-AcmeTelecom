package com.acmetelecom.database;

import java.util.List;

public interface ICentralDatabase {
	List<ICustomer> getCustomers();
	ITariff tarriffFor(ICustomer customer);
}
