package ru.learnup.javaqa.qa_dz18_mvn.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SpeedyGameTest {

    @Test
    public void getSpeedLimit(){
        SpeedyGame speedyGame = new SpeedyGame(false, 10);

        int actual = speedyGame.getSpeedLimit();
        int expected = 10;

        Assertions.assertEquals(expected, actual, "Created with speedLimit 10");
    }

    @Test
    public void setPositiveSpeedLimit(){
        SpeedyGame speedyGame = new SpeedyGame(false, 10);
        speedyGame.setSpeedLimit(400);

        int actual = speedyGame.getSpeedLimit();
        int expected = 400;

        Assertions.assertEquals(expected, actual, "Created with speedLimit 10");
    }

    @Test
    public void setZeroSpeedLimit(){
        SpeedyGame speedyGame = new SpeedyGame(false, 10);
        speedyGame.setSpeedLimit(0);

        int actual = speedyGame.getSpeedLimit();
        int expected = 0;

        Assertions.assertEquals(expected, actual, "Created with speedLimit 10");
    }

    @Test
    public void setNegativeSpeedLimit(){
        SpeedyGame speedyGame = new SpeedyGame(false, 10);
        speedyGame.setSpeedLimit(-400);

        int actual = speedyGame.getSpeedLimit();
        int expected = 10;

        Assertions.assertEquals(expected, actual, "Created with speedLimit 10");
    }

    @Test
    public void playerZeroSpeedRemainRedLight(){
        SpeedyGame speedyGame = new SpeedyGame(false, 10);
        int speed = 0;

        boolean actual = speedyGame.isPlayerOut(speed);
        Assertions.assertFalse(actual, "Player must remain");
    }

    @Test
    public void playerSpeedEqualLimitRemainRedLight(){
        SpeedyGame speedyGame = new SpeedyGame(false, 10);
        int speed = 10;

        boolean actual = speedyGame.isPlayerOut(speed);
        Assertions.assertFalse(actual, "Player must remain");
    }

    @Test
    public void negativePlayerSpeedEqualLimitRemainRedLight(){
        SpeedyGame speedyGame = new SpeedyGame(false, 10);
        int speed = -10;

        boolean actual = speedyGame.isPlayerOut(speed);
        Assertions.assertFalse(actual, "Player must remain");
    }

    @Test
    public void playerSpeedLessLimitRemainRedLight(){
        SpeedyGame speedyGame = new SpeedyGame(false, 10);
        int speed = 4;

        boolean actual = speedyGame.isPlayerOut(speed);
        Assertions.assertFalse(actual, "Player must remain");
    }

    @Test
    public void playerSpeedOverLimitOutRedLight(){
        SpeedyGame speedyGame = new SpeedyGame(false, 10);
        int speed = 11;

        boolean actual = speedyGame.isPlayerOut(speed);
        Assertions.assertTrue(actual, "Player must out");
    }

    @Test
    public void negativePlayerSpeedOverLimitOutRedLight(){
        SpeedyGame speedyGame = new SpeedyGame(false, 10);
        int speed = -11;

        boolean actual = speedyGame.isPlayerOut(speed);
        Assertions.assertTrue(actual, "Player must out");
    }


    @Test
    public void playerMoveRemainGreenLight(){
        SpeedyGame speedyGame = new SpeedyGame(true, 10);
        int speed = 11;

        boolean actual = speedyGame.isPlayerOut(speed);
        Assertions.assertFalse(actual, "Player must remain");
    }

}
