package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage() {
        //Given
        int[] notes = {1, 1, 6};

        //When
        double average = Arrays.stream(notes)
                .average()
                .getAsDouble();
        double averageNotes = ArrayOperations.getAverage(notes);

        //Then
        Assert.assertEquals(average, averageNotes, 2);
    }
}
