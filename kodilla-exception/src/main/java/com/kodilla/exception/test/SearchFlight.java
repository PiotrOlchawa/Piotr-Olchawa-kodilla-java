package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class SearchFlight {

    public boolean findFlight(Flight flight) throws RouteNotFoundException {

        Boolean sourceRouteAvailability = false;
        Boolean destinationRouteAvailability = false;
        String arrivalAirport = flight.getArrivalAirport();
        String departureAirport = flight.getDepartureAirport();

        Map<String, Boolean> airportAvailability = new HashMap<>();
        airportAvailability.put("Warszawa", true);
        airportAvailability.put("Kielce", false);
        airportAvailability.put("Poznań", true);
        airportAvailability.put("Lublin", false);

        if (!airportAvailability.containsKey(arrivalAirport)
                || !airportAvailability.containsKey(departureAirport)) {
            throw new RouteNotFoundException("Source or destination airport does not exist in database");
        } else {

            for (Map.Entry<String, Boolean> entrySet : airportAvailability.entrySet()) {

                String key = entrySet.getKey();
                Boolean value = entrySet.getValue();

                if (key.equals(arrivalAirport) && value) {
                    sourceRouteAvailability = true;
                }
                if (key.equals(departureAirport) && value) {
                    destinationRouteAvailability = true;
                }
            }
        }

        return sourceRouteAvailability && destinationRouteAvailability;
    }

    public static void main(String args[]) {

        Flight flight = new Flight("Warszawa", "Poznfań");
        SearchFlight searchFlight = new SearchFlight();
        try {
            if (searchFlight.findFlight(flight)) {
                System.out.println("Flight route found");
            } else {
                System.out.println("Source or destination airport not available !");
            }

        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("End of Search.");
        }

    }

}
