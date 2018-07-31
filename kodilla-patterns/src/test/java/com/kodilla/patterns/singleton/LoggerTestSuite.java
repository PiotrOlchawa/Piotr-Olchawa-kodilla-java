package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {

    @Test
    public void getLastLog() {
        //Given
        Logger logger = Logger.getInstance();
        //When
        logger.log("Simple entry");
        //Then
        Assert.assertEquals("Simple entry", logger.getLastLog());
    }
}
