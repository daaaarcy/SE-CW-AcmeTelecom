import com.acmetelecom.calc.NewCalculator;
import fit.Fixture;
import fit.Parse;


public class UsingTheNewCalculator extends Fixture {

    @Override
    public void doTable(Parse p) {
        SystemUnderTest.billingSystem.setCalculator(new NewCalculator());
    }
}
