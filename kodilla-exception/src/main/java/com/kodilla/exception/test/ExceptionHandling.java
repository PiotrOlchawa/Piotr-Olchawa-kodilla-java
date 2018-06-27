package com.kodilla.exception.test;

public class ExceptionHandling {

    SecondChallenge secondChallenge = new SecondChallenge();

    public void checkValues(double x, double y) {
        try {
            secondChallenge.probablyIWillThrowException(x, y);
        } catch (Exception e) {
            System.out.println("Values x=" + x + " y=" + y + " generates exception !");
        } finally {
            System.out.println("End");
        }
    }
}
