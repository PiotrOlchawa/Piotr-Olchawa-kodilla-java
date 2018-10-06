package com.kodilla.sudoku;

import lombok.extern.log4j.Log4j;
import org.apache.log4j.BasicConfigurator;

@Log4j
public class GameRunner {

    public static void main(String[] args) {
        BasicConfigurator.configure();
        Board board = new Board();
        BoardUserFiller boardUserFiller = new BoardUserFiller(board);
        Menu menu = new Menu(boardUserFiller);
        menu.startGame();
    }
}
