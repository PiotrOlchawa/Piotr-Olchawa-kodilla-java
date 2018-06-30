/*           Subject map
           STONE    PAPER    SCISSORS
STONE       0         -1       1
PAPER       1          0      -1
SCISSORS   -1          1       0
*/

package com.kodilla.rps;

public class GameProcessor {

    private static final String CHEATER_OPTIONS = "Cheater";
    private static final int[][] CROSS_RULES = {{0, -1, 1}, {1, 0, -1}, {-1, 1, 0}};
    private UserPlayer userPlayer;
    private ComputerPlayer computer;
    private int maxWins;
    private int moveCounter = 1;

    GameProcessor(UserPlayer player, ComputerPlayer computer) {
        this.userPlayer = player;
        this.computer = computer;
    }

    void playGame(GameCommander gameCommander, GameConfigurator gameConfigurator) {
        String computerPlayerMode = gameConfigurator.getComputerMode();
        do {
            resetPlayersRoundsWin();
            maxWins = gameCommander.getMaxWins();
            while (hasNextRound()) {
                userPlayer.setMove(gameCommander.getGameSubject());
                gameCommander.showWinner(getPlayerAsWinner(getRoundResult(computerPlayerMode)));
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

    private int getRoundResult(String computerPlayerMode) {
        int playerMove = userPlayer.getMove();
        if (computerPlayerMode.equals(CHEATER_OPTIONS)) {
            return CROSS_RULES[playerMove][computer.getMove(playerMove, CROSS_RULES, moveCounter++)];
        } else {
            return CROSS_RULES[playerMove][computer.getMove()];
        }
    }

    private Player getPlayerAsWinner(int roundResult) {

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