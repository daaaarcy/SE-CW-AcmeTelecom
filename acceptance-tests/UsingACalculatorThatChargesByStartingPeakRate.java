import com.acmetelecom.calc.UnfairCalculator;
import fit.Fixture;
import fit.Parse;


public class UsingACalculatorThatChargesByStartingPeakRate extends Fixture
{

    @Override
    public void doTable(Parse p)
    {
        SystemUnderTest.billingSystem.setCalculator(new UnfairCalculator());
    }
}
