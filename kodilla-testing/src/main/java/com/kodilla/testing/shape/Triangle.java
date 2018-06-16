package com.kodilla.testing.shape;

public class Triangle implements Shape {

    private double baseLenght;
    private double height;

    public Triangle(double baseLenght, double height) {
        this.baseLenght = baseLenght;
        this.height = height;
    }

    @Override
    public String getShapeName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public double getField() {
        return 0.5 * baseLenght * height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (Double.compare(triangle.baseLenght, baseLenght) != 0) return false;
        return Double.compare(triangle.height, height) == 0;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "baseLenght=" + baseLenght +
                ", height=" + height +
                '}';
    }
}
