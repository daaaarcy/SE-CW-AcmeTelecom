import java.math.BigDecimal;

import FakeClasses.FakeTariff;
import fit.ColumnFixture;

public class GivenTheFollowingTariff extends ColumnFixture {

    public String Name;
    public BigDecimal OffPeakPrice;
    public BigDecimal OnPeakPrice;
	
	@Override
	public void execute() {
		SystemUnderTest.tariffMap.put(Name, new FakeTariff(OnPeakPrice, OffPeakPrice));
	}

    @Override
    @SuppressWarnings("unchecked")
    public Object parse(String s, Class type) throws Exception {
        if (type == BigDecimal.class) {
            return new BigDecimal(s);
        }
        else {
            return super.parse(s, type);
        }
    }
}
