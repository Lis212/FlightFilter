package com.gridnine.testing.filterImpl;

import com.gridnine.testing.filter.FlightFilter;
import com.gridnine.testing.flight.Flight;
import com.gridnine.testing.flight.Segment;

public class DepartsUntilArrives implements FlightFilter {
    @Override
    public boolean filterOut(Flight flight) {
        for (Segment segment : flight.getSegments()) {
            if (segment.getArrivalDate().isBefore(segment.getDepartureDate())) return true;
        }
        return false;
    }
}
