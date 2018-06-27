package com.kodilla.rps;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameConfigurator {

    private Scanner scanner;
    private String computerMode;

    public GameConfigurator(String configFile, GameCommander gameCommander) {
        try {
            scanner = new Scanner(new File(configFile));
            setConfiugurationParamState("Ready");
        } catch (FileNotFoundException e) {
            gameCommander.showFileNotFound(configFile);
            computerMode = "Normal";
        }
    }

    public String getComputerMode() {

        if (computerMode.equals("Ready")) {
            return scanner.nextLine();
        } else {
            return computerMode;
        }
    }

    private void setConfiugurationParamState(String state){
        this.computerMode = state;
    }
}
