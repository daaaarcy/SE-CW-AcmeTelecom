package FakeClasses;

import java.math.BigDecimal;

import com.acmetelecom.database.ITariff;

public class FakeTariff implements ITariff {
	private BigDecimal peakRate;
	private BigDecimal offPeakRate;
	
	public FakeTariff(BigDecimal peakRate, BigDecimal offPeakRate) {
		this.peakRate = peakRate;
		this.offPeakRate = offPeakRate;
	}
	
	@Override
	public BigDecimal offPeakRate() {
		return offPeakRate;
	}

	@Override
	public BigDecimal peakRate() {
		return peakRate;
	}
	
}
