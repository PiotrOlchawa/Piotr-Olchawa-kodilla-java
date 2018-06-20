package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public class Continent {

    private final String continentName;
    private final List<Country> countryList = new ArrayList<>();

    public Continent(final String continentName) {
        this.continentName = continentName;
    }

    public List<Country> getCountryList() {
        return new ArrayList<>(countryList);
    }

    public void addCountry(Country country) {
        countryList.add(country);
    }

    public String getContinentName() {
        return continentName;
    }
}
