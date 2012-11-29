package com.acmetelecom;

import java.math.BigDecimal;

public interface ITariff {
	BigDecimal offPeakRate();
	BigDecimal peakRate();
}
