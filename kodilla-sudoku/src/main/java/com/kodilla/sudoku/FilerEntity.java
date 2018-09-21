package com.kodilla.sudoku;

public class FilerEntity {

    private Board board;
    private int RowCoordinate;
    private int ColumnCoordinate;
    private int fieldValue;




    public Board getBoard() {
        return board;
    }

    public int getRowCoordinate() {
        return RowCoordinate;
    }

    public int getColumnCoordinate() {
        return ColumnCoordinate;
    }

    public int getFieldValue() {
        return fieldValue;
    }


    public void setBoard(Board board) {
        this.board = board;
    }

    public void setRowCoordinate(int rowCoordinate) {
        RowCoordinate = rowCoordinate;
    }

    public void setColumnCoordinate(int columnCoordinate) {
        ColumnCoordinate = columnCoordinate;
    }

    public void setFieldValue(int fieldValue) {
        this.fieldValue = fieldValue;
    }
}
