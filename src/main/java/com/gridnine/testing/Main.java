package com.gridnine.testing;

import com.gridnine.testing.filterImpl.DepartingUntilNow;
import com.gridnine.testing.filterImpl.DepartsUntilArrives;
import com.gridnine.testing.filterImpl.MoreThanTwoHoursGroundTime;
import com.gridnine.testing.flight.Flight;
import com.gridnine.testing.flight.FlightBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        System.out.println("Flights that have departed until now.");
        flights.stream()
                .filter(new DepartingUntilNow()::filterOut)
                .forEach(System.out::println);
        System.out.println("Flights that have segments departing before arrival.");
        flights.stream()
                .filter(new DepartsUntilArrives()::filterOut)
                .forEach(System.out::println);
        System.out.println("Flights with a time on the ground for more than two hours.");
        flights.stream()
                .filter(new MoreThanTwoHoursGroundTime()::filterOut)
                .forEach(System.out::println);
    }
}
