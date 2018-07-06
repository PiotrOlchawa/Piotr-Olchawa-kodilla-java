package com.kodilla.good.patterns.flight;

import java.util.Arrays;

public class FlightMapMaker {

    private static FlightsMap flightsMap = new FlightsMap();

    static {
        flightsMap.addToFlightMap(new Airport("Warsaw"), Arrays.asList(new Airport("Paris"), new Airport("London"), new Airport("Praha")));
        flightsMap.addToFlightMap(new Airport("Paris"), Arrays.asList(new Airport("Praha"), new Airport("Warsaw"), new Airport("London")));
        flightsMap.addToFlightMap(new Airport("London"), Arrays.asList(new Airport("New York"), new Airport("Boston"), new Airport("Warsaw")));
        flightsMap.addToFlightMap(new Airport("Moscow"), Arrays.asList(new Airport("New York"), new Airport("Chicago")));

    }

    static FlightsMap getFlightMap() {

        return flightsMap;
    }
}
