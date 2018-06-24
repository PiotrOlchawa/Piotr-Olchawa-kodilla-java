package com.kodilla.rps;

public abstract class Player {

    private String playerName;
    private int roundsWin = 0;

    public Player(String gameUserName) {
        this.playerName = gameUserName;
    }

    public int getRoundsWin() {
        return roundsWin;
    }

    public void setRoundsWin(int roundsWin) {
        this.roundsWin = roundsWin;
    }

    public String getPlayerName() {
        return playerName;
    }

    public abstract int getMove();

}
