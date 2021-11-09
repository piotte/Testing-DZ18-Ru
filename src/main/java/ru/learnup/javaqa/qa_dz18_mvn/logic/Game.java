package ru.learnup.javaqa.qa_dz18_mvn.logic;

import lombok.Data;
import static java.lang.Math.abs;

public class Game {
    private boolean isGreenLight;

    public Game(boolean isGreenLight){
        this.isGreenLight = isGreenLight;
    }

    public boolean getIsGreenLight(){
        return this.isGreenLight;
    }

    public void setIsGreenLight(boolean value){
        this.isGreenLight = value;
    }

    public boolean isPlayerOut(int speed){
        return !this.isGreenLight && (abs(speed) > 0);
    }
}
