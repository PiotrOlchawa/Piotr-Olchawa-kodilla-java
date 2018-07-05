package com.kodilla.good.patterns.Food2Door;

import java.util.Map;

public class OrderRequest {

    private Map<String ,Integer> orderList;
    private FoodProducer foodProducer;

    OrderRequest(Map<String, Integer> orderList, FoodProducer foodProducer) {
        this.orderList = orderList;
        this.foodProducer = foodProducer;
    }

    public Map<String, Integer> getOrderList() {
        return orderList;
    }

    FoodProducer getFoodProducer() {
        return foodProducer;
    }
}

