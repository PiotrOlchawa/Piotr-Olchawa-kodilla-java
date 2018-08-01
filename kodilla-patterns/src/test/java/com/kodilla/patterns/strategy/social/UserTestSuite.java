package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {

    @Test
    public void testDefaultSharingStrategies() {

        //Given
        User steven = new YGeneration("Steven Links");
        User john = new Millenials("John Tuscon");
        User kodilla = new ZGeneration("Gary Hill");

        //When
        String stevenSharePost = steven.sharePost();
        System.out.println("Steven should: " + stevenSharePost);
        String johnSharePost = john.sharePost();
        System.out.println("John should: " + johnSharePost);
        String kodillaSharePost = kodilla.sharePost();
        System.out.println("Kodilla should: " + kodillaSharePost);

        //Then
        Assert.assertEquals("Facebook Publisher", stevenSharePost);
        Assert.assertEquals("Snapchat Publisher", johnSharePost);
        Assert.assertEquals("Twitter Publisher", kodillaSharePost);
    }

    @Test
    public void testIndividualSharingStrategy() {

        //Given
        User steven = new YGeneration("Steven Links");

        //When
        String stevenPublisher = steven.sharePost();
        System.out.println("Steven should: " + stevenPublisher);
        steven.setSocialPublisher(new SnapchatPublisher());
        stevenPublisher = steven.sharePost();
        System.out.println("Steven now should: " + stevenPublisher);

        //Then
        Assert.assertEquals("Snapchat Publisher", stevenPublisher);
    }
}
