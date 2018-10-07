package com.kodilla.sudoku;

import lombok.extern.log4j.Log4j;

@Log4j
public class KodillaResolver implements Resolver {

    private BoardFiller boardFiller = new BoardFiller();
    private Validator validator = new Validator();
    private Board board;

    public KodillaResolver(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    @Override
    public void resolve() {
        log.info("Starting KodilaResolver");

        while (!board.isBoardCompleted()) {
            if (Validator.checkBoardForZero(board)) {
                log.debug("!board.isBoardCompleted()");
                System.exit(0);
            }
            validator.setBoard(this.board);
            if (!validator.validate(board)) System.exit(1);
            while (!processRowColumnSection()) {
                if (Validator.checkBoardForZero(board)) {
                    log.debug("!processRowColumnSection()");
                    System.exit(0);
                }
                log.debug("Filling Board");
                try {
                    boardFiller.fillField(this.board);
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
                log.debug("after filling");
                processRowColumnSection();
                log.debug(this.board.toString());
            }
        }
        Commander.showFinalValidation(board);

/*        if(validator.validate(board)){
            log.debug("Board is valid.");
            return true;
        }else {
            log.debug("Board is invalid");
            return false;
        }*/

    }


    private boolean processRowColumnSection() {
        boolean result = false;
        for (int row = 0; row < Board.BOARD_SIZE; row++) {
            for (int column = 0; column < Board.BOARD_SIZE; column++) {
                Field field = board.getFields()[row][column];
                int fieldValue = board.getFields()[row][column].getValue();
                if (fieldValue == Field.NO_VALUE) {

                    result = result
                            || processRow(field, row)
                            || processColumn(field, column)
                            || processSection(field, row, column)
                            || processFieldForLastAvailiableValue(field);
                }
            }
        }
        return result;
    }


    private boolean processRow(Field field, int row) {
        if (Validator.checkBoardForZero(board)) {
            log.debug("!processRow()");
            System.exit(0);
        }
        //if (!processFieldForLastAvailiableValue(field)) {
        boolean deleteOperation = false;
        for (int column = 0; column < Board.BOARD_SIZE; column++) {
            int value = board.getFields()[row][column].getValue();
            if (field.checkAvailiableValue(value)) {
                //delete value from other
                if (field.getAvailableValueList().size() > 1) {
                    field.deleteFromAvailableValueList(value);
                    deleteOperation = true;
                }
                // last value if is in other field --- recovery
                if (field.getAvailableValueList().size() == 1) {
                    for (int c = 0; c < Board.BOARD_SIZE; c++) {
                        if (field.getAvailableValueList().get(0) == board.getFields()[row][c].getValue()) {
                            log.debug("Row recovering");
                            this.board = boardFiller.recoverFromFillField();
                            return false;
                        }
                    }
                }

            }
        }
        boolean writeValue = true;
        for (int i = 0; i < field.getAvailableValueList().size(); i++) {
            int availableValue = field.getAvailableValueList().get(i);
            for (int column = 0; column < Board.BOARD_SIZE; column++) {
                Field checkedField = board.getFields()[row][column];
                if ((checkedField.getAvailableValueList().contains(availableValue)) || (checkedField.getValue() == availableValue)) {
                    //log.info(checkedField.getAvailableValueList() +" "+ checkedField.getValue() +" value "+ availableValue);
                    writeValue = false;
                }
            }
            if (writeValue) {
                field.setValue(availableValue);
                log.info("processRow" + availableValue);
                return true;
            }
        }

        return deleteOperation;
        //}
        //log.debug("Column Last Value");
        //return true;
    }

    private boolean processColumn(Field field, int column) {
        if (Validator.checkBoardForZero(board)) {
            log.debug("!processColumn()");
            System.exit(0);
        }
        //if (!processFieldForLastAvailiableValue(field)) {
        boolean deleteOperation = false;
        for (int row = 0; row < Board.BOARD_SIZE; row++) {
            int value = board.getFields()[row][column].getValue();
            if (field.checkAvailiableValue(value)) {
                //delete value from other
                if (field.getAvailableValueList().size() > 1) {
                    field.deleteFromAvailableValueList(value);
                    deleteOperation = true;
                    //log.debug("Deleting at col");
                }
                // last value if is in other field --- recovery
                if (field.getAvailableValueList().size() == 1) {
                    for (int r = 0; r < Board.BOARD_SIZE; r++) {
                        if (field.getAvailableValueList().get(0) == board.getFields()[r][column].getValue()) {
                            log.debug("Column recovering");
                            this.board = boardFiller.recoverFromFillField();
                            return false;
                        }
                    }
                }
            }
        }


        boolean writeValue = true;
        for (int i = 0; i < field.getAvailableValueList().size(); i++) {
            int availableValue = field.getAvailableValueList().get(i);
            for (int row = 0; row < Board.BOARD_SIZE; row++) {
                Field checkedField = board.getFields()[row][column];
                if ((checkedField.getAvailableValueList().contains(availableValue)) || (checkedField.getValue() == availableValue)) {
                    writeValue = false;
                }
            }
            if (writeValue) {
                field.setValue(availableValue);
                log.info("processColumn" + availableValue);
                return true;
            }
        }


        return deleteOperation;
        //}
        //log.debug("Column Last Value");
        //return true;
    }

    private boolean processSection(Field field, int row, int column) {
        if (Validator.checkBoardForZero(board)) {
            log.debug("!processSection()");
            System.exit(0);
        }
        //if (!processFieldForLastAvailiableValue(field)) {
        int subsectionRowStart = (row / Board.SUBSECTION_SIZE) * Board.SUBSECTION_SIZE;
        int subsectionRowEnd = subsectionRowStart + Board.SUBSECTION_SIZE;
        int subsectionColumnStart = (column / Board.SUBSECTION_SIZE) * Board.SUBSECTION_SIZE;
        int subsectionColumnEnd = subsectionColumnStart + Board.SUBSECTION_SIZE;
        boolean deleteOperation = false;
        for (int r = subsectionRowStart; r < subsectionRowEnd; r++) {
            for (int c = subsectionColumnStart; c < subsectionColumnEnd; c++) {
                int value = board.getFields()[r][c].getValue();
                if (field.checkAvailiableValue(value)) {

                    //delete value from other
                    if (field.getAvailableValueList().size() > 1) {
                        field.deleteFromAvailableValueList(value);
                        deleteOperation = true;
                        //log.debug("Deleting at col");
                    }
                    // last value if is in other field --- recovery
                    if (field.getAvailableValueList().size() == 1) {
                        for (int rchk = subsectionRowStart; rchk < subsectionRowEnd; rchk++) {
                            for (int cchk = subsectionColumnStart; cchk < subsectionColumnEnd; cchk++) {
                                if (field.getAvailableValueList().get(0) == board.getFields()[rchk][cchk].getValue()) {
                                    log.debug("Section recovering");
                                    this.board = boardFiller.recoverFromFillField();

                                    return false;
                                }
                            }
                        }
                    }
                }
            }


            boolean writeValue = true;
            for (int i = 0; i < field.getAvailableValueList().size(); i++) {
                int availableValue = field.getAvailableValueList().get(i);
                for (int rr = subsectionRowStart; rr < subsectionRowEnd; rr++) {
                    for (int cc = subsectionColumnStart; cc < subsectionColumnEnd; cc++) {
                        Field checkedField = board.getFields()[row][column];
                        if ((board.getFields()[rr][cc].getAvailableValueList().contains(availableValue)) || (checkedField.getValue() == availableValue)) {
                            writeValue = false;
                        }
                    }
                }
                if (writeValue) {
                    field.setValue(availableValue);
                    log.info("processSection" + availableValue);
                    return true;
                }
            }
        }
        return deleteOperation;
        //}
        //log.debug("Section Last Value");
        //return true;
    }

    private boolean processFieldForLastAvailiableValue(Field field) {
        if (field.getAvailableValueList().size() == 1) {
            log.debug("LastAvaliableValue " + field.getAvailableValueList().get(0) + "  at " + field.getCoordinatex() + " " + field.getCoordinatey());
            int lastValue = field.getAvailableValueList().get(0);
            field.setValue(lastValue);
            field.deleteFromAvailableValueList(lastValue);
            return true;
        }
        return false;
    }

}