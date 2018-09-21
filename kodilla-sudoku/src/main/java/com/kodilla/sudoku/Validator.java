package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.HashSet;
import lombok.extern.log4j.Log4j;

@Log4j
public class Validator {

    private Board board;

    public Validator(Board board) {
        this.board = board;
    }

    boolean validate() {
        log.debug("validateRow " + validateRow());
        log.debug("validateColumn " + validateColumn());
        log.debug("validateSection " + validateSection());
        return validateRow() && validateColumn() && validateSection();
    }

    @SuppressWarnings("Duplicates")
    private boolean validateRow() {
        ArrayList<Integer> rowNumbers = new ArrayList<>();
        for (int row = 0; row < Board.BOARD_SIZE; row++) {
            rowNumbers.clear();
            for (int column = 0; column < Board.BOARD_SIZE; column++) {
                int columnValue = board.getFields()[row][column].getValue();
                if (columnValue != Field.NO_VALUE) {
                    rowNumbers.add(columnValue);
                }
            }
            HashSet<Integer> numberSet = new HashSet<>(rowNumbers);
            if (rowNumbers.size() > numberSet.size()) {
                log.debug("validateRow error " + rowNumbers + " " + numberSet + " at " + row);
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("Duplicates")
    private boolean validateColumn() {
        ArrayList<Integer> columnNumbers = new ArrayList<>();
        for (int column = 0; column < Board.BOARD_SIZE; column++) {
            columnNumbers.clear();
            for (int row = 0; row < Board.BOARD_SIZE; row++) {
                int rowValue = board.getFields()[row][column].getValue();
                if (rowValue != Field.NO_VALUE) {
                    columnNumbers.add(rowValue);
                }
            }
            HashSet<Integer> numberSet = new HashSet<>(columnNumbers);
            if (columnNumbers.size() > numberSet.size()) {
                log.debug("validateColumn error " + columnNumbers + " " + numberSet + " at " + column);
                return false;
            }
        }
        return true;
    }


    private boolean validateSection() {
        ArrayList<Integer> sectionNumbers = new ArrayList<>();
        for (int row = 0; row < Board.BOARD_SIZE; row=row+Board.SUBSECTION_SIZE) {
            for (int column = 0; column < Board.BOARD_SIZE; column=column+Board.SUBSECTION_SIZE) {
                int subsectionRowStart = (row / Board.SUBSECTION_SIZE) * Board.SUBSECTION_SIZE;
                int subsectionRowEnd = subsectionRowStart + Board.SUBSECTION_SIZE;
                int subsectionColumnStart = (column / Board.SUBSECTION_SIZE) * Board.SUBSECTION_SIZE;
                int subsectionColumnEnd = subsectionColumnStart + Board.SUBSECTION_SIZE;
                sectionNumbers.clear();
                for (int r = subsectionRowStart; r < subsectionRowEnd; r++) {
                    for (int c = subsectionColumnStart; c < subsectionColumnEnd; c++) {
                        int sectionValue = board.getFields()[r][c].getValue();
                        if (sectionValue != Field.NO_VALUE) {
                            sectionNumbers.add(sectionValue);
                        }
                    }
                }
                HashSet<Integer> numberSet = new HashSet<>(sectionNumbers);
                if (sectionNumbers.size() > numberSet.size()) {
                    log.debug("validateSection error " + sectionNumbers + " " + numberSet + " at " + subsectionRowStart + " " + subsectionColumnStart);
                    return false;
                }
            }
        }
        return true;
    }
}