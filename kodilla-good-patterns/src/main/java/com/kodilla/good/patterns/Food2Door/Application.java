package com.kodilla.good.patterns.Food2Door;

public class Application {

    public static void main(String[] args) {

        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();
        OrderProcessor orderProcessor = new OrderProcessor();
        orderProcessor.process(orderRequest);
    }
}
