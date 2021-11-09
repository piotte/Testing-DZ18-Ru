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

    @Test
    public void firstPlayerWinClassicGame(){
        Game game = new Game(false);
        GameManager gameManager = new GameManager(game);
        ConstantPlayer First = new ConstantPlayer(0);
        FastPlayer Second = new FastPlayer(1, 2);

        int actual = gameManager.loser(First, Second, game, 5);
        int expected = 1;

        Assertions.assertEquals(expected, actual, "Expected 1 as first player win");
    }

    @Test
    public void secondPlayerWinClassicGame(){
        Game game = new Game(false);
        GameManager gameManager = new GameManager(game);
        ConstantPlayer First = new ConstantPlayer(4);
        FastPlayer Second = new FastPlayer(0, 0);

        int actual = gameManager.loser(First, Second, game, 5);
        int expected = -1;

        Assertions.assertEquals(expected, actual, "Expected -1 as second player win");
    }

    @Test
    public void bothPlayersWinClassicGame(){
        Game game = new Game(false);
        GameManager gameManager = new GameManager(game);
        ConstantPlayer First = new ConstantPlayer(0);
        FastPlayer Second = new FastPlayer(0, 0);

        int actual = gameManager.loser(First, Second, game, 5);
        int expected = 0;

        Assertions.assertEquals(expected, actual, "Expected 0 as both players survive");
    }

    @Test
    public void firstPlayerWinSpeedyGame(){
        SpeedyGame speedyGame = new SpeedyGame(false, 10);
        GameManager gameManager = new GameManager(speedyGame);
        ConstantPlayer First = new ConstantPlayer(9);
        FastPlayer Second = new FastPlayer(4, 5);

        int actual = gameManager.loser(First, Second, speedyGame, 5);
        int expected = 1;

        Assertions.assertEquals(expected, actual, "Expected 1 as first player win");
    }


    @Test
    public void secondPlayerWinSpeedyGame(){
        SpeedyGame speedyGame = new SpeedyGame(false, 10);
        GameManager gameManager = new GameManager(speedyGame);
        ConstantPlayer First = new ConstantPlayer(19);
        FastPlayer Second = new FastPlayer(4, 5);

        int actual = gameManager.loser(First, Second, speedyGame, 5);
        int expected = -1;

        Assertions.assertEquals(expected, actual, "Expected -1 as second player win");
    }

    @Test
    public void bothPlayersWinSpeedyGame(){
        SpeedyGame speedyGame = new SpeedyGame(false, 10);
        GameManager gameManager = new GameManager(speedyGame);
        ConstantPlayer First = new ConstantPlayer(9);
        FastPlayer Second = new FastPlayer(4, 1);

        int actual = gameManager.loser(First, Second, speedyGame, 5);
        int expected = 0;

        Assertions.assertEquals(expected, actual, "Expected 0 as both players don't lose");
    }

}
