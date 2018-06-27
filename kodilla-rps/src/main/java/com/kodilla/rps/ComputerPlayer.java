package com.kodilla.rps;

import java.util.Random;

public class ComputerPlayer extends Player {

    private static final Random RANDOM = new Random();
    private static final String COMPUTER = "Computer";
    private static int moveCounter = 1;

    public ComputerPlayer() {
        super(new String(COMPUTER));
    }

    public int getMove() {
        return RANDOM.nextInt(3);
    }

    public int getMove(int playerMove, int[][] crossRules) {

        // Tile
        if (moveCounter % 1+RANDOM.nextInt(3) == 0) {
            for (int i = 0; i < crossRules[playerMove].length; i++) {
                if (crossRules[playerMove][i] == 0) {
                    moveCounter++;
                    return i;
                }
            }
        }
        // Computer win
        if (moveCounter % 4 != 0) {
            for (int i = 0; i < crossRules[playerMove].length; i++) {
                if (crossRules[playerMove][i] == -1) {
                    moveCounter++;
                    return i;
                }
            }
        // Player win
        } else {
            for (int i = 0; i < crossRules[playerMove].length; i++) {
                if (crossRules[playerMove][i] == 1) {
                    moveCounter++;
                    return i;
                }
            }
        }
        return 0;
    }
}
