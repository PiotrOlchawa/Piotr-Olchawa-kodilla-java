package com.kodilla.sudoku;

import lombok.extern.log4j.Log4j;
import org.apache.log4j.BasicConfigurator;

@Log4j
public class GameRunner {

    public static void main(String[] args) {

        BasicConfigurator.configure();
        Board board = new Board();
        Validator validator = new Validator(BoardFiller.testFiller());
        GameRunner.setBoard(board);


        System.out.println("orginal przed" +board.toString());
        try {
            Board board1 = board.deepCopy();
            board1.getFields()[0][0].setValue(9);
            System.out.println("kopia" +board1.toString());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("zwykły" +board.toString());

        Resolver resolver = new Resolver(BoardFiller.testFiller());
        boolean result = false;
        int counter = 0;
        //while(result = true){

            //GameRunner.setBoard(board);
            //resolver.resolve();
            log.debug("Validate - validator " + validator.validate());
            log.debug(BoardFiller.testFiller());
            counter++;
            resolver.resolve();
            log.debug(resolver.getBoard().toString());
        //}
        //log.info(counter);
        //System.out.println(board.toString());



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
}
