package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class World {

    private final List<Continent> continentList = new ArrayList<>();

    public BigDecimal getPeopleQuantity() {
        BigDecimal totalPopulation = continentList.stream()
                .flatMap(cont -> cont.getCountryList().stream())
                .map(l -> l.getPeopleQuantity())
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
        return totalPopulation;
    }

    public void addContinent(Continent continent) {
        continentList.add(continent);
    }

}
