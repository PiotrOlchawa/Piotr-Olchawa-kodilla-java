package com.kodilla.good.patterns.flight;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightsMap {

    private Map<Airport,List<Airport>> flightMap = new HashMap<>();

    void addToFlightMap(Airport airport,List<Airport> airportList){
        flightMap.put(airport,airportList);
    }

    public Map<Airport, List<Airport>> getFlightMap() {
        return flightMap;
    }
}
