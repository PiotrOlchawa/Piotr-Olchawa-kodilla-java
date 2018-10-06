package com.kodilla.sudoku;

import lombok.extern.log4j.Log4j;

import java.util.Arrays;
import java.util.Random;

@Log4j
public class RandomResolver {

    private static Random RANDOM = new Random();
    Board board;

    public RandomResolver(Board board) {
        this.board = board;
    }

    boolean resolve() {
        for (int row = 0; row < Board.BOARD_SIZE; row++) {
            for (int column = 0; column < Board.BOARD_SIZE; column++) {
                Field field = board.getFields()[row][column];
                int fieldValue = board.getFields()[row][column].getValue();
                if (fieldValue == Field.NO_VALUE) {
                    processRow(field, row);
                    processColumn(field, column);
                    processSection(field, row, column);
                    if (!setRandomValue(field)) {
                        return false;
                    }
                } else {

                    if (field.getAvailableValueList().contains(fieldValue)) {
                        field.getAvailableValueList().removeAll(Arrays.asList(fieldValue));
                    }
                }
            }
        }
        return true;
    }

    private void processRow(Field field, int row) {
        for (int column = 0; column < Board.BOARD_SIZE; column++) {
            int value = board.getFields()[row][column].getValue();
            if (field.checkAvailiableValue(value)) {
                field.deleteFromAvailableValueList(value);
            }
        }
    }

    private void processColumn(Field field, int column) {
        for (int row = 0; row < Board.BOARD_SIZE; row++) {
            int value = board.getFields()[row][column].getValue();
            if (field.checkAvailiableValue(value)) {
                field.deleteFromAvailableValueList(value);
            }
        }
    }

    private void processSection(Field field, int row, int column) {
        int subsectionRowStart = (row / Board.SUBSECTION_SIZE) * Board.SUBSECTION_SIZE;
        int subsectionRowEnd = subsectionRowStart + Board.SUBSECTION_SIZE;
        int subsectionColumnStart = (column / Board.SUBSECTION_SIZE) * Board.SUBSECTION_SIZE;
        int subsectionColumnEnd = subsectionColumnStart + Board.SUBSECTION_SIZE;
        for (int r = subsectionRowStart; r < subsectionRowEnd; r++) {
            for (int c = subsectionColumnStart; c < subsectionColumnEnd; c++) {
                int value = board.getFields()[r][c].getValue();
                if (field.checkAvailiableValue(value)) {
                    field.deleteFromAvailableValueList(value);
                }
            }
        }
    }

    private boolean processFieldForLastAvailiableValue(Field field) {
        if (field.getAvailableValueList().size() == 1) {
            field.setValue(field.getAvailableValueList().get(0));
            field.deleteFromAvailableValueList(0);
            return true;
        }
        return false;
    }

    private boolean setValue(Field field) {
        if (field.getAvailableValueList().size() > 0) {
            field.setValue(field.getAvailableValueList().get(0));
            field.getAvailableValueList().remove(0);
            return true;
        }
        return false;
    }

    private boolean setRandomValue(Field field) {
        if (field.getAvailableValueList().size() > 0) {
            int randomIndex = RANDOM.nextInt(field.getAvailableValueList().size());
            field.setValue(field.getAvailableValueList().get(randomIndex));
            field.getAvailableValueList().remove(randomIndex);
            return true;
        }
        return false;
    }
}

