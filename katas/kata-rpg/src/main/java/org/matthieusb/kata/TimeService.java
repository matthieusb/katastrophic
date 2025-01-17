package org.matthieusb.kata;

import java.time.Clock;
import java.time.ZoneOffset;

public class TimeService {
    private Clock clock;

    public TimeService(Clock clock) {
        this.clock = clock;
    }

    public Integer calculateCurrentSeconds() {
        return getClock().instant().atZone(ZoneOffset.UTC).toLocalDateTime().getSecond();
    }

    public Integer calculateCurrentMinutes() {
        return getClock().instant().atZone(ZoneOffset.UTC).toLocalDateTime().getMinute();
    }

    public Clock getClock() {
        return this.clock;
    }
}
