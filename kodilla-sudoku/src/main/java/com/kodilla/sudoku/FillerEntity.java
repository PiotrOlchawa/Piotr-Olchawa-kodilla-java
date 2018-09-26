package com.kodilla.sudoku;

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
