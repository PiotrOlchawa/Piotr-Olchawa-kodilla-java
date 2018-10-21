package com.kodilla.patterns2.observer.homework;

import com.kodilla.patterns2.observer.homework.tasks.JpaCourseTask;
import com.kodilla.patterns2.observer.homework.tasks.MavenCourseTask;
import com.kodilla.patterns2.observer.homework.tasks.MultithreadingCourseTask;
import org.junit.Assert;
import org.junit.Test;

public class CourseTaskTestSuite {

    @Test
    public void testCourseStudentCount() {
        //Given
        Student student1 = new Student("Adam");
        Student student2 = new Student("Waldek");
        Student student3 = new Student("Rysiek");
        Student student4 = new Student("Krzysiek");

        CourseTask jpaCourseTask = new JpaCourseTask();
        CourseTask mavenCourseTask = new MavenCourseTask();
        CourseTask multithreadingCourseTask = new MultithreadingCourseTask();

        //When
        jpaCourseTask.addStudent(student1);
        jpaCourseTask.addStudent(student2);
        jpaCourseTask.addStudent(student4);

        mavenCourseTask.addStudent(student4);

        multithreadingCourseTask.addStudent(student3);
        multithreadingCourseTask.addStudent(student2);

        int hibernateTaskListOfStudents = jpaCourseTask.getStudentList().size();
        int restApiTaskListOfStudents = mavenCourseTask.getStudentList().size();
        int streamTaskListOfStudents = multithreadingCourseTask.getStudentList().size();

        //Then
        Assert.assertEquals(3, hibernateTaskListOfStudents);
        Assert.assertEquals(1, restApiTaskListOfStudents);
        Assert.assertEquals(2, streamTaskListOfStudents);
    }

    @Test
    public void testCourseMentorsCountStudents() {
        //Given
        Student student1 = new Student("Adam");
        Student student2 = new Student("Waldek");
        Student student3 = new Student("Rysiek");
        Student student4 = new Student("Krzysiek");


        CourseTask jpaCourseTask = new JpaCourseTask();
        CourseTask mavenCourseTask = new MavenCourseTask();
        CourseTask multithreadingCourseTask = new MultithreadingCourseTask();

        Mentor mentor1 = new Mentor("Mentor1");
        Mentor mentor2 = new Mentor("Mentor2");

        //When
        jpaCourseTask.registerObserver(mentor1);
        jpaCourseTask.registerObserver(mentor2);
        mavenCourseTask.registerObserver(mentor1);
        multithreadingCourseTask.registerObserver(mentor2);

        jpaCourseTask.addStudent(student1);
        jpaCourseTask.addStudent(student2);
        jpaCourseTask.addStudent(student4);

        mavenCourseTask.addStudent(student4);

        multithreadingCourseTask.addStudent(student3);
        multithreadingCourseTask.addStudent(student2);

        int mentor1CourseTasks = mentor1.getUpdateCount();
        int mentor2CourseTasks = mentor2.getUpdateCount();

        //Then
        Assert.assertEquals(4, mentor1CourseTasks);
        Assert.assertEquals(5, mentor2CourseTasks);
    }
}
