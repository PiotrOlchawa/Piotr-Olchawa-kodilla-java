package com.kodilla.good.patterns.challenges;

public class DatabaseOrderRepository implements OrderRepository{

    @Override
    public boolean createOrder(User user, int itemId) {
        System.out.println("Writing to database new order for user " + user.getUserName());
        return true;
    }
}
