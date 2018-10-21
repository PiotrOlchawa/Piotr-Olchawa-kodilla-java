package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {
    private final String mentor;
    private int updateCount = 0;

    public Mentor(String mentorName) {
        this.mentor = mentorName;
    }

    public int getUpdateCount() {
        return updateCount;
    }

    @Override
    public void sendInformation(CourseTask courseTask) {
        System.out.println(mentor + ": student finish his homework in task: " + courseTask.getTaskName());
        System.out.println("You have " + courseTask.getStudentList().size() + " tasks to check\n");
        updateCount++;
    }
}
