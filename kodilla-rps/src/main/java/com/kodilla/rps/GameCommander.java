package com.kodilla.rps;

import java.util.Scanner;

class GameCommander {

    private static final Scanner SCANNER = new Scanner(System.in);

    private static final String WELCOME = "Welcome to STONE SCISSORS PAPER Game";
    private static final String INPUT_NEAME = "Please enter your name ";
    private static final String INPUT_MAX_POINTS = "Please Enter number of points after player wins.";
    private static final String SELECT_SUBJECT = "Please select between (1)STONE (2)SCISSORS (3)PAPER";
    private static final String INPUT_END_OPTION = "Game was ended. Please enter (n) for new game or (x) for exit";
    private static final String BAD_NAME_INPUT = "Incorrect name , please enter valid Name";
    private static final String BAD_MAXWINS_INPUT = "Inccorect number, please enter valid number";
    private static final String BAD_SUBJECT_INPUT = "Incorrect subject, please select correct object";
    private static final String BAD_END_ACTION = "Incorrect action, please select valid action (n) or (x) ";
    private static final String BAD_CONFIG_FILE = "Game Configuration file not found, using defaults.";

    String getPlayerName() {
        askForName();
        while (true) {
            String input = SCANNER.nextLine();
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
                int maxWins = Integer.parseInt(SCANNER.nextLine());
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

    static int getGameSubject() {
        askForSubject();
        while (true) {
            try {
                int subjectIndex = Integer.parseInt(SCANNER.nextLine()) - 1;
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
            String gameEndAction = SCANNER.nextLine();
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
        System.out.println(WELCOME);
        System.out.println(INPUT_NEAME);
    }

    private void askForRounds() {
        System.out.println(INPUT_MAX_POINTS);
    }

    private static void askForSubject() {
        System.out.println(SELECT_SUBJECT);
    }

    private void askForGameEndAction() {
        System.out.println(INPUT_END_OPTION);
    }

    private void badNameInput() {
        System.out.println(BAD_NAME_INPUT);
    }

    private static void badMaxWinsInput() {
        System.out.println(BAD_MAXWINS_INPUT);
    }

    private static void badSubjectInput() {
        System.out.println(BAD_SUBJECT_INPUT);
    }

    private void badGameEndActionInput() {
        System.out.println(BAD_END_ACTION);
    }

    void showFileNotFound(String configFile) {
        System.out.println(BAD_CONFIG_FILE + configFile);
    }
}
