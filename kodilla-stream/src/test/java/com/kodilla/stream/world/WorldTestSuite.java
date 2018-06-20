package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity() {
        //Given
        Country poland = new Country(new BigDecimal("23456565775"), "Poland");
        Country germany = new Country(new BigDecimal("4885783394899"), "Germany");
        Country china = new Country(new BigDecimal("550609049604343234206"), "China");
        Country japan = new Country(new BigDecimal("9834809834098"), "Japan");
        Country egypt = new Country(new BigDecimal("9834809834098"), "Egypt");
        Country keynia = new Country(new BigDecimal("394890239840"), "Egypt");
        Continent europe = new Continent("Europe");
        Continent asia = new Continent("Asia");
        Continent africa = new Continent("Africa");
        europe.addCountry(poland);
        europe.addCountry(germany);
        asia.addCountry(china);
        asia.addCountry(japan);
        africa.addCountry(egypt);
        africa.addCountry(keynia);
        World world = new World();
        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(africa);
        //When
        BigDecimal worldPopulation = poland.getPeopleQuantity()
                .add(germany.getPeopleQuantity())
                .add(china.getPeopleQuantity())
                .add(japan.getPeopleQuantity())
                .add(egypt.getPeopleQuantity())
                .add(keynia.getPeopleQuantity());
        //Then
        Assert.assertEquals(worldPopulation, world.getPeopleQuantity());
    }
}
