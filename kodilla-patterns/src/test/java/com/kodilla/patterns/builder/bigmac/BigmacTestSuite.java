package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class BigmacTestSuite {

    @Test
    public void testBigmac() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .ingredient("pieczarki")
                .ingredient("cebula")
                .sauce("standard")
                .burgers(2)
                .bun("bun")
                .build();
        //When
        int howManyIngredients = bigmac.getIngredients().size();  //Contains default ingredients
        int burgers = bigmac.getBurgers();
        //Then
        Assert.assertEquals(3, howManyIngredients);
        Assert.assertEquals(2,burgers);
    }
}
