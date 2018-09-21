package com.kodilla.sudoku;

public class Menu {

    private Commander commander;

    public Menu(Commander commander) {
        this.commander = commander;
    }

    public void makeChoice() {

        String choice = commander.makeChoice();

        switch (choice) {
            case "sudoku":

                break;
            case "x":

                break;
            case "n":

                break;
            default:
        }
    }
}

