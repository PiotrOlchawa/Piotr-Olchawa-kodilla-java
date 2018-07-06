package com.kodilla.good.patterns.flight;

public class Application {

    public static void main(String args[]) {
        Airport searchAllArrivalAirport = new Airport("Warsaw");
        Airport searchAllDepartureAirport = new Airport("New York");

        FlightSearcher flightSearcher = new FlightSearcher();

        flightSearcher.searchAllArrival(searchAllArrivalAirport);
        flightSearcher.searchAllDeparture(searchAllArrivalAirport);
        flightSearcher.searchLinkedDeparture(searchAllArrivalAirport,searchAllDepartureAirport);
    }


}
