package com.kodilla.rps;

class UserPlayer extends Player {

    UserPlayer(String gameUserName) {
        super(gameUserName);
    }

    @Override
    public int getMove() {
       return GameCommander.getGameSubject();
    }
}
