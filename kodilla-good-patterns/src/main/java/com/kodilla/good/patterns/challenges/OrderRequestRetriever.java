package com.kodilla.good.patterns.challenges;

class OrderRequestRetriever {

    OrderRequest retrieve() {
        User user = new User("Adam");
        int orderedItemId = 2;
        return new OrderRequest(user, orderedItemId);
    }
}
