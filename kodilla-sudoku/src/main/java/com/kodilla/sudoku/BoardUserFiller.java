package com.kodilla.sudoku;

import lombok.Getter;

public class BoardUserFiller {

    @Getter
    Board board;
    Validator validator;

    public BoardUserFiller(Board board) {
        this.board = board;
        validator = new Validator(board);
    }

    public void fillSingleField(String entry) {
        int[] field = Commander.getField(entry);
        if (validator.validateNewEntry(field[0] - 1, field[1] - 1)) {
            board.getFields()[field[0] - 1][field[1] - 1].setValue(field[2]);
         } else {
            Commander.showValidationError();
        }
    }
}
