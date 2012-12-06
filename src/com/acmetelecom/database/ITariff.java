package com.acmetelecom.database;

import java.math.BigDecimal;

public interface ITariff
{
    String name();

    BigDecimal offPeakRate();

    BigDecimal peakRate();
}
