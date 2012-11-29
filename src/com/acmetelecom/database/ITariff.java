package com.acmetelecom.database;

import java.math.BigDecimal;

public interface ITariff {
	BigDecimal offPeakRate();
	BigDecimal peakRate();
}
