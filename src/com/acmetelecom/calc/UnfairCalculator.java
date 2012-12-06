package com.acmetelecom.calc;

import com.acmetelecom.Call;
import com.acmetelecom.DaytimePeakPeriod;
import com.acmetelecom.database.ITariff;
import org.joda.time.DateTime;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: Chuckie
 * Date: 03/12/12
 * Time: 17:26
 * <p/>
 * Any call that overlaps the peak time period is charged as a peak call.
 */
public class UnfairCalculator implements ICalculator
{
    @Override
    public BigDecimal calculateCost(Call call, ITariff tariff)
    {

        final DateTime callStart = new DateTime(call.startTime());

        BigDecimal cost;

        if (DaytimePeakPeriod.isOffPeak(callStart))
        {
            cost = new BigDecimal(call.durationSeconds()).multiply(tariff.offPeakRate());
        }
        else
        {
            cost = new BigDecimal(call.durationSeconds()).multiply(tariff.peakRate());
        }

        return cost;
    }
}
