package ru.learnup.javaqa.qa_dz18_mvn.logic;

public class ConstantPlayer implements  Movable{
    private int speed;

    public ConstantPlayer(int speed){
        this.speed = speed;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }

    @Override
    public int getSpeed(){
        return this.speed;
    }
}
