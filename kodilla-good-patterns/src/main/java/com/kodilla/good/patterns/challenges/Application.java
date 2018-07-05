package com.kodilla.good.patterns.challenges;

public class Application {

    public static void main(String[] args) {

        OrderRequestRetriever orderRequestRetrivier = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetrivier.retrieve();
        OrderProcessor orderProcessor = new OrderProcessor(new MailOrderInformationService(), new ProductOrderService(), new DatabaseOrderRepository());
        orderProcessor.process(orderRequest);
    }
}
