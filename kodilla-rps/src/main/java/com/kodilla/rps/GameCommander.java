package com.kodilla.rps;

import java.util.Scanner;

class GameCommander {

    private Scanner scanner = new Scanner(System.in);

    String getPlayerName() {
        askForName();
        while (true) {
            String input = scanner.nextLine();
            if (input.length() >= 1) {
                return input;
            } else {
                badNameInput();
            }
        }
    }

    int getMaxWins() {
        askForRounds();
        while (true) {
            try {
                int maxWins = Integer.parseInt(scanner.nextLine());
                if (maxWins < 1) {
                    badMaxWinsInput();
                } else {
                    return maxWins;
                }
            } catch (NumberFormatException e) {
                badMaxWinsInput();
            }
        }
    }

    int getGameSubject() {
        askForSubject();
        while (true) {
            try {
                int subjectIndex = Integer.parseInt(scanner.nextLine()) - 1;
                if (subjectIndex < 0 || subjectIndex > 2) {
                    badSubjectInput();
                } else {
                    return subjectIndex;
                }
            } catch (NumberFormatException e) {
                badMaxWinsInput();
            }
        }
    }

    boolean getGameEndAction() {
        askForGameEndAction();
        while (true) {
            String gameEndAction = scanner.nextLine();
            if (gameEndAction.length() != 1 || (gameEndAction.charAt(0) != 'x' && gameEndAction.charAt(0) != 'n')) {
                badGameEndActionInput();
            } else {
                return !(gameEndAction.charAt(0) == 'x');
            }
        }
    }

    void showWinner(Player player) {

        if (player == null) {
            System.out.println("Tile");
        } else {
            System.out.println(player.getPlayerName() + " win");
        }
    }

    void showFinalResults(Player player1, Player player2) {
        System.out.printf("\n%43s", "RESULTS\n");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.printf("\n%30s%25s\n", "Player: " + player1.getPlayerName(), "Player: " + player2.getPlayerName());
        System.out.printf("Rounds Win: %8s%30s\n\n", player1.getRoundsWin(), player2.getRoundsWin());
        System.out.println("--------------------------------------------------------------------------------------\n");
    }

    private void askForName() {
        System.out.println("Welcome to STONE SCISSORS PAPER Game");
        System.out.println("Please enter your name ");
    }

    private void askForRounds() {
        System.out.println("Please Enter number of points after player wins.");
    }

    private void askForSubject() {
        System.out.println("Please select between (1)STONE (2)SCISSORS (3)PAPAER");
    }

    private void askForGameEndAction() {
        System.out.println("Game was ended. Please enter (n) for new game or (x) for exit");
    }

    private void badNameInput() {
        System.out.println("Incorrect name , please enter valid Name");
    }

    private void badMaxWinsInput() {
        System.out.println("Inccorect number, please enter valid number");
    }

    private void badSubjectInput() {
        System.out.println("Incorrect subject, please select correct object");
    }

    private void badGameEndActionInput() {
        System.out.println("Incorrect action, please select valid action (n) or (x) ");
    }

    void showFileNotFound(String configFile) {
        System.out.println("Game Configuration file " + configFile + " not found, using defaults.");
    }
}
