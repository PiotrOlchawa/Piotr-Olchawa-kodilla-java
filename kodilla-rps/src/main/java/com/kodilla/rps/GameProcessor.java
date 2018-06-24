package com.kodilla.rps;

public class GameProcessor {

    private UserPlayer userPlayer;
    private ComputerPlayer computer;
    private int maxWins;
    private int[][] crossRules = {{0, -1, 1}, {1, 0, -1}, {-1, 1, 0}};

    /*           Subject map
           STONE    PAPER    SCISSORS
STONE       0         -1       1
PAPER       1          0      -1
SCISSORS   -1          1       0
*/

    public GameProcessor(UserPlayer player, ComputerPlayer computer) {
        this.userPlayer = player;
        this.computer = computer;
    }


    public void playGame(GameCommander gameCommander) {
        do {
            resetPlayersRoundsWin();
            maxWins = gameCommander.getMaxWins();
            while (hasNextRound()) {
                userPlayer.setMove(gameCommander.getGameSubject());
                gameCommander.showWinner(getRoundWinner());
            }
            gameCommander.showFinalResults(userPlayer, computer);

        } while (gameCommander.getGameEndAction());
    }

    private void resetPlayersRoundsWin() {
        userPlayer.setRoundsWin(0);
        computer.setRoundsWin(0);
    }

    private boolean hasNextRound() {
        return computer.getRoundsWin() < maxWins && userPlayer.getRoundsWin() < maxWins;
    }

    private Player getRoundWinner() {

        int roundResult = crossRules[userPlayer.getMove()][computer.getMove()];
        if (roundResult == -1) {
            computer.setRoundsWin(computer.getRoundsWin() + 1);
            return computer;
        }
        if (roundResult == 1) {
            userPlayer.setRoundsWin(userPlayer.getRoundsWin() + 1);
            return userPlayer;
        }
        return null;
    }

}