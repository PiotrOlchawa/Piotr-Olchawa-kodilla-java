package com.kodilla.good.patterns.challenges;

public class Application {

    public static void main(String[] args) {

        OrderRequestRetrivier orderRequestRetrivier = new OrderRequestRetrivier();
        OrderRequest orderRequest = orderRequestRetrivier.retrieve();
        OrderProcessor orderProcessor = new OrderProcessor(new MailOrderInformationService(), new ProductOrderService(), new DatabaseOrderRepository());
        orderProcessor.process(orderRequest);
    }
}
