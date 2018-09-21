package com.kodilla.sudoku;

import java.util.LinkedList;

public class BoardFiller {

    private LinkedList<FilerEntity> filerEntity;


    static Board testFiller() {
        Board board = new Board();
        board.getFields()[0][1].setValue(2);
        board.getFields()[0][3].setValue(5);
        board.getFields()[0][5].setValue(1);
        board.getFields()[0][7].setValue(9);

        board.getFields()[1][0].setValue(8);
        board.getFields()[1][3].setValue(2);
        board.getFields()[1][5].setValue(3);
        board.getFields()[1][8].setValue(6);

        board.getFields()[2][1].setValue(3);
        board.getFields()[2][4].setValue(6);
        board.getFields()[2][7].setValue(7);

        board.getFields()[3][2].setValue(1);
        board.getFields()[3][6].setValue(6);

        board.getFields()[4][0].setValue(5);
        board.getFields()[4][1].setValue(4);
        board.getFields()[4][7].setValue(1);
        board.getFields()[4][8].setValue(9);

        board.getFields()[5][2].setValue(2);
        board.getFields()[5][6].setValue(7);

        board.getFields()[6][1].setValue(9);
        board.getFields()[6][4].setValue(3);
        board.getFields()[6][7].setValue(8);

        board.getFields()[7][0].setValue(2);
        board.getFields()[7][3].setValue(8);
        board.getFields()[7][5].setValue(4);
        board.getFields()[7][8].setValue(7);

        board.getFields()[8][1].setValue(1);
        board.getFields()[8][3].setValue(9);
        board.getFields()[8][5].setValue(7);
        board.getFields()[8][7].setValue(6);

        return board;
    }


}
