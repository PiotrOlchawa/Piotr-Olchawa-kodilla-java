package com.kodilla.testing.forum.statistics;

import org.junit.*;
import org.mockito.Mock;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTestSuiteCustom {

    Statistics statisticsMockPostZero = mock(Statistics.class);
    Statistics statisticsMockPost1000 = mock(Statistics.class);
    Statistics statisticsMockCommentsZero = mock(Statistics.class);
    Statistics statisticsMockCommentsLessThanPosts = mock(Statistics.class);
    Statistics statisticsMockCommentsMoreThanPosts = mock(Statistics.class);
    Statistics getStatisticsMockUsersZero = mock(Statistics.class);
    Statistics getGetStatisticsMockUsers100 = mock(Statistics.class);
    ForumStatistics forumStatistics = new ForumStatistics();

    private ArrayList<String> createCustomSizeArray(int size){
        ArrayList<String> userNamesList = new ArrayList<>();
        for(int i=0; i<size; i++){
            userNamesList.add("User " + i);
        }
        return  userNamesList;
    }

    private void mockStatistics(Statistics statistics, List<String> userList, int commentsCount, int postCount){
        when(statistics.usersNames()).thenReturn(userList);
        when(statistics.commentsCount()).thenReturn(commentsCount);
        when(statistics.postsCount()).thenReturn(postCount);
    }

    @Before
    public void beforeTest() {
        mockStatistics(statisticsMockPostZero,createCustomSizeArray(5),15,0);
        mockStatistics(statisticsMockPost1000,createCustomSizeArray(5),15,1000);
        mockStatistics(statisticsMockCommentsZero,createCustomSizeArray(5),0,1000);
        mockStatistics(statisticsMockCommentsLessThanPosts,createCustomSizeArray(5),100,1000);
        mockStatistics(statisticsMockCommentsMoreThanPosts,createCustomSizeArray(5),1000,100);
        mockStatistics(getStatisticsMockUsersZero,createCustomSizeArray(0),15,100);
        mockStatistics(getGetStatisticsMockUsers100,createCustomSizeArray(100),15,1000);
    }

    //gdy liczba postów = 0,
    @Test
    public void testCalculateAdvStatisticsPostZero() {
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
