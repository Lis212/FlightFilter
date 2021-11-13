import com.gridnine.testing.filterImpl.DepartingUntilNow;
import com.gridnine.testing.filterImpl.DepartsUntilArrives;
import com.gridnine.testing.filterImpl.MoreThanTwoHoursGroundTime;
import com.gridnine.testing.flight.Flight;
import com.gridnine.testing.flight.FlightBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MainTest {
    List<Flight> flights;

    @BeforeEach
    void setUp() {
        flights = FlightBuilder.createFlights();
    }

    @Test
    @DisplayName("Test for depart until now")
    void DepartingUntilNowFilterTest() {
        long expected = 1;
        long actual = flights.stream().filter(new DepartingUntilNow()::filterOut).count();
        Assertions.assertTrue(expected == actual);
    }

    @Test
    @DisplayName("Test for depart until arrive")
    void DepartsUntilArriveFilterTest() {
        long expected = 1;
        long actual = flights.stream().filter(new DepartsUntilArrives()::filterOut).count();
        Assertions.assertTrue(expected == actual);
    }

    @Test
    @DisplayName("Test for depart until now")
    void moreThanTwoHoursGroundTimeFilterTest() {
        long expected = 2;
        long actual = flights.stream().filter(new MoreThanTwoHoursGroundTime()::filterOut).count();
        Assertions.assertTrue(expected == actual);
    }
}
