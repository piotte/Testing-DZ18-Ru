package ru.learnup.javaqa.qa_dz18_mvn.logic;

import static java.lang.Math.abs;

public class SpeedyGame extends Game{
    private int speedLimit;

    public SpeedyGame(boolean isGreenLight, int speedLimit) {
        super(isGreenLight);
        if (speedLimit < 0) {
            return;
        }
        this.speedLimit = speedLimit;
    }

    public int getSpeedLimit(){
        return speedLimit;
    }

    public void setSpeedLimit(int value){
        if (value < 0) {
            return;
        }
        this.speedLimit = value;
    }

    public boolean isPlayerOut(int speed){
        return !this.getIsGreenLight() && (abs(speed) > this.speedLimit);
    }
}
