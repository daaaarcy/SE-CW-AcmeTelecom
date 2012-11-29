package com.acmetelecom;

import org.joda.time.DateTime;

import java.util.Calendar;

public class DaytimePeakPeriod
{
    // Start hour of peak period.
    public final static int start = 7;

    // End hour of peak period.
    public final static int end = 19;

    /**
     * Returns true if give time if off-peak, otherwise false.
     */
    public static boolean isOffPeak(DateTime time)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time.toDate());
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        return hour < start || hour >= end;
    }

    /**
     * Returns duration of peak period in seconds.
     */
    public static int peakDurationInSec()
    {
        return (end - start) * 3600;
    }
}
