package com.kodilla.exception.test;

public class RouteNotFoundException extends Exception {

    RouteNotFoundException(String message) {
        super(message);
    }
}
