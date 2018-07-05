package com.kodilla.good.patterns.Food2Door;

class OrderProcessor {

    void process(OrderRequest orderRequest) {

        boolean orderResult = orderRequest.getFoodProducer().process(orderRequest.getOrderList());

        if (orderResult) {
            System.out.println("Producer" + orderRequest.getFoodProducer().getFoodProducerName() + " order completed successfully");
        } else {
            System.out.println("Something go wrong with producer " + orderRequest.getFoodProducer().getFoodProducerName() + " order");
        }
    }
}
