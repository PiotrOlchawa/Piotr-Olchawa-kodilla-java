package com.kodilla.sudoku;

import com.kodilla.sudoku.filler.UserFiller;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.BasicConfigurator;

@Log4j
public class GameRunner {

    public static void main(String[] args) {
        BasicConfigurator.configure();
        Board board = new Board();
        UserFiller boardUserFiller = new UserFiller(board);
        MenuDriver menuDriver = new MenuDriver(boardUserFiller);
        menuDriver.startGame();
    }
}
