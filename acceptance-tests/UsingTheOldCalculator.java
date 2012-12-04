import com.acmetelecom.calc.NewCalculator;
import com.acmetelecom.calc.OldCalculator;
import fit.Fixture;
import fit.Parse;


public class UsingTheOldCalculator extends Fixture {

    @Override
    public void doTable(Parse p) {
        SystemUnderTest.billingSystem.setCalculator(new OldCalculator());
    }
}
