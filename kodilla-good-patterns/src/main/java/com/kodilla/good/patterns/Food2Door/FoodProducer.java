package com.kodilla.good.patterns.Food2Door;

import java.util.Map;

abstract class FoodProducer {

    private String foodProducerName;
    private Map<String, Integer> producerAssortment;

    FoodProducer(String foodProducerName, Map<String, Integer> producerAssortment) {
        this.foodProducerName = foodProducerName;
        this.producerAssortment = producerAssortment;
    }

    String getFoodProducerName() {
        return foodProducerName;
    }

    abstract boolean process(Map<String, Integer> orderList);

}
