package com.kodilla.good.patterns.flight;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlightSearcher {

    private static FlightsMap flightsMap = FlightMapMaker.getFlightMap();

    void searchAllDeparture(Airport departureAirport) {
        flightsMap.getFlightMap().entrySet().stream()
                .filter(l -> l.getKey().equals(departureAirport))
                .flatMap(l -> l.getValue().stream())
                .forEach(System.out::println);
    }

    void searchAllArrival(Airport arrivalAirport) {
        flightsMap.getFlightMap().entrySet().stream()
                .filter(l -> l.getValue()
                        .stream()
                        .anyMatch(d -> d.equals(arrivalAirport)))
                .map(Map.Entry::getKey)
                .forEach(System.out::println);
    }

    void searchLinkedDeparture(Airport departureAirport, Airport arrivalAirport) {

        List<Airport> destFlight = flightsMap.getFlightMap().entrySet().stream()
                .filter(l -> l.getKey().equals(departureAirport))
                .flatMap(l -> l.getValue().stream())
                .collect(Collectors.toList());

        flightsMap.getFlightMap().entrySet().stream()
                .filter(d -> d.getValue().stream().anyMatch(l -> l.equals(arrivalAirport)))
                .filter(s -> destFlight.contains(s.getKey()))
                .map(Map.Entry::getKey)
                .forEach(System.out::println);
    }

}
