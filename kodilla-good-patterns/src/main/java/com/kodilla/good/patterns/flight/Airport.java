package com.kodilla.good.patterns.flight;

public class Airport {

private String airportName;

    public Airport(String airportName) {
        this.airportName = airportName;
    }

    public String getAirportName() {
        return airportName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airport airport = (Airport) o;

        return airportName != null ? airportName.equals(airport.airportName) : airport.airportName == null;
    }

    @Override
    public int hashCode() {
        return airportName != null ? airportName.hashCode() : 0;
    }

    @Override
    public String toString() {
        return  airportName ;
    }
}
