/*Zadanie polega na stworzeniu niemutowalnej klasy reprezentującej użytkownika forum. Aby zrealizować zadanie wykonaj:

Utwórz w pakiecie com.kodilla.stream.immutable klasę ForumUser, zawierającą pola String username, String realName oraz konstruktor i gettery
Spraw, aby utworzona klasa była niemutowalna poprzez odpowiednie użycie słowa kluczowego final
Upewnij się, że wszystkie pola klasy są oznaczone jako private
Prześlij kod do repozytorium Github.*/


package com.kodilla.stream.immutable;

public class ForumUser {

    private final String username;
    private final String realName;

    public ForumUser(final String username, final String realName) {
        this.username = username;
        this.realName = realName;
    }

    public String getUsername() {
        return username;
    }

    public String getRealName() {
        return realName;
    }
}
