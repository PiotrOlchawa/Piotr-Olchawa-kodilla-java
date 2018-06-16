package com.kodilla.testing.shape;

import org.junit.*;

import java.util.ArrayList;


public class ShapeCollectorTestSuite {

    @Test
    public void testAddFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape circleOne = new Circle(1.4);
        //When
        shapeCollector.addFigure(circleOne);
        //Then
        Assert.assertEquals(circleOne, shapeCollector.getFigure(0));
    }

    @Test
    public void testRemoveFigure() {

        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        boolean removeSucessfull = true;

        Shape circleOne = new Circle(1.4);
        Square squareOne = new Square(4);
        Shape circleTwo = new Circle(1.5);  //will be removed
        Triangle triangleOne = new Triangle(1.4, 4.5);

        //When
        shapeCollector.addFigure(circleOne);
        shapeCollector.addFigure(circleTwo);
        shapeCollector.addFigure(triangleOne);
        shapeCollector.addFigure(squareOne);
        shapeCollector.removeFigure(circleTwo); //removing

        for (int i = 0; i < 3; i++) {
            if (shapeCollector.getFigure(i).equals(circleTwo)) {
                removeSucessfull = false;
            }
        }

        //Then
        Assert.assertTrue(removeSucessfull);
    }

    @Test
    public void testGetFigure() {

        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        ArrayList<Shape> testArrayList = new ArrayList<>();

        Shape circleOne = new Circle(1.4);
        Square squareOne = new Square(4);
        Shape circleTwo = new Circle(1.5);  //will be removed
        Triangle triangleOne = new Triangle(1.4, 4.5);

        //When
        shapeCollector.addFigure(circleOne);
        shapeCollector.addFigure(triangleOne);
        shapeCollector.addFigure(circleTwo);
        shapeCollector.addFigure(squareOne);

        //Then
        Assert.assertEquals(circleTwo, shapeCollector.getFigure(2));
    }

    @Test
    public void testShowFigures() {

        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        ArrayList<Shape> shapes = new ArrayList<>();
        Shape circleOne = new Circle(1.4);
        Square squareOne = new Square(4);
        Shape circleTwo = new Circle(1.5);  //will be removed
        Triangle triangleOne = new Triangle(1.4, 4.5);

        shapes.add(circleOne);
        shapes.add(squareOne);
        shapes.add(circleTwo);
        shapes.add(triangleOne);

        //When
        shapeCollector.addFigure(circleOne);
        shapeCollector.addFigure(squareOne);
        shapeCollector.addFigure(circleTwo);
        shapeCollector.addFigure(triangleOne);

        //Then
        System.out.println("Tested Shape List: " + shapes);
        System.out.printf("showFigures() Result: ");
        shapeCollector.showFigures();
    }
}
