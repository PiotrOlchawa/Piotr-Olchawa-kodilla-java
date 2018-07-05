package com.kodilla.good.patterns.challenges;

class OrderProcessor {

    private OrderInformationService orderInformationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    OrderProcessor(OrderInformationService orderInformationService, OrderService orderService, OrderRepository orderRepository) {
        this.orderInformationService = orderInformationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    OrderDto process(final OrderRequest orderRequest) {

        boolean isOrdered = orderService.order(orderRequest.getUser(), orderRequest.getItemID());

        if (isOrdered) {
            orderInformationService.inform(orderRequest.getUser());
            orderRepository.createOrder(orderRequest.getUser(), orderRequest.getItemID());
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), false);
        }
    }


}
