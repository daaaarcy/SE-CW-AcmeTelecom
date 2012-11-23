import fit.ColumnFixture;

import java.math.BigDecimal;

public class GivenTheFollowingTariff extends ColumnFixture {

    public String Name;
    public BigDecimal OffPeakPrice;
    public BigDecimal OnPeakPrice;

	@Override
	public void reset() {

	}
	
	@Override
	public void execute() {
	}

    @Override
    @SuppressWarnings("rawtypes")
    public Object parse(String s, Class type) throws Exception {
        if (type == BigDecimal.class) {
            return new BigDecimal(s);
        }
        else {
            return super.parse(s, type);
        }
    }
}
