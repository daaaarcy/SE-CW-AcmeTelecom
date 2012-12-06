import fit.Fixture;
import fit.Parse;


public class GivenTheBillingSystemHasBeenInitialised extends Fixture
{

    @Override
    public void doTable(Parse p)
    {
        SystemUnderTest.printer.clearOutput();
        SystemUnderTest.db.clearDB();
    }
}
