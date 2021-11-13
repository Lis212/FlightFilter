package com.gridnine.testing.filterImpl;

import com.gridnine.testing.filter.FlightFilter;
import com.gridnine.testing.flight.Flight;
import com.gridnine.testing.flight.Segment;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class MoreThanTwoHoursGroundTime implements FlightFilter {
    @Override
    public boolean filterOut(Flight flight) {
        long groundTime = 0;
        if (flight.getSegments().size() > 1) {
            List<Segment> segments = flight.getSegments();
            for (int i = 0; i < segments.size() - 1; i++) {
                LocalDateTime arrivalDate = segments.get(i).getArrivalDate();
                LocalDateTime departureDate = segments.get(i + 1).getDepartureDate();
                long betweenSeconds = Duration.between(arrivalDate, departureDate).getSeconds();
                groundTime += betweenSeconds / 60;
            }
            return groundTime / 60 >= 2;
        }
        return false;
    }
}
