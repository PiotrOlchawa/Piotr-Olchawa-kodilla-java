package com.kodilla.testing.forum.statistics;

import org.junit.*;
import java.util.ArrayList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTestSuite {

    private ForumStatistics forumStatistics = new ForumStatistics();
    private Statistics statistics;

    static private ArrayList<String> createCustomSizeArray(int size) {
        ArrayList<String> userNamesList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            userNamesList.add("User " + i);
        }
        return userNamesList;
    }

    @Before
    public void setUp() {
        this.statistics = mock(Statistics.class);
    }

    @Test //gdy liczba postów = 0,
    public void testCalculateAdvStatisticsPostZero() {
        //Given
        when(statistics.usersNames()).thenReturn(createCustomSizeArray(5));
        when(statistics.commentsCount()).thenReturn(15);
        when(statistics.postsCount()).thenReturn(0);
        //When
        forumStatistics.calculateAdvStatistics(statistics);
        //Then
        Assert.assertEquals(0, forumStatistics.getTotalPosts());
        Assert.assertEquals(new Double(0), forumStatistics.getPostPerUser(), 0);
        Assert.assertEquals(new Double(0), forumStatistics.getCommentsPerPost(), 0);
    }

    @Test //gdy liczba postów = 1000
    public void testCalculateAdvStatisticsPost1000() {
        //Given
        when(statistics.usersNames()).thenReturn(createCustomSizeArray(5));
        when(statistics.commentsCount()).thenReturn(15);
        when(statistics.postsCount()).thenReturn(1000);
        //When
        forumStatistics.calculateAdvStatistics(statistics);
        //Then
        Assert.assertEquals(1000, forumStatistics.getTotalPosts());
        Assert.assertEquals(new Double(200), forumStatistics.getPostPerUser(), 0);
        Assert.assertEquals(new Double(0.015), forumStatistics.getCommentsPerPost(), 0);
    }

    @Test //gdy liczba komentarzy = 0,
    public void testCalculateAdvStatisticsCommentsZero() {
        //Given
        when(statistics.usersNames()).thenReturn(createCustomSizeArray(5));
        when(statistics.commentsCount()).thenReturn(0);
        when(statistics.postsCount()).thenReturn(0);
        //When
        forumStatistics.calculateAdvStatistics(statistics);
        //Then
        Assert.assertEquals(0, forumStatistics.getTotalComments());
        Assert.assertEquals(new Double(0), forumStatistics.getPostPerUser(), 0);
        Assert.assertEquals(new Double(0), forumStatistics.getCommentsPerPost(), 0);
    }

    @Test //gdy liczba komentarzy < liczba postów
    public void testCalculateAdvStatisticsCommentsLessThanPosts() {
        //Given
        when(statistics.usersNames()).thenReturn(createCustomSizeArray(5));
        when(statistics.commentsCount()).thenReturn(100);
        when(statistics.postsCount()).thenReturn(1000);
        //When
        forumStatistics.calculateAdvStatistics(statistics);
        //Then
        Assert.assertEquals(100, forumStatistics.getTotalComments());
        Assert.assertEquals(1000, forumStatistics.getTotalPosts());
        Assert.assertEquals(new Double(20), forumStatistics.getCommentsPerUser(), 0);
        Assert.assertEquals(new Double(0.1), forumStatistics.getCommentsPerPost(), 0);
    }

    @Test //gdy liczba komentarzy > liczba postów,
    public void testCalculateAdvStatisticsCommentsMoreThanPosts() {
        //Given
        when(statistics.usersNames()).thenReturn(createCustomSizeArray(5));
        when(statistics.commentsCount()).thenReturn(1000);
        when(statistics.postsCount()).thenReturn(100);
        //When
        forumStatistics.calculateAdvStatistics(statistics);
        //Then
        Assert.assertEquals(1000, forumStatistics.getTotalComments());
        Assert.assertEquals(100, forumStatistics.getTotalPosts());
        Assert.assertEquals(new Double(200), forumStatistics.getCommentsPerUser(), 0);
        Assert.assertEquals(new Double(10), forumStatistics.getCommentsPerPost(), 0);
    }

    @Test //gdy liczba użytkowników = 0
    public void testCalculateAdvStatisticsUsersZero() {
        //Given
        when(statistics.usersNames()).thenReturn(createCustomSizeArray(0));
        when(statistics.commentsCount()).thenReturn(15);
        when(statistics.postsCount()).thenReturn(100);
        //When
        forumStatistics.calculateAdvStatistics(statistics);
        //Then
        Assert.assertEquals(0, forumStatistics.getTotalUsers());
        Assert.assertEquals(new Double(0), forumStatistics.getPostPerUser(), 0);
        Assert.assertEquals(new Double(0), forumStatistics.getCommentsPerUser(), 0);
    }

    @Test //gdy liczba użytkowników = 100
    public void testCalculateAdvStatisticsUsers100() {
        //Given
        when(statistics.usersNames()).thenReturn(createCustomSizeArray(100));
        when(statistics.commentsCount()).thenReturn(15);
        when(statistics.postsCount()).thenReturn(1000);
        //When
        forumStatistics.calculateAdvStatistics(statistics);
        //Then
        Assert.assertEquals(100, forumStatistics.getTotalUsers());
        Assert.assertEquals(new Double(10), forumStatistics.getPostPerUser(), 0);
        Assert.assertEquals(new Double(0.15), forumStatistics.getCommentsPerUser(), 0);
    }
}