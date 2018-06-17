/*W pakiecie com.kodilla.testing.forum.statistics utwórz klasę obliczającą następujące statystyki:

liczbę użytkowników,
liczbę postów,
liczbę komentarzy,
średnią liczbę postów na użytkownika,
średnią liczbę komentarzy na użytkownika,
średnią liczbę komentarzy na post.

Stworzona klasa powinna posiadać metodę calculateAdvStatistics(Statistics statistics),
która obliczy podane powyżej wartości i zapamięta je we właściwościach (polach) klasy.
Możesz również dopisać metodę showStatistics(), która wyświetli zapamiętane we właściwościach statystyki.*/

package com.kodilla.testing.forum.statistics;

import java.util.ArrayList;

public class ForumStatistics {

    private int totalUsers;
    private int totalPosts;
    private int totalComments;
    private double postPerUser;
    private double commentsPerUser;
    private double commentsPerPost;

    public int getTotalUsers() {
        return totalUsers;
    }

    public int getTotalPosts() {
        return totalPosts;
    }

    public int getTotalComments() {
        return totalComments;
    }

    public double getPostPerUser() {
        return postPerUser;
    }

    public double getCommentsPerUser() {
        return commentsPerUser;
    }

    public double getCommentsPerPost() {
        return commentsPerPost;
    }

    public void calculateAdvStatistics(Statistics statistics) {

        /*gdy liczba postów = 0,                // divide by zero - exception
        gdy liczba użytkowników = 0,            // divide by zero - exception
        */

        totalUsers = statistics.usersNames().size();
        totalPosts = statistics.postsCount();
        totalComments = statistics.commentsCount();

        postPerUser = (totalUsers != 0) ? (double) totalPosts / totalUsers : 0;
        commentsPerUser = (totalUsers != 0) ? (double) totalComments / totalUsers : 0;
        commentsPerPost = (totalPosts != 0) ? (double) totalComments / totalPosts : 0;
    }

    public void showStatistics() {
        System.out.println("Total users =" + totalUsers);
        System.out.println("Total posts =" + totalPosts);
        System.out.println("Total comments =" + totalComments);
        System.out.println("Post/user =" + postPerUser);
        System.out.println("Comments/user =" + commentsPerUser);
        System.out.println("Comments/post =" + commentsPerPost);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForumStatistics that = (ForumStatistics) o;

        if (totalUsers != that.totalUsers) return false;
        if (totalPosts != that.totalPosts) return false;
        if (totalComments != that.totalComments) return false;
        if (Double.compare(that.postPerUser, postPerUser) != 0) return false;
        if (Double.compare(that.commentsPerUser, commentsPerUser) != 0) return false;
        return Double.compare(that.commentsPerPost, commentsPerPost) == 0;
    }

}
