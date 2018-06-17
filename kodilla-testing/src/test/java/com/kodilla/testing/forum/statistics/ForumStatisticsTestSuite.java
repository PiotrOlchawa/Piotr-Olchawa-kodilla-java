package com.kodilla.testing.forum.statistics;

/*stwórz zestaw testów, zawierający testy sprawdzające metodę calculateAdvStatistics(Statistics statistics) testowanej klasy.
 Testy zrealizuj przy pomocy mocka interfejsu Statistics. Przetestuj poprawność obliczeń wartości średnich dla różnych przypadków:

gdy liczba postów = 0,
gdy liczba postów = 1000,

gdy liczba komentarzy = 0,
gdy liczba komentarzy < liczba postów,
gdy liczba komentarzy > liczba postów,

gdy liczba użytkowników = 0,
gdy liczba użytkowników = 100.*/

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SuppressWarnings("Duplicates")

public class ForumStatisticsTestSuite {


    //gdy liczba postów = 0,
    @Test
    public void testCalculateAdvStatisticsPostZero() {

        //Given
        boolean testCalculateAdvStatisticsPostZero = true;
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.usersNames()).thenReturn(new ArrayList<String>() {
            {
                add("John");
                add("Kim");
                add("Max");
            }
        });
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(15);
        ForumStatistics forumStatistics = new ForumStatistics();

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        if (!(forumStatistics.getCommentsPerPost() == 0)
                || !(forumStatistics.getPostPerUser() == 0)
                || !(forumStatistics.getCommentsPerUser() == 5)
                || !(forumStatistics.getTotalUsers() == 3)
                || !(forumStatistics.getTotalPosts() == 0)
                || !(forumStatistics.getTotalComments() == 15)) {
            testCalculateAdvStatisticsPostZero = false;
        }

        //Then
        Assert.assertTrue(testCalculateAdvStatisticsPostZero);
    }

    //gdy liczba postów = 1000
    @Test
    public void testCalculateAdvStatisticsPost1000() {

        //Given
        boolean testCalculateAdvStatisticsPostZero = true;
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.usersNames()).thenReturn(new ArrayList<String>() {
            {
                add("John");
                add("Kim");
                add("Max");
                add("Don");
                add("Ju");
            }
        });
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(100);
        ForumStatistics forumStatistics = new ForumStatistics();

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        if (!(forumStatistics.getCommentsPerPost() == 0.1)
                || !(forumStatistics.getPostPerUser() == 200)
                || !(forumStatistics.getCommentsPerUser() == 20)
                || !(forumStatistics.getTotalUsers() == 5)
                || !(forumStatistics.getTotalPosts() == 1000)
                || !(forumStatistics.getTotalComments() == 100)) {
            testCalculateAdvStatisticsPostZero = false;
        }

        //Then
        Assert.assertTrue(testCalculateAdvStatisticsPostZero);
    }

    //gdy liczba komentarzy = 0,
    @Test
    public void testCalculateAdvStatisticsComments0() {

        //Given
        boolean testCalculateAdvStatisticsPostZero = true;
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.usersNames()).thenReturn(new ArrayList<String>() {
            {
                add("John");
                add("Kim");
                add("Max");
                add("Don");
                add("Ju");
            }
        });
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(0);
        ForumStatistics forumStatistics = new ForumStatistics();

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        if (!(forumStatistics.getCommentsPerPost() == 0)
                || !(forumStatistics.getPostPerUser() == 200)
                || !(forumStatistics.getCommentsPerUser() == 0)
                || !(forumStatistics.getTotalUsers() == 5)
                || !(forumStatistics.getTotalPosts() == 1000)
                || !(forumStatistics.getTotalComments() == 0)) {
            testCalculateAdvStatisticsPostZero = false;
        }

        //Then
        Assert.assertTrue(testCalculateAdvStatisticsPostZero);
    }

    //gdy liczba komentarzy < liczba postów
    @Test
    public void testCalculateAdvStatisticsCommentsLessThanPosts() {

        //Given
        boolean testCalculateAdvStatisticsPostZero = true;
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.usersNames()).thenReturn(new ArrayList<String>() {
            {
                add("John");
                add("Kim");
                add("Max");
                add("Don");
                add("Ju");
            }
        });
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(100);
        ForumStatistics forumStatistics = new ForumStatistics();

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        if (!(forumStatistics.getCommentsPerPost() == 0.1)
                || !(forumStatistics.getPostPerUser() == 200)
                || !(forumStatistics.getCommentsPerUser() == 20)
                || !(forumStatistics.getTotalUsers() == 5)
                || !(forumStatistics.getTotalPosts() == 1000)
                || !(forumStatistics.getTotalComments() == 100)) {
            testCalculateAdvStatisticsPostZero = false;
        }

        //Then
        Assert.assertTrue(testCalculateAdvStatisticsPostZero);
    }

    //gdy liczba komentarzy > liczba postów,

    @Test
    public void testCalculateAdvStatisticsCommentsMoreThanPosts() {

        //Given
        boolean testCalculateAdvStatisticsPostZero = true;
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.usersNames()).thenReturn(new ArrayList<String>() {
            {
                add("John");
                add("Kim");
                add("Max");
                add("Don");
                add("Ju");
            }
        });
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(10000);
        ForumStatistics forumStatistics = new ForumStatistics();

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        if (!(forumStatistics.getCommentsPerPost() == 10)
                || !(forumStatistics.getPostPerUser() == 200)
                || !(forumStatistics.getCommentsPerUser() == 2000)
                || !(forumStatistics.getTotalUsers() == 5)
                || !(forumStatistics.getTotalPosts() == 1000)
                || !(forumStatistics.getTotalComments() == 10000)) {
            testCalculateAdvStatisticsPostZero = false;
        }

        //Then
        Assert.assertTrue(testCalculateAdvStatisticsPostZero);
    }

    //gdy liczba użytkowników = 0,
    @Test
    public void testCalculateAdvStatisticsUsers0() {

        //Given
        boolean testCalculateAdvStatisticsPostZero = true;
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.usersNames()).thenReturn(new ArrayList<String>());
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(100);
        ForumStatistics forumStatistics = new ForumStatistics();

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        if (!(forumStatistics.getCommentsPerPost() == 0.1)
                || !(forumStatistics.getPostPerUser() == 0)
                || !(forumStatistics.getCommentsPerUser() == 0)
                || !(forumStatistics.getTotalUsers() == 0)
                || !(forumStatistics.getTotalPosts() == 1000)
                || !(forumStatistics.getTotalComments() == 100)) {
            testCalculateAdvStatisticsPostZero = false;
        }

        //Then
        Assert.assertTrue(testCalculateAdvStatisticsPostZero);
    }

    //gdy liczba użytkowników = 100
    @Test
    public void testCalculateAdvStatisticsUsers100() {

        //Given
        boolean testCalculateAdvStatisticsPostZero = true;
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.usersNames()).thenReturn(new ArrayList<String>() {
            {
                for (int i = 0; i < 100; i++) {
                    add("100 Users");
                }
            }
        });
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(10000);
        ForumStatistics forumStatistics = new ForumStatistics();

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        if (!(forumStatistics.getCommentsPerPost() == 10)
                || !(forumStatistics.getPostPerUser() == 10)
                || !(forumStatistics.getCommentsPerUser() == 100)
                || !(forumStatistics.getTotalUsers() == 100)
                || !(forumStatistics.getTotalPosts() == 1000)
                || !(forumStatistics.getTotalComments() == 10000)) {
            testCalculateAdvStatisticsPostZero = false;
        }

        //Then
        Assert.assertTrue(testCalculateAdvStatisticsPostZero);
    }
}
