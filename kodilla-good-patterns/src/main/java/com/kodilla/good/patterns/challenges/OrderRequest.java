package com.kodilla.good.patterns.challenges;

public class OrderRequest {

private User user;
private Integer itemID;

    OrderRequest(User user, Integer itemID) {
        this.user = user;
        this.itemID = itemID;
    }

    public User getUser() {
        return user;
    }

    public Integer getItemID() {
        return itemID;
    }
}
