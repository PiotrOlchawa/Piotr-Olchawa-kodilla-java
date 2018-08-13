package com.kodilla.hibernate.tasklist;

/*
W katalogu src/main/java utwórz pakiet com.kodilla.hibernate.tasklist
W pakiecie utwórz klasę TaskList, która będzie zawierała pola:
id
listName
description
Z utworzonej klasy zrób encję (tabela powinna się nazywać TASKLISTS, kolumny: ID, LISTNAME, DESCRIPTION)
Stwórz pakiet com.kodilla.hibernate.tasklist.dao
W tym pakiecie utwórz kontroler repozytorium TaskListDao z metodą List<TaskList> findByListName(String listName)
W katalogu src/test/java utwórz pakiet com.kodilla.hibernate.tasklist.dao, a w nim zestaw testów TaskListDaoTestSuite
W tym pakiecie utwórz test testFindByListName() sprawdzający czy metoda findByListName(String listName) działa poprawnie
Pamiętaj, że test powinien być idempotentny, czyli powinien po sobie "posprzątać" w bazie danych
 */

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TASKLIST")
public class TaskList {

    private int id;
    private String listName;
    private String description;

    public TaskList(){

    }

    public TaskList(String listName, String description) {
        this.listName = listName;
        this.description = description;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "LISTNAME")
    public String getListName() {
        return listName;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
