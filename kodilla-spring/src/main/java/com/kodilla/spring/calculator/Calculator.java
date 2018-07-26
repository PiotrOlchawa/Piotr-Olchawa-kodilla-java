package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Calculator {

    @Autowired
    private Display display;

    Double add(double a, double b) {
        Double result = a + b;
        display.displayValue(result);
        return result;
    }

    Double sub(double a, double b) {
        Double result = a - b;
        display.displayValue(result);
        return result;
    }

    Double mul(double a, double b) {
        Double result = a * b;
        display.displayValue(result);
        return result;
    }

    Double div(double a, double b) {
        Double result = a / b;
        display.displayValue(result);
        return result;
    }

}
