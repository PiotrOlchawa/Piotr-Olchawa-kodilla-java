package com.kodilla.sudoku;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Menu {

    BoardUserFiller boardUserFiller;

    public void startGame() {
        Commander.getWelcome();
        while (true) {
            makeChoice();
        }
    }

    private void makeChoice() {
        switch (Commander.getGameAction()) {
            case 'x':
                exitSudoku();
                break;
            case 'n':
                startSudoku();
                break;
            default:
        }
    }

    private void startSudoku() {
        boardUserFiller.getBoard().resetBoard();
        while (true) {
            String entry = Commander.getUserEntry();
            if (entry.equals(Commander.getSolutionCommand())) {
                resolveSudoku(selectResolver());
                break;
            } else if (Commander.checkUserEntry(entry)) {
                boardUserFiller.fillSingleField(entry);
                System.out.println(boardUserFiller.getBoard().toString());
            }
        }
    }

    private void exitSudoku() {
        Commander.getExit();
        System.exit(0);
    }

    private void resolveSudoku(Resolver resolver) {
        Commander.getFinalSolution();
        resolver.resolve();
        boardUserFiller.getBoard().toString();
    }

    private Resolver selectResolver() {
        return Commander.getResolver(boardUserFiller.getBoard());
    }
}

