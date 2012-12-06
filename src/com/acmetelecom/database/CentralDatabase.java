package com.acmetelecom.database;

import com.acmetelecom.customer.CentralCustomerDatabase;
import com.acmetelecom.customer.CentralTariffDatabase;
import com.acmetelecom.customer.Customer;

import java.util.ArrayList;
import java.util.List;

public class CentralDatabase implements ICentralDatabase
{
    @Override
    public List<ICustomer> getCustomers()
    {
        List<Customer> customers = CentralCustomerDatabase.getInstance().getCustomers();
        List<ICustomer> databaseCustomers = new ArrayList<ICustomer>();

        for (Customer customer : customers)
        {
            databaseCustomers.add(new DatabaseCustomer(customer));
        }

        return databaseCustomers;
    }

    @Override
    public ITariff tarriffFor(ICustomer customer)
    {
        return new DatabaseTariff(CentralTariffDatabase
                .getInstance().tarriffFor(customer.getExternalCustomer()));
    }
}
