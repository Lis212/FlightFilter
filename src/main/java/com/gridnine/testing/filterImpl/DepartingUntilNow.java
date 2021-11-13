package com.gridnine.testing.filterImpl;

import com.gridnine.testing.filter.FlightFilter;
import com.gridnine.testing.flight.Flight;
import com.gridnine.testing.flight.Segment;

import java.time.LocalDateTime;

public class DepartingUntilNow implements FlightFilter {
    @Override
    public boolean filterOut(Flight flight) {
        for (Segment segment : flight.getSegments()) {
            if (segment.getDepartureDate().isBefore(LocalDateTime.now())) return true;
        }
        return false;
    }
}
