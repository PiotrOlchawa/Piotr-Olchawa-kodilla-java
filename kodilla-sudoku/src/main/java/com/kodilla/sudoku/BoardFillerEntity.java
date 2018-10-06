package com.kodilla.sudoku;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardFillerEntity {

    private Board board;
    private int rowCoordinate;
    private int columnCoordinate;
    private int fieldValue;

}
