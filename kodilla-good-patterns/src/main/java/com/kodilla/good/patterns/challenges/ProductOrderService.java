package com.kodilla.good.patterns.challenges;

public class ProductOrderService implements OrderService {

    @Override
    public boolean order(User user, int itemId) {
        System.out.println("Item id " + itemId + " for User " + user.getUserName() + " is ordered." );
        return true;
    }
}
