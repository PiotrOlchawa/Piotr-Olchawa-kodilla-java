package com.kodilla.rps;

import java.util.Random;

public class ComputerPlayer extends Player {

    private static final Random RANDOM = new Random();
    private static final String COMPUTER = "Computer";

    ComputerPlayer() {
        super(COMPUTER);
    }

    public int getMove() {
        return RANDOM.nextInt(3);
    }

    int getMove(int playerMove, int[][] crossRules) {

        int winnerSelector = RANDOM.nextInt(3);

        // Tile
        if (winnerSelector == 0) {
            for (int i = 0; i < crossRules[playerMove].length; i++) {
                if (crossRules[playerMove][i] == 0) {
                    return i;
                }
            }
        }
        // Computer win
        if (winnerSelector == 2) {
            for (int i = 0; i < crossRules[playerMove].length; i++) {
                if (crossRules[playerMove][i] == -1) {
                    return i;
                }
            }
        }
        // Random move
        return getMove();
    }
}

