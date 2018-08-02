package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testFactoryDrivingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task task = taskFactory.makeTask(TaskFactory.DRIVINGTASK);
        task.executeTask();
        //Then
        Assert.assertEquals("Driving Task", task.getTaskName());
        Assert.assertTrue(task.isTaskExecuted());
    }

    @Test
    public void testFactoryPaintingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task task = taskFactory.makeTask(TaskFactory.PAINTINGTASK);
        task.executeTask();
        //Then
        Assert.assertEquals("Painting Task", task.getTaskName());
        Assert.assertTrue(task.isTaskExecuted());
    }

    @Test
    public void testFactoryCircle() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task task = taskFactory.makeTask(TaskFactory.SHOPPINGTASK);
        task.executeTask();
        //Then
        Assert.assertEquals("Shopping Task", task.getTaskName());
        Assert.assertTrue(task.isTaskExecuted());
    }

}