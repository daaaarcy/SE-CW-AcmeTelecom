package com.acmetelecom;

import java.util.List;

import com.acmetelecom.customer.*;

public interface ICentralDatabase {
	List<Customer> getCustomers();
	Tariff tarriffFor(Customer customer);
}
