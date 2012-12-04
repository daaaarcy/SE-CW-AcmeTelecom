package FakeClasses;

import java.util.*;

import com.acmetelecom.database.ICentralDatabase;
import com.acmetelecom.database.ICustomer;
import com.acmetelecom.database.ITariff;

public class FakeDatabase implements ICentralDatabase {
    private List<ICustomer> customers = new ArrayList<ICustomer>();
    private HashMap<String, ITariff> tariffMap = new HashMap<String, ITariff>();

    @Override
    public List<ICustomer> getCustomers() {
        return customers;
    }

    public void addCustomer(ICustomer customer) {
        customers.add(customer);
    }

    public void addTariff(String tariffName, ITariff tariff) {
        tariffMap.put(tariffName, tariff);
    }

    @Override
    public ITariff tarriffFor(ICustomer customer) {
        return tariffMap.get(customer.getPricePlan());
    }

    public void clearDB() {
        customers.clear();
        tariffMap.clear();
    }
}
