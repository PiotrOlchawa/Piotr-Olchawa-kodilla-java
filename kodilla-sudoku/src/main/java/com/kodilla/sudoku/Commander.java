package com.kodilla.sudoku;

import java.util.Scanner;

public class Commander {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INCORRECT_NUMBER = "Incorrect number, please enter valid number";
    private static final String INPUT_NUMBER = "Please input number as xyn, where xy are position and n is value";
    private static final String EXITING = "Game ended....";
    private static final String BAD_GAME_ACTION = "Bad game action !";
    private static final String SUDOKU_SOLUTION = "Sudoku Solution";
    private static final String SUDOKU_RESOLVE = "sudoku";
    private static final String WELCOME = "Please input number,\n" +
            "at xyn, where xy are position and n is value ,\n" +
            "\"sudoku\" show game result" + "\n" +
            "(x) - exit \n" +
            "(n) - restart ";
    private static final String VALIDATION_ERROR = "Input data validation error !";
    private static final String RESOLVER = "Choose resolver (1)Kodilla resolver (2)Random resolver";
    private static final String RESOLVER_BAD = "Input is not correct please input correct resolver";

    public static int[] getField() {
        askForNumber();
        char [] fieldChar;
        while (true) {
            fieldChar = getInput();
            if (validateNumber(fieldChar)) {
                break;
            } else {
                badNumber();
            }
        }
        return convertCharArrayToIntArray(fieldChar);
    }

    public static int[] getField(String entry) {
        char [] fieldChar = entry.toCharArray();
        while (true) {
            fieldChar = getInput();
            if (validateNumber(fieldChar)) {
                break;
            } else {
                badNumber();
            }
        }
        return convertCharArrayToIntArray(fieldChar);

    }

    private static char[] getInput() {
        return SCANNER.nextLine().toCharArray();
    }

    private static boolean validateNumber(char[] fieldChar) {
        if (fieldChar.length < 3) {
            return false;
        }
        for (int i = 0; i < fieldChar.length; i++) {
            try {
                int value = Integer.parseInt(String.valueOf(fieldChar[i]));
                if (value < 1 || value > 9) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    private static int[] convertCharArrayToIntArray(char[] fieldChar) {
        int[] fieldInt = new int[3];
        for (int i = 0; i < fieldChar.length; i++) {
            fieldInt[i] = Integer.parseInt(String.valueOf(fieldChar[i]));
        }
        return fieldInt;
    }

    public static String getUserEntry() {
        return SCANNER.nextLine();
    }

    public static String getSolutionCommand() {
        return SUDOKU_RESOLVE;
    }

    public static void showValidationError() {
        System.out.println(VALIDATION_ERROR);
    }


    public static char getGameAction() {
        askForGameAction();
        while (true) {
            String gameEndAction = SCANNER.nextLine();
            if ((gameEndAction.charAt(0) != 'x' && gameEndAction.length() == 1)
                    || (gameEndAction.charAt(0) != 'n' && gameEndAction.length() == 1)
                ) {
                badGameActionInput();
            } else {
                return gameEndAction.charAt(0);
            }
        }
    }

    private static void badGameActionInput() {
        System.out.println(BAD_GAME_ACTION);
    }

    private static void askForGameAction() {
    }


    public static void getWelcome() {
        System.out.println(WELCOME);
    }

    private static void badNumber() {
        System.out.println(INCORRECT_NUMBER);
    }

    private static void askForNumber() {
        System.out.println(INPUT_NUMBER);
    }

    public static void getExit() {
        System.out.println(EXITING);
    }

    public static Resolver getResolver(Board board) {
        askForResolver();
        while (true) {
            try {
                int intResolverChoice = Integer.parseInt(SCANNER.nextLine());
                if (intResolverChoice < 1 || intResolverChoice > 2) {
                    badResolver();
                } else {
                    if(intResolverChoice == 1){
                        return new KodillaResolver(board);
                    }else {
                        return new RandomResolver(board);
                    }
                }
            } catch (NumberFormatException e) {
                badResolver();
            }
        }
    }

    private static void askForResolver() {
        System.out.println(RESOLVER);
    }

    private static void badResolver() {
        System.out.println(RESOLVER_BAD);
        System.out.println(RESOLVER);
    }


    public static void getFinalSolution() {
    System.out.println(SUDOKU_SOLUTION);
    }
}
