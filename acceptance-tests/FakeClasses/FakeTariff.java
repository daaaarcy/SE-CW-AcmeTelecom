package FakeClasses;

import java.math.BigDecimal;

import com.acmetelecom.database.ITariff;

public class FakeTariff implements ITariff {
    private String name;
    private BigDecimal peakRate;
    private BigDecimal offPeakRate;

    public FakeTariff(String name, BigDecimal peakRate, BigDecimal offPeakRate) {
        this.name = name;
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

    @Override
    public String name() {
        return name;
    }

}
