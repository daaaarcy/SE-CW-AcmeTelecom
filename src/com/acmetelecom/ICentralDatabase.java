package com.acmetelecom;

import java.util.List;

import com.acmetelecom.customer.*;

public interface ICentralDatabase {
	List<ICustomer> getCustomers();
	ITariff tarriffFor(ICustomer customer);
}
