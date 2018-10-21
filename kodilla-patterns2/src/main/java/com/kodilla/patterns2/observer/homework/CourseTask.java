package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class CourseTask implements Observable {
    private final List<Student> studentList;
    private final List<Observer> observers;
    private final String taskName;

    public CourseTask(String taskName) {
        studentList = new ArrayList<>();
        observers = new ArrayList<>();
        this.taskName = taskName;
    }

    public void addStudent(Student student) {
        studentList.add(student);
        notifyObserver();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer: observers) {
            observer.sendInformation(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public String getTaskName() {
        return taskName;
    }
}
