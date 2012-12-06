package com.acmetelecom;

import com.acmetelecom.time.Clock;

public class CallEnd extends CallEvent
{
    public CallEnd(String caller, String callee, Clock clock)
    {
        super(caller, callee, clock.currentTime());
    }
}
