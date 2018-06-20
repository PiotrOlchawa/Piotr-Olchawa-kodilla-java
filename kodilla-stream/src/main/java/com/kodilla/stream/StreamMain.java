package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {

        // zad 7.1
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        List<String> texts = new ArrayList<>();
        texts.add("Some Text One");
        texts.add("Some Text Two");
        texts.add("Some Text Three");

        for (String text : texts) {
            System.out.println(poemBeautifier.beautify(text, l -> l.toUpperCase()));
            System.out.println(poemBeautifier.beautify(text, l -> "##### " + l + " #####"));
            System.out.println(poemBeautifier.beautify(text, l -> {
                String letter1 = l.substring(0, 1);
                String lastLetter = l.substring((l.length() - 1), (l.length())).toUpperCase();
                return letter1 + l + lastLetter;
            }));
        }

        // zad 7.3
        Forum forum = new Forum();
        forum.addUser(new ForumUser(1, "Adam", 'M', LocalDate.of(2014, Month.JANUARY, 1), 45));
        forum.addUser(new ForumUser(2, "Rysiek", 'M', LocalDate.of(1965, Month.JANUARY, 1), 23));
        forum.addUser(new ForumUser(3, "Władek", 'M', LocalDate.of(1978, Month.JANUARY, 1), 25));
        forum.addUser(new ForumUser(4, "Czesiek", 'M', LocalDate.of(1997, Month.JANUARY, 1), 55));
        forum.addUser(new ForumUser(5, "Romek", 'M', LocalDate.of(2004, Month.JANUARY, 1), 0));
        forum.addUser(new ForumUser(6, "Marcin", 'M', LocalDate.of(2008, Month.JANUARY, 1), 12));

        Map<Integer, ForumUser> filteredForumUsers = forum.getUserList().stream().filter(l -> l.getSex() == 'M')
                .filter(l -> LocalDate.now().getYear() - l.getBirthDate().getYear() >= 20)
                .filter(l -> l.getPublishedPosts() >= 1)
                .collect(Collectors.toMap(l -> l.getUserId(), l -> l));

        for (Map.Entry<Integer, ForumUser> entryMap : filteredForumUsers.entrySet()) {
            System.out.println("UserId " + entryMap.getKey() + " : " + entryMap.getValue());
        }
    }
}

