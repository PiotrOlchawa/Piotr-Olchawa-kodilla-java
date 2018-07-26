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
        //When
        Double addResult = calculator.add(first, second);
        Double subResult = calculator.sub(first, second);
        Double divResult = calculator.div(first, second);
        Double mulResult = calculator.mul(first, second);
        //Then
        Assert.assertEquals(new Double(9), addResult, 0);
        Assert.assertEquals(new Double(3), subResult, 0);
        Assert.assertEquals(new Double(2), divResult, 0);
        Assert.assertEquals(new Double(18), mulResult, 0);
    }
}
