package com.kodilla.good.patterns.Food2Door;

import java.util.HashMap;
import java.util.Map;

class OrderRequestRetriever {

    OrderRequest retrieve() {
        Map<String, Integer> organicFreshFruits = new HashMap<>();
        organicFreshFruits.put("Banana", 5);

        Map<String, Integer> organicFreshFruitsOrder = new HashMap<>();
        organicFreshFruitsOrder.put("Banana", 1);

        FoodProducer foodProducer = new OrganicFreshFruitsFoodProducer("OrganicFreshFruits", organicFreshFruits);

        return new OrderRequest(organicFreshFruitsOrder, foodProducer);
    }
}
