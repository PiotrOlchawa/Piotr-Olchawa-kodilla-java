package com.kodilla.rps;

abstract class Player {

    private String playerName;
    private int roundsWin = 0;

    Player(String gameUserName) {
        this.playerName = gameUserName;
    }

    int getRoundsWin() {
        return roundsWin;
    }

    void setRoundsWin(int roundsWin) {
        this.roundsWin = roundsWin;
    }

    String getPlayerName() {
        return playerName;
    }

    public abstract int getMove();

}
