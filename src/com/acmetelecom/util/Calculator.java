package com.acmetelecom.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.acmetelecom.Call;
import com.acmetelecom.DaytimePeakPeriod;
import com.acmetelecom.customer.Tariff;

public class Calculator {
	/**
	 * 
	 * @param call
	 * @param tariff
	 * @return
	 */
	public static BigDecimal calculateCost(Call call, Tariff tariff) {
		BigDecimal cost;

		DaytimePeakPeriod peakPeriod = new DaytimePeakPeriod();
		if (peakPeriod.offPeak(call.startTime()) && peakPeriod.offPeak(call.endTime()) && call.durationSeconds() < 12 * 60 * 60) {
		    cost = new BigDecimal(call.durationSeconds()).multiply(tariff.offPeakRate());
		} else {
		    cost = new BigDecimal(call.durationSeconds()).multiply(tariff.peakRate());
		}

		cost = cost.setScale(0, RoundingMode.HALF_UP);
		return cost;
	}
}
