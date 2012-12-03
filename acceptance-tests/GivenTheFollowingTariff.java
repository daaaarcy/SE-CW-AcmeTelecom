import java.math.BigDecimal;

import FakeClasses.FakeTariff;
import fit.ColumnFixture;

public class GivenTheFollowingTariff extends ColumnFixture {

    public String Name;
    public BigDecimal OffPeakPrice;
    public BigDecimal OnPeakPrice;
	
	@Override
	public void reset() throws Exception {
		Name = null;
		OffPeakPrice = null;
		OnPeakPrice = null;
	}

	@Override
	public void execute() {
		SystemUnderTest.db.addTariff(Name, new FakeTariff(Name, OnPeakPrice, OffPeakPrice));
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
