package com.kodilla.sudoku;

import java.util.Scanner;

public class Commander {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INCORRECT_NUMBER = "Incorrect number, please enter valid number";
    private static final String INPUT_NUMBER = "Please input number as xyn, where xy are position and n is value";
    private static final String WELCOME = "Please input number,\n" +
            "at xyn, where xy are position and n is value ,\n" +
            "\"sudoku\" show game result" + "\n" +
            "(x) - exit \n" +
            "(n) - restart ";

    public static int[] getField() {
        askForNumber();
        char[] fieldChar = new char[3];
        while (true) {
            fieldChar = getInput();
            System.out.println("pobrano " + String.valueOf(fieldChar));
            if (validateNumber(fieldChar)) {
                System.out.println("Poszedł break ");
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

    public static void getWelcome() {
        System.out.println(WELCOME);
    }

    private static void badNumber() {
        System.out.println(INCORRECT_NUMBER);
    }

    private static void askForNumber() {
        System.out.println(INPUT_NUMBER);
    }

    public static void main(String args[]) {
        Commander.getField();
    }
}
