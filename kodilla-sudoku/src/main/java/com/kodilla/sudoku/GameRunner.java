package com.kodilla.sudoku;

import lombok.extern.log4j.Log4j;
import org.apache.log4j.BasicConfigurator;

@Log4j
public class GameRunner {

    public static void main(String[] args) throws CloneNotSupportedException {

        BasicConfigurator.configure();
        Board board = new Board();
        //Validator validator = new Validator(BoardFiller.testFiller());
        GameRunner.setBoard1(board);
        //board = BoardFiller.testFiller();


        Resolver resolver = new Resolver(board);
        boolean result = false;
        int counter = 0;

            resolver.resolve();
            log.debug(resolver.getBoard().toString());
            log.info(resolver.getBoard().toString());

    }

    static void setBoard(Board board){

        board.getFields()[0][0].setValue(1);
        board.getFields()[1][1].setValue(2);
        board.getFields()[2][2].setValue(3);
        board.getFields()[3][3].setValue(4);
        board.getFields()[4][4].setValue(5);
        board.getFields()[5][5].setValue(6);
        board.getFields()[6][6].setValue(7);
        board.getFields()[7][7].setValue(8);
        board.getFields()[8][8].setValue(9);


    }

    static void setBoard1(Board board){




    }
}
