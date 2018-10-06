package com.kodilla.sudoku;

import lombok.Getter;
import lombok.extern.log4j.Log4j;

@Log4j
public class ResolverTemp {

    @Getter
    private Board board;
    private BoardFiller boardFiller;
    private Validator validator;

    public ResolverTemp(Board board) {
        this.board = board;
        this.boardFiller = new BoardFiller();
        this.validator = new Validator();
    }

    boolean resolve() throws CloneNotSupportedException {

        while (!board.isBoardCompleted()) {
            log.debug(board.toString());
/*            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/


            while (!validator.checkBoard(board)){
                log.debug("checkboard() recover");
                this.board = boardFiller.recoverFromFillField();
            }
            log.debug(validator.checkBoard(board));
            log.debug("Filing board ");
            boardFiller.fillField(board);
            log.debug(board.toString());

            validator.setBoard(board);
            if (!validator.validateNewEntry(boardFiller.getLastFillerEntity().getRowCoordinate(), boardFiller.getLastFillerEntity().getColumnCoordinate())) {
                this.board = boardFiller.recoverFromFillField();
            }
            if(!rowColumnSectionLoop()) {
                this.board = boardFiller.recoverFromFillField();
            }
        }
        return true;
    }


    private boolean rowColumnSectionLoop() {
        for (int row = 0; row < Board.BOARD_SIZE; row++) {
            for (int column = 0; column < Board.BOARD_SIZE; column++) {
                Field field = board.getFields()[row][column];
                if (board.getFields()[row][column].getValue() == Field.NO_VALUE) {
                    return processRow(field, row) && processColumn(field, column) && processSection(field, row, column);
                }
            }
        }
        return true;
    }

    private boolean processRow(Field field, int row) {
        for (int column = 0; column < Board.BOARD_SIZE; column++) {
            int value = board.getFields()[row][column].getValue();
            if (field.checkAvailiableValue(value)) {
                field.deleteFromAvailableValueList(value);
                return true;
            }
        }
        return false;
    }

    private boolean processColumn(Field field, int column) {
        for (int row = 0; row < Board.BOARD_SIZE; row++) {
            int value = board.getFields()[row][column].getValue();
            if (field.checkAvailiableValue(value)) {
                field.deleteFromAvailableValueList(value);
                return true;
            }
        }
        return false;
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
                    field.deleteFromAvailableValueList(value);
                    return true;
                }
            }
        }
        return false;
    }
}

