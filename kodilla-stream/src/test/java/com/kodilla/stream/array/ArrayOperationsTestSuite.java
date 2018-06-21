package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage() {
        //Given
        int[] notes = {1, 1, 6};
        //When
        double averageNotes = ArrayOperations.getAverage(notes);
        //Then
        Assert.assertEquals(new Double(2.6666), averageNotes, 0.5);
    }
}
