package com.kodilla.sudoku;

import lombok.Getter;
import lombok.Setter;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import lombok.extern.log4j.Log4j;

@Log4j
public class BoardFiller {

    private static Random RANDOM = new Random();
    private List<FillerEntity> fillerEntities = new LinkedList<>();

    FillerEntity getLastFillerEntity(){
        return fillerEntities.get(fillerEntities.size()-1);
    }

    boolean fillField(Board board) throws CloneNotSupportedException {
        int rowCoordinate, columnCoordinate;
        FillerEntity fillerEntity = new FillerEntity();

        fillerEntity.setBoard(board.deepCopy());

        do {
            rowCoordinate = randomCoordinateSelector();
            columnCoordinate = randomCoordinateSelector();
        } while (!fieldHasNoValue(rowCoordinate, columnCoordinate, board));

        log.debug("wybrane pole" + rowCoordinate +" " + columnCoordinate);
        Field field = board.getFields()[rowCoordinate][columnCoordinate];
        int size = field.getAvailableValueList().size();
        if (size==0){
            log.debug("filling error");
            System.exit(1);
            //return false;
        }

        int randomlySelectedValue = randomAvaliableValueSelector(size);
        int setValue = field.getAvailableValueList().get(randomlySelectedValue);
        log.debug("Filling at position " + rowCoordinate + columnCoordinate + " with value " + setValue);
        field.setValue(setValue);
        field.deleteFromAvailableValueList(setValue);
        fillerEntity.setRowCoordinate(rowCoordinate);
        fillerEntity.setColumnCoordinate(columnCoordinate);
        fillerEntities.add(fillerEntity);
        return true;
    }

    Board recoverFromFillField()  {
        if (fillerEntities.size() != 0) {
            FillerEntity lastEntity = fillerEntities.get(fillerEntities.size() - 1);
            Board board = lastEntity.getBoard();
            int row = lastEntity.getRowCoordinate();
            int column = lastEntity.getColumnCoordinate();
            Field field = board.getFields()[row][column];
            field.resetField();
            field.addToAvailableValueList(lastEntity.getFieldValue());
            fillerEntities.remove(fillerEntities.size() - 1);
            log.debug("Recovering.. at " + row + " " + column);
            log.debug("Board from lastEntity " + board.toString());
            if(Validator.checkBoardForZero(board)){
                log.debug("recoverFromFillField()");
                System.exit(0);
            }

            try {
                return board.deepCopy();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        log.debug("Error - nothing to recover.");
        System.exit(1);
        return new Board();
    }


    private int randomCoordinateSelector() {
        return RANDOM.nextInt(Board.BOARD_SIZE);
    }

    private int randomAvaliableValueSelector(int value) {
        return RANDOM.nextInt(value);
    }

    private boolean fieldHasNoValue(int row, int column,Board board) {
        return board.getFields()[row][column].hasNoValue();
    }


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
