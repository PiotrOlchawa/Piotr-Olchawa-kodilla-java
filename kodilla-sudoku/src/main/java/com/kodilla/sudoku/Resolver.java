package com.kodilla.sudoku;

import lombok.extern.log4j.Log4j;

import java.util.Arrays;
import java.util.Random;

@Log4j
public class Resolver {

    private static Random RANDOM = new Random();
    private Board board;

    public Resolver(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    boolean resolve() {

        boolean pr = false, pc = false, ps = false;
        for (int row = 0; row < Board.BOARD_SIZE; row++) {
            for (int column = 0; column < Board.BOARD_SIZE; column++) {
                Field field = board.getFields()[row][column];
                int fieldValue = board.getFields()[row][column].getValue();
                if (fieldValue == Field.NO_VALUE) {
                    pr = processRow(field, row);
                    pc = processColumn(field, column);
                    ps = processSection(field, row, column);

                } else {

                    if (field.getAvailableValueList().contains(fieldValue)) {
                        field.getAvailableValueList().removeAll(Arrays.asList(fieldValue));
                    }
                }
            }
        }

        if (board.isCompleted()) {
            return true;
        }
        log.debug("pr " + pr + " pc " + pc + " ps " + ps);
        return pr || pc || ps;
    }

    private boolean processRow(Field field, int row) {
        if (!processFieldForLastAvailiableValue(field)) {
            for (int column = 0; column < Board.BOARD_SIZE; column++) {
                int value = board.getFields()[row][column].getValue();
                if (field.checkAvailiableValue(value)) {
                    if (field.getAvailableValueList().size() > 0) {
                        field.deleteValue(value);
                    } else {
                        log.debug("errorRow");
                    }
                }
            }
            boolean writeValue = true;
            for (int i = 0; i < field.getAvailableValueList().size(); i++) {
                int availableValue = field.getAvailableValueList().get(i);
                for (int column = 0; column < Board.BOARD_SIZE; column++) {
                    if (board.getFields()[row][column].getAvailableValueList().contains(availableValue)) {
                        writeValue = false;
                        //log.debug("row contains" + availableValue);
                    }
                }
                if (writeValue) {
                    field.setValue(availableValue);
                    log.debug("processRow" + availableValue);
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    private boolean processColumn(Field field, int column) {
        if (!processFieldForLastAvailiableValue(field)) {
            for (int row = 0; row < Board.BOARD_SIZE; row++) {
                int value = board.getFields()[row][column].getValue();
                if (field.checkAvailiableValue(value)) {
                    if (field.getAvailableValueList().size() > 0) {
                        field.deleteValue(value);
                    } else {
                        log.debug("errorColumn");
                    }
                }
            }
            boolean writeValue = true;
            for (int i = 0; i < field.getAvailableValueList().size(); i++) {
                int availableValue = field.getAvailableValueList().get(i);
                for (int row = 0; row < Board.BOARD_SIZE; row++) {
                    if (board.getFields()[row][column].getAvailableValueList().contains(availableValue)) {
                        writeValue = false;
                        //log.debug("column contains" + availableValue);
                    }
                }
                if (writeValue) {
                    field.setValue(availableValue);
                    log.debug("processColumn" + availableValue);
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    private boolean processSection(Field field, int row, int column) {
        int subsectionRowStart = (row / Board.SUBSECTION_SIZE) * Board.SUBSECTION_SIZE;
        int subsectionRowEnd = subsectionRowStart + Board.SUBSECTION_SIZE;
        int subsectionColumnStart = (column / Board.SUBSECTION_SIZE) * Board.SUBSECTION_SIZE;
        int subsectionColumnEnd = subsectionColumnStart + Board.SUBSECTION_SIZE;
        for (int r = subsectionRowStart; r < subsectionRowEnd; r++) {
            for (int c = subsectionColumnStart; c < subsectionColumnEnd; c++) {
                int value = board.getFields()[r][c].getValue();
                if (field.checkAvailiableValue(value)) {
                    if (field.getAvailableValueList().size() > 0) {
                        field.deleteValue(value);
                    } else {
                        log.debug("error");
                    }
                }
            }
        }

        boolean writeValue = true;
        for (int i = 0; i < field.getAvailableValueList().size(); i++) {
            int availableValue = field.getAvailableValueList().get(i);
            for (int r = subsectionRowStart; r < subsectionRowEnd; r++) {
                for (int c = subsectionColumnStart; c < subsectionColumnEnd; c++) {
                    if (board.getFields()[r][c].getAvailableValueList().contains(availableValue)) {
                        writeValue = false;
                        //log.debug("section contains" + availableValue);
                    }
                }
            }
            if (writeValue) {
                field.setValue(availableValue);
                log.debug("processSection" + availableValue);
                return true;
            }
            return false;
        }
        return true;
    }


    private boolean processFieldForLastAvailiableValue(Field field) {
        if (field.getAvailableValueList().size() == 1) {
            field.setValue(field.getAvailableValueList().get(0));
            field.deleteValue(0);
            return true;
        }
        return false;
    }

}

