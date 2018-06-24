package com.kodilla.rps;

import java.util.Random;

public class ComputerPlayer extends Player {

    private static final Random RANDOM = new Random();
    private static final String COMPUTER = "Computer";

    public ComputerPlayer() {

        super(new String(COMPUTER));
    }

    public int getMove() {
        return RANDOM.nextInt(3);
    }

    public int getMove(Player player){




        return 0;
    }
}
