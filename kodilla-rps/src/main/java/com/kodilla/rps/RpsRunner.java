package com.kodilla.rps;

public class RpsRunner {

    private static final String CONFIG_FILE = "config.txt";

    public static void main(String args[]) {

        GameCommander gameCommander = new GameCommander();
        GameConfigurator gameConfigurator = new GameConfigurator(CONFIG_FILE, gameCommander);
        ComputerPlayer computerPlayer = new ComputerPlayer();
        UserPlayer userPlayer = new UserPlayer(gameCommander.getPlayerName());
        GameProcessor gameProcessor = new GameProcessor(userPlayer, computerPlayer);
        gameProcessor.playGame(gameCommander, gameConfigurator);

    }
}
