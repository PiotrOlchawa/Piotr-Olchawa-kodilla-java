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
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTestSuite {

    Statistics statisticsMockPostZero = mock(Statistics.class);
    Statistics statisticsMockPost1000 = mock(Statistics.class);
    Statistics statisticsMockCommentsZero = mock(Statistics.class);
    Statistics statisticsMockCommentsLessThanPosts = mock(Statistics.class);
    Statistics statisticsMockCommentsMoreThanPosts = mock(Statistics.class);
    Statistics getStatisticsMockUsersZero = mock(Statistics.class);
    Statistics getGetStatisticsMockUsers100 = mock(Statistics.class);

    @Before
    public void beforeTest() {

        ArrayList<String> userNamesList = new ArrayList<>();
        userNamesList.add("Max");
        userNamesList.add("Tom");
        userNamesList.add("Jerry");
        userNamesList.add("John");
        userNamesList.add("Ben");

        ArrayList<String> emptyUserNamesList = new ArrayList<>();

        ArrayList<String> UserNamesList100 = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            UserNamesList100.add("100Users");
        }

        when(statisticsMockPostZero.usersNames()).thenReturn(userNamesList);
        when(statisticsMockPostZero.commentsCount()).thenReturn(15);
        when(statisticsMockPostZero.postsCount()).thenReturn(0);

        when(statisticsMockPost1000.usersNames()).thenReturn(userNamesList);
        when(statisticsMockPost1000.commentsCount()).thenReturn(15);
        when(statisticsMockPost1000.postsCount()).thenReturn(1000);

        when(statisticsMockCommentsZero.usersNames()).thenReturn(userNamesList);
        when(statisticsMockCommentsZero.commentsCount()).thenReturn(0);
        when(statisticsMockCommentsZero.postsCount()).thenReturn(1000);

        when(statisticsMockCommentsLessThanPosts.usersNames()).thenReturn(userNamesList);
        when(statisticsMockCommentsLessThanPosts.commentsCount()).thenReturn(100);
        when(statisticsMockCommentsLessThanPosts.postsCount()).thenReturn(1000);

        when(statisticsMockCommentsMoreThanPosts.usersNames()).thenReturn(userNamesList);
        when(statisticsMockCommentsMoreThanPosts.commentsCount()).thenReturn(1000);
        when(statisticsMockCommentsMoreThanPosts.postsCount()).thenReturn(100);

        when(getStatisticsMockUsersZero.usersNames()).thenReturn(emptyUserNamesList);
        when(getStatisticsMockUsersZero.commentsCount()).thenReturn(15);
        when(getStatisticsMockUsersZero.postsCount()).thenReturn(1000);

        when(getGetStatisticsMockUsers100.usersNames()).thenReturn(UserNamesList100);
        when(getGetStatisticsMockUsers100.commentsCount()).thenReturn(15);
        when(getGetStatisticsMockUsers100.postsCount()).thenReturn(1000);
    }


    //gdy liczba postów = 0,
    @Test
    public void testCalculateAdvStatisticsPostZero() {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();

        //When
        forumStatistics.calculateAdvStatistics(statisticsMockPostZero);
        int totalPosts = forumStatistics.getTotalPosts();
        double postPerUser = forumStatistics.getPostPerUser();
        double comentsPerPost = forumStatistics.getCommentsPerPost();

        //Then
        Assert.assertEquals(0, totalPosts);
        Assert.assertEquals(new Double(0), postPerUser, 0);
        Assert.assertEquals(new Double(0), comentsPerPost, 0);

    }

    //gdy liczba postów = 1000
    @Test
    public void testCalculateAdvStatisticsPost1000() {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();

        //When
        forumStatistics.calculateAdvStatistics(statisticsMockPost1000);
        int totalPosts = forumStatistics.getTotalPosts();
        double postPerUser = forumStatistics.getPostPerUser();
        double comentsPerPost = forumStatistics.getCommentsPerPost();

        //Then
        Assert.assertEquals(1000, totalPosts);
        Assert.assertEquals(new Double(200), postPerUser, 0);
        Assert.assertEquals(new Double(0.015), comentsPerPost, 0);

    }

    //gdy liczba komentarzy = 0,
    @Test
    public void testCalculateAdvStatisticsCommentsZero() {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();

        //When
        forumStatistics.calculateAdvStatistics(statisticsMockCommentsZero);
        int totalComments = forumStatistics.getTotalComments();
        double commentsPerUser = forumStatistics.getCommentsPerUser();
        double comentsPerPost = forumStatistics.getCommentsPerPost();

        //Then
        Assert.assertEquals(0, totalComments);
        Assert.assertEquals(new Double(0), commentsPerUser, 0);
        Assert.assertEquals(new Double(0), comentsPerPost, 0);

    }

    //gdy liczba komentarzy < liczba postów
    @Test
    public void testCalculateAdvStatisticsCommentsLessThanPosts() {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();

        //When
        forumStatistics.calculateAdvStatistics(statisticsMockCommentsLessThanPosts);
        int totalComments = forumStatistics.getTotalComments();
        int totalPosts = forumStatistics.getTotalPosts();
        double commentsPerUser = forumStatistics.getCommentsPerUser();
        double comentsPerPost = forumStatistics.getCommentsPerPost();

        //Then
        Assert.assertEquals(100, totalComments);
        Assert.assertEquals(1000, totalPosts);
        Assert.assertEquals(new Double(20), commentsPerUser, 0);
        Assert.assertEquals(new Double(0.1), comentsPerPost, 0);
    }


    //gdy liczba komentarzy > liczba postów,
    @Test
    public void testCalculateAdvStatisticsCommentsMoreThanPosts() {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();

        //When
        forumStatistics.calculateAdvStatistics(statisticsMockCommentsMoreThanPosts);
        int totalComments = forumStatistics.getTotalComments();
        int totalPosts = forumStatistics.getTotalPosts();
        double commentsPerUser = forumStatistics.getCommentsPerUser();
        double comentsPerPost = forumStatistics.getCommentsPerPost();

        //Then
        Assert.assertEquals(1000, totalComments);
        Assert.assertEquals(100, totalPosts);
        Assert.assertEquals(new Double(200), commentsPerUser, 0);
        Assert.assertEquals(new Double(10), comentsPerPost, 0);
    }

    //gdy liczba użytkowników = 0,
    @Test
    public void testCalculateAdvStatisticsUsersZero() {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();

        //When
        forumStatistics.calculateAdvStatistics(getStatisticsMockUsersZero);
        int totalUsers = forumStatistics.getTotalUsers();
        double postPerUser = forumStatistics.getPostPerUser();
        double comentsPerUser = forumStatistics.getCommentsPerUser();

        //Then
        Assert.assertEquals(0, totalUsers);
        Assert.assertEquals(new Double(0), postPerUser, 0);
        Assert.assertEquals(new Double(0), comentsPerUser, 0);
    }

    //gdy liczba użytkowników = 100
    @Test
    public void testCalculateAdvStatisticsUsers100() {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();

        //When
        forumStatistics.calculateAdvStatistics(getGetStatisticsMockUsers100);
        int totalUsers = forumStatistics.getTotalUsers();
        double postPerUser = forumStatistics.getPostPerUser();
        double comentsPerUser = forumStatistics.getCommentsPerUser();

        //Then
        Assert.assertEquals(100, totalUsers);
        Assert.assertEquals(new Double(10), postPerUser, 0);
        Assert.assertEquals(new Double(0.15), comentsPerUser, 0);
    }
}
