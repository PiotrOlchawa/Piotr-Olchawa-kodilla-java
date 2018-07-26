package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CalculatorTestSuite {
    @Test
    public void testCalculations() {
        //Given
        Double first = 6.0;
        Double second = 3.0;
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring.calculator");
        Calculator calculator = context.getBean(Calculator.class);
        //Then
        Assert.assertEquals(new Double(9), calculator.add(first, second), 0);
        Assert.assertEquals(new Double(3), calculator.sub(first, second), 0);
        Assert.assertEquals(new Double(2), calculator.div(first, second), 0);
        Assert.assertEquals(new Double(18), calculator.mul(first, second), 0);
    }
}
