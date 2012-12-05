import com.acmetelecom.calc.ChargeByStartCalculator;
import fit.Fixture;
import fit.Parse;


public class UsingACalculatorThatChargesByStartingPeakRate extends Fixture {

    @Override
    public void doTable(Parse p) {
        SystemUnderTest.billingSystem.setCalculator(new ChargeByStartCalculator());
    }
}
