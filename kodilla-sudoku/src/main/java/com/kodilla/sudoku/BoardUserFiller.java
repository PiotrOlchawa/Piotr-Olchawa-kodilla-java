package com.kodilla.sudoku;

import lombok.Getter;
import lombok.extern.log4j.Log4j;

@Log4j
public class BoardUserFiller {

    @Getter
    Board board;

    public BoardUserFiller(Board board) {
        this.board = board;
    }

    public void fillSingleField(String entry) {

        int[] field = Commander.getField(entry);
        try {
            Board boarDeepCopy = board.deepCopy();
            boarDeepCopy.getFields()[field[0] - 1][field[1] - 1].setValue(field[2]);
            Validator validator = new Validator(boarDeepCopy);
            if (!validator.validateNewEntry((field[0] - 1), (field[1] - 1))) {
                Commander.showValidationError();
            }else {
                board.getFields()[field[0] - 1][field[1] - 1].setValue(field[2]);
                log.debug("Entry Board " + board.toString());
                log.debug("Entry is Valid " + (field[0] - 1) + (field[1] - 1));
            }

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
