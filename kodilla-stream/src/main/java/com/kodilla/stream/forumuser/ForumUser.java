/*Twoim zadaniem jest stworzenie kolekcji składającej się z obiektów opisujących użytkowników forum. Następnie, przy pomocy Stream powinieneś przekształcić tę kolekcję w mapę zawierającą tych użytkowników forum, którzy mają nie mniej niż 20 lat, są mężczyznami i mają co najmniej jeden opublikowany post.

Aby zrealizować zadanie wykonaj:

 Stwórz w katalogu src/main/java pakiet com.kodilla.stream.forumuser, a w nim klasę ForumUser
 Klasa ForumUser powinna mieć następujące pola (użyj odpowiednich nazw angielskich):
 unikalny identyfikator użytkownika (typu int)
 nazwa użytkownika (typu String)
 płeć (typu char), z wartościami ‘M’/’F’
 data urodzenia (typu LocalDate)
 ilość opublikowanych postów (typu int)

*/

package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {

    private final int userId;
    private final String userName;
    private final char sex;
    private final LocalDate birthDate;
    private final int publishedPosts;

    public ForumUser(final int userId, final String userName, final char sex, final LocalDate birthDate, final int publishedPosts) {
        this.userId = userId;
        this.userName = userName;
        this.sex = sex;
        this.birthDate = birthDate;
        this.publishedPosts = publishedPosts;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPublishedPosts() {
        return publishedPosts;
    }

    @Override
    public String toString() {
        return "  userName='" + userName + '\'' +
                ", sex=" + sex +
                ", birthDate=" + birthDate +
                ", publishedPosts=" + publishedPosts;
    }
}
