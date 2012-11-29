import FakeClasses.FakeCustomer;
import fit.ColumnFixture;

public class GivenTheFollowingCustomers extends ColumnFixture {

    public String Tariff;
    public String Number;
	
	@Override
	public void execute() {
		FakeCustomer cust = new FakeCustomer(Number, "Tom He", Tariff);
		SystemUnderTest.db.addCustomer(cust);
		SystemUnderTest.db.setTariff(cust, SystemUnderTest.tariffMap.get(Tariff));
	}
}
