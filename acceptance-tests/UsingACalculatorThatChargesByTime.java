import com.acmetelecom.calc.ChargeByTimeCalculator;
import fit.Fixture;
import fit.Parse;


public class UsingACalculatorThatChargesByTime extends Fixture
{

    @Override
    public void doTable(Parse p)
    {
        SystemUnderTest.billingSystem.setCalculator(new ChargeByTimeCalculator());
    }
}
