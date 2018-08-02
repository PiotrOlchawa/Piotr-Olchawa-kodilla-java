package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String DRIVINGTASK = "DRIVINGTASK";
    public static final String PAINTINGTASK = "PAINTINGTASK";
    public static final String SHOPPINGTASK = "SHOPPINGTASK";

    public final Task makeTask(final String shapeClass) {
        switch (shapeClass) {
            case DRIVINGTASK:
                return new DrivingTask("Driving Task", "Berlin", "Car");
            case PAINTINGTASK:
                return new PaintingTask("Painting Task", "Green", "Wall");
            case SHOPPINGTASK:
                return new ShoppingTask("Shopping Task", "Nail", 5.0);
            default:
                return null;
        }

    }
}
