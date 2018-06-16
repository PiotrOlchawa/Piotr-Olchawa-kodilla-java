package com.kodilla.testing.shape;

public class Square implements Shape {

    private double lenght;

    public Square(double lenght) {
        this.lenght = lenght;
    }

    @Override
    public String getShapeName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public double getField() {
        return Math.pow(lenght, 2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        return Double.compare(square.lenght, lenght) == 0;
    }

    @Override
    public String toString() {
        return "Square{" +
                "lenght=" + lenght +
                '}';
    }
}
