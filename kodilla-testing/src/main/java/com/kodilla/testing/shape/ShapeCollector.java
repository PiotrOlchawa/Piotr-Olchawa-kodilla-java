package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private List<Shape> shapeList = new ArrayList<>();

    void addFigure(Shape shape) {
        shapeList.add(shape);
    }

    void removeFigure(Shape shape) {
        shapeList.remove(shape);
    }

    Shape getFigure(int index) {
        return shapeList.get(index);
    }

    void showFigures() {
        System.out.println(shapeList);
    }
}
