package com.kodilla.sudoku;

public class Board extends Prototype {

    //prptotype -zgadywanie
    //osobna klasa validacyjna do numerow usera, po kazdym inpucie.

    static final int BOARD_SIZE = 9;
    static final int SUBSECTION_SIZE = 3;
    private static final String BOARD_HORIZONTAL_HEADER = "    1   2   3   4   5   6   7   8   9\n";
    private Field fields[][] = new Field[BOARD_SIZE][BOARD_SIZE];

    Board() {
        initBoard();
    }

    Field[][] getFields() {
        return this.fields;
    }

    public void setFields(Field[][] fields) {
        this.fields = fields;
    }

    public void resetBoard() {
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[0].length; j++) {
                fields[i][j].setValue(Field.NO_VALUE);
                fields[i][j].resetAvailableValueList();
            }
        }
    }

    private void initBoard() {
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[0].length; j++) {
                fields[i][j] = new Field();
            }
        }
    }

    public boolean isCompleted() {

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (fields[i][j].getValue() == Field.NO_VALUE) {
                    return false;
                }
            }
        }
        return true;
    }

    public Board shallowCopy() throws CloneNotSupportedException {
        return (Board)super.clone();
    }

    public Board deepCopy() throws CloneNotSupportedException {
        Board clonedBoard = (Board)super.clone();
        clonedBoard.fields = new Field[BOARD_SIZE][BOARD_SIZE];
        for (int row = 0; row < Board.BOARD_SIZE; row++) {
            for (int column = 0; column < Board.BOARD_SIZE; column++) {
                clonedBoard.fields[row][column] = new Field();
                clonedBoard.fields[row][column].setValue(fields[row][column].getValue());
            }
        }
        return clonedBoard;
    }

    @Override
    public String toString() {
        StringBuilder results = new StringBuilder();
        results.append(BOARD_HORIZONTAL_HEADER);
        for (int i = 0; i < fields.length; i++) {
            results.append('\n').append(i + 1).append("   ");
            for (int j = 0; j < fields[i].length; j++) {
                if (fields[i][j].getValue() == Field.NO_VALUE) {
                    results.append(fields[i][j].getValue()).append(" | ");
                } else {
                    results.append(fields[i][j].getValue()).append("  | ");
                }
            }
        }
        return results.toString();
    }

}
