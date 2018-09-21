package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Field {

    public static final int NO_VALUE = -1;
    public static final int MAX_VALUE = 9;

    private List<Integer> availableValueList = new ArrayList<>();
    private int value = NO_VALUE;

    Field() {
        defaultAvaliableValueList();
    }


    public List<Integer> getAvailableValueList() {
        return availableValueList;
    }

    void setValue(int value) {
        this.value = value;
    }

    int getValue() {
        return value;
    }

    boolean checkAvailiableValue(int value) {
        return availableValueList.contains(value);
    }

    void deleteValue(int value) {
        availableValueList.remove(Integer.valueOf(value));
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
