package com.acmetelecom.database;

import com.acmetelecom.customer.Customer;

public interface ICustomer
{
    String getPhoneNumber();

    String getFullName();

    String getPricePlan();

    Customer getExternalCustomer();
}
