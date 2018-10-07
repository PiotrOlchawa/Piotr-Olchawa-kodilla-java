package com.kodilla.sudoku.filler;

import com.kodilla.sudoku.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FillerEntity {

    private Board board;
    private int rowCoordinate;
    private int columnCoordinate;
    private int fieldValue;

}
