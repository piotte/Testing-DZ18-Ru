package ru.learnup.javaqa.qa_dz18_mvn.logic;

public class FastPlayer implements  Movable{
    private int speed;
    private int startSpeed;
    private int speedStep;

    public FastPlayer(int startSpeed, int speedStep){
        this.startSpeed = startSpeed;
        this.speed = startSpeed;
        this.speedStep = speedStep;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }

    @Override
    public int getSpeed(){
        // According to example first return speed, then increase speed
        int result = this.speed;
        this.speed += speedStep;
        return result;
    }
}
