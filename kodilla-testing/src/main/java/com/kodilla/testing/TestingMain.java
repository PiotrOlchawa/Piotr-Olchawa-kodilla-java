package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        if (calculator.add(4, 7) == 11) {
            System.out.println("Test " + calculator.getClass().getSimpleName() + " method add(int a, int b) OK !");
        } else {
            System.out.println("Test " + calculator.getClass().getSimpleName() + " method add(int a, int b) ERROR !");
        }

        if (calculator.substract(4, 7) == -3) {
            System.out.println("Test " + calculator.getClass().getSimpleName() + " method substract(int a, int b) OK !");
        } else {
            System.out.println("Test " + calculator.getClass().getSimpleName() + " method substract(int a, int b) ERROR !");
        }

    }
}
