package com.kodilla.good.patterns.challenges;

public class OrderRequestRetrivier {

    public OrderRequest retrieve() {
        User user = new User("Adam");
        int orderedItemId = 2;
        return new OrderRequest(user, orderedItemId);
    }
}
