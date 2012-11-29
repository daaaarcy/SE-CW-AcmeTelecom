
import java.util.HashMap;
import java.util.Map;

import FakeClasses.FakeDatabase;
import FakeClasses.FakePrinter;
import FakeClasses.FakeTariff;

import com.acmetelecom.BillGenerator;
import com.acmetelecom.BillingSystem;
import com.acmetelecom.test.TestClock;

/**
 * Created with IntelliJ IDEA.
 * User: Chuckie
 * Date: 29/11/12
 * Time: 11:21
 * To change this template use File | Settings | File Templates.
 */
public class SystemUnderTest {
	private static final int fakeday = 15;
    private static final int fakemonth = 6;
    private static final int fakeyear = 2012;

	public static final TestClock clock = new TestClock(fakeday, fakemonth, fakeyear);
    public static final FakePrinter printer = new FakePrinter();
    public static final FakeDatabase db = new FakeDatabase();
    public static final BillingSystem billingSystem = new BillingSystem(clock, new BillGenerator(printer), db);
    
    public static final Map<String, FakeTariff> tariffMap = new HashMap<String, FakeTariff>();

}
