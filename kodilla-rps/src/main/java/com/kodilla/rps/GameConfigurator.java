package com.kodilla.rps;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class GameConfigurator {

    private String computerMode;
    private static final String OPTION_CHEATER = "Cheater";
    private static final String OPTION_NORMAL = "Normal";

    GameConfigurator(String configFile, GameCommander gameCommander) {
        try {
            Scanner scanner = new Scanner(new File(configFile));
            String param = scanner.nextLine();

            if (param.equals(OPTION_CHEATER) || param.equals(OPTION_NORMAL)) {
                this.computerMode = param;
            } else {
                this.computerMode = OPTION_NORMAL;
            }
        } catch (FileNotFoundException e) {
            gameCommander.showFileNotFound(configFile);
            this.computerMode = OPTION_NORMAL;
        }
    }

    String getComputerMode() {
        return this.computerMode;
    }
}
