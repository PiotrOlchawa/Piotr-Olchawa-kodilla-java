package com.kodilla.rps;

class UserPlayer extends Player {

    UserPlayer(String gameUserName) {
        super(gameUserName);
    }

    @Override
    public int getMove() {
        return 0;
    }

    int getMove(GameCommander gameCommander) {
        return gameCommander.getGameSubject();
    }

}
