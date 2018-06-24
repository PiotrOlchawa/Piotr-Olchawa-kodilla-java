package com.kodilla.rps;

public class UserPlayer extends Player {

    private int move;

    public UserPlayer(String gameUserName) {
        super(gameUserName);
    }

    public void setMove(int move) {
        this.move = move;
    }

    @Override
    public int getMove() {
        return move;
    }
}
