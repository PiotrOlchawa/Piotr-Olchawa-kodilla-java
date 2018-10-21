package com.kodilla.patterns2.decorator.pizza;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class PizzaOrderTestSuite {

    @Test
    public void testBasicPizzaOrderGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizza();

        //When
        BigDecimal theCost = pizzaOrder.getCost();

        //Then
        Assert.assertEquals(new BigDecimal(15), theCost);
    }

    @Test
    public void testBasicPizzaOrderGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizza();

        //When
        String description = pizzaOrder.getDescription();

        //Then
        Assert.assertEquals("Pizza with tomato sauce and cheese", description);
    }

    @Test
    public void testLargePizzaOrderGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizza();
        pizzaOrder = new LargePizzaDecorator(pizzaOrder);

        //When
        BigDecimal theCost = pizzaOrder.getCost();

        //Then
        Assert.assertEquals(new BigDecimal(35), theCost);
    }

    @Test
    public void testLargePizzaOrderGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizza();
        pizzaOrder = new LargePizzaDecorator(pizzaOrder);

        //When
        String description = pizzaOrder.getDescription();

        //Then
        Assert.assertEquals("Pizza with tomato sauce and cheese size: large", description);
    }

    @Test
    public void testMediumPizzaOrderWithExtraCheeseGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizza();
        pizzaOrder = new MediumPizzaDecorator(pizzaOrder);
        pizzaOrder = new AdditionalMushroomsDecorator(pizzaOrder);

        //When
        BigDecimal theCost = pizzaOrder.getCost();

        //Then
        Assert.assertEquals(new BigDecimal(33), theCost);
    }

    @Test
    public void testMediumPizzaOrderWithExtraCheeseGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizza();
        pizzaOrder = new MediumPizzaDecorator(pizzaOrder);
        pizzaOrder = new AdditionalMushroomsDecorator(pizzaOrder);

        //When
        String description = pizzaOrder.getDescription();

        //Then
        Assert.assertEquals("Pizza with tomato sauce and cheese size: medium with mushrooms", description);
    }
}
