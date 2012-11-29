package com.acmetelecom;

import org.joda.time.DateTime;

import java.util.Calendar;
import java.util.Date;

public class DaytimePeakPeriod
{
    public final static int start = 7;
    public final static int end = 19;

    public static boolean isOffPeak(DateTime time)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time.toDate());
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        return hour < start || hour >= end;
    }

    /**
     * Returns duration of off-peak in seconds.
     */
    public static int peakDurationInSec()
    {
        return (end - start) * 3600;
    }
}
