package com.kodilla.good.patterns.Food2Door;

import java.util.Map;

class OrganicFreshFruitsFoodProducer extends FoodProducer {

    OrganicFreshFruitsFoodProducer(String foodProducerName, Map<String, Integer> producerAssortment) {
        super(foodProducerName, producerAssortment);
    }

    @Override
    boolean process(Map<String, Integer> orderList) {
        System.out.println("Processing " + super.getFoodProducerName() + "order.");
        return true;
    }

}
