package com.acmetelecom.util;

import com.acmetelecom.Call;
import com.acmetelecom.DaytimePeakPeriod;
import com.acmetelecom.customer.Tariff;
import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator
{
    private static final int secondsInADay = 86400;
    private static final int secondsInAnHour = 3600;

    /**
     * Calculates the cost of the call under the given tariff.
     */
    public static BigDecimal calculateCost(Call call, Tariff tariff)
    {
        final DateTime callStart = new DateTime(call.startTime());
        final DateTime callEnd = new DateTime(call.endTime());

        // Durations are all in seconds.
        int peakCallDuration = 0;
        final int totalCallDuration = call.durationSeconds();
        final int callStartInSeconds = callStart.getSecondOfDay();

        if (DaytimePeakPeriod.isOffPeak(callStart))
        {
            final int peakTimeStartSecondOfDay = DaytimePeakPeriod.start * secondsInAnHour;
            int fromCallStartToPeakStart = peakTimeStartSecondOfDay - callStartInSeconds;

            fromCallStartToPeakStart = (secondsInADay + fromCallStartToPeakStart) % secondsInADay;

            if (fromCallStartToPeakStart < totalCallDuration)
            {
                int d = totalCallDuration - fromCallStartToPeakStart;
                peakCallDuration = Math.min(DaytimePeakPeriod.peakDurationInSec(), d);
            }
        }
        else
        {
            final int callEndInSeconds = callEnd.getSecondOfDay();

            final int fromCallStartToPeakEnd = DaytimePeakPeriod.end * secondsInAnHour - callStartInSeconds;
            final int fromCallEndToPeakEnd = DaytimePeakPeriod.end * secondsInAnHour - callEndInSeconds;

            peakCallDuration = fromCallStartToPeakEnd;

            if (callEndInSeconds >= callStartInSeconds)
            {
                if (fromCallEndToPeakEnd >= 0)
                {
                    peakCallDuration -= fromCallEndToPeakEnd;
                }
            }
            else
            {
                final int fromPeakStartToCallEnd = callEndInSeconds - DaytimePeakPeriod.start * secondsInAnHour;
                if (fromPeakStartToCallEnd >= 0)
                {
                    peakCallDuration += fromPeakStartToCallEnd;
                }
            }
        }

        BigDecimal peakCost = new BigDecimal(peakCallDuration).multiply(tariff.peakRate());
        BigDecimal offPeakCost = new BigDecimal(totalCallDuration - peakCallDuration).multiply(tariff.offPeakRate());
        BigDecimal cost =  peakCost.add(offPeakCost).setScale(0, RoundingMode.HALF_UP);

        return cost;
    }
}
