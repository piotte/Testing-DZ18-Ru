package ru.learnup.javaqa.qa_dz18_mvn.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameManagerTest {

    @Test
    public void playerSurviveZeroClassicGame(){
        int[] speeds = {1,1,1,1,1};

        Game game = new Game(false);
        GameManager gameManager = new GameManager(game);

        int actual = gameManager.roundsSurvive(speeds);
        int expected = 0;

        Assertions.assertEquals(expected, actual, "Expected zero rounds due to classic game rules");
    }

    @Test
    public void playerSurviveAllClassicGame(){
        int[] speeds = {0,0,0,0,0};

        Game game = new Game(false);
        GameManager gameManager = new GameManager(game);

        int actual = gameManager.roundsSurvive(speeds);
        int expected = speeds.length;

        Assertions.assertEquals(expected, actual, "Expected all rounds due to classic game rules and no movement");
    }

    @Test
    public void playerSurviveNotAllClassicGame(){
        int[] speeds = {0,0,0,1,0};

        Game game = new Game(false);
        GameManager gameManager = new GameManager(game);

        int actual = gameManager.roundsSurvive(speeds);
        int expected = 3;

        Assertions.assertEquals(expected, actual, "Expected 3 rounds due to classic game rules and movement in 4 round");
    }

    @Test
    public void playerSurviveAllSpeedyGame(){
        int[] speeds = {1,1,1,1,1};

        SpeedyGame speedyGame = new SpeedyGame(false, 10);
        GameManager gameManager = new GameManager(speedyGame);

        int actual = gameManager.roundsSurvive(speeds);
        int expected = speeds.length;

        Assertions.assertEquals(expected, actual, "Expected all rounds due to speedy game rules and speed below limit");
    }

    @Test
    public void playerSurviveZeroSpeedyGame(){
        int[] speeds = {11,1,1,1,1};

        SpeedyGame speedyGame = new SpeedyGame(false, 10);
        GameManager gameManager = new GameManager(speedyGame);

        int actual = gameManager.roundsSurvive(speeds);
        int expected = 0;

        Assertions.assertEquals(expected, actual, "Expected zero rounds due to speedy game rules and speed over limit in 1 round");
    }

    @Test
    public void playerSurviveNotAllSpeedyGame(){
        int[] speeds = {1,1,11,1,1};

        SpeedyGame speedyGame = new SpeedyGame(false, 10);
        GameManager gameManager = new GameManager(speedyGame);

        int actual = gameManager.roundsSurvive(speeds);
        int expected = 2;

        Assertions.assertEquals(expected, actual, "Expected 2 rounds due to speedy game rules and speed over limit in 3 round");
    }

}
