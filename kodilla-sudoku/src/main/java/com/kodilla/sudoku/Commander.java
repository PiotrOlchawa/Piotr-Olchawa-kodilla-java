package com.kodilla.sudoku;

import java.util.Scanner;

public class Commander {

    private static final Scanner SCANNER = new Scanner(System.in);

    private static final String MENU_TEXT="Please input number,\n"  +
            "at xyn, where xy are position and n is value ,\n" +
            "\"sudoku\" show game result"+"\n"+
            "(x) - exit \n" +
            "(n) - restart ";

    static char [] getUserAction(){
        return SCANNER.nextLine().toCharArray();
    }

    static String makeChoice() {
        return null;
    }
}
