package com.kodilla.rps;

public class RpsRunner {

    public static void main(String args[]) {

        GameCommander gameCommander = new GameCommander();
        GameConfigurator gameConfigurator = new GameConfigurator("config.txt",gameCommander);
        ComputerPlayer computerPlayer = new ComputerPlayer();
        UserPlayer userPlayer = new UserPlayer(gameCommander.getPlayerName());
        GameProcessor gameProcessor = new GameProcessor(userPlayer, computerPlayer);
        gameProcessor.playGame(gameCommander,gameConfigurator);

    }
}
