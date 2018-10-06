package com.kodilla.sudoku;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Field {

    public static final int NO_VALUE = -1;
    public static final int MAX_VALUE = 9;
    @Getter
    @Setter
    private List<Integer> availableValueList = new ArrayList<>();
    @Getter
    @Setter
    private int value = NO_VALUE;
    @Getter
    @Setter
    int coordinatex;
    @Getter
    @Setter
    int coordinatey;

    Field(int coordinatex, int coordinatey) {
        this.coordinatex = coordinatex;
        this.coordinatey = coordinatey;
        defaultAvaliableValueList();
    }

    boolean checkAvailiableValue(int value) {
        return availableValueList.contains(value);
    }

    void deleteFromAvailableValueList(int value) {
        availableValueList.remove(Integer.valueOf(value));
    }

    boolean hasNoValue() {
        if (value == NO_VALUE) {
            return true;
        }
        return false;
    }

    void resetAvailableValueList() {
        availableValueList.clear();
        defaultAvaliableValueList();
    }

    private void defaultAvaliableValueList() {
        Integer[] valueList = new Integer[MAX_VALUE];
        for (int i = 0; i < MAX_VALUE; i++) {
            valueList[i] = i + 1;
        }
        this.availableValueList = new ArrayList<>(Arrays.asList(valueList));
    }

}
