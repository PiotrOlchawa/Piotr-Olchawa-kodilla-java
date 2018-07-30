package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BoardTestSuite {

    @Test
    public void testAddTask() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        board.addDoneList("Clean Floor");
        board.addInProgressList("Clean spoons");
        board.addToDoList("Wear Shoes");
        Boolean doneList = board.getDoneList().getTasks().contains("Clean Floor");
        Boolean inProgressList = board.getInProgressList().getTasks().contains("Clean spoons");
        Boolean toDoList = board.getToDoList().getTasks().contains("Wear Shoes");
        //Then
        Assert.assertTrue(doneList);
        Assert.assertTrue(inProgressList);
        Assert.assertTrue(toDoList);
    }
}
