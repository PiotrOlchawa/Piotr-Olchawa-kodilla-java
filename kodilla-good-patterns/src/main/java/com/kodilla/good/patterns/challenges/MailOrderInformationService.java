package com.kodilla.good.patterns.challenges;

public class MailOrderInformationService implements OrderInformationService{

    @Override
    public void inform(User user) {
        System.out.println("Sending notification mail for user " + user.getUserName());
    }
}
