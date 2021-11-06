package ru.learnup.javaqa.qa_dz18_mvn.logic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class GameCoreTest {

    @Test
    public void zeroSpeedPlayerMustRemain(){
        GameCore.isGreenLight = false;
        GameCore.MAX_SPEED = 10;
        int speed = 0;
        boolean actual = GameCore.isPlayerOut(speed);
        Assertions.assertFalse(actual, "Player who don't move continues game");
    }

    @Test
    public void positiveSpeedLessMAXSPEEDWithRedLightPlayerMustRemain(){
        GameCore.isGreenLight = false;
        GameCore.MAX_SPEED = 10;
        int speed = 7;
        boolean actual = GameCore.isPlayerOut(speed);
        Assertions.assertFalse(actual,
                "Speed less than limit is allowed");
    }

    @Test
    public void negativeSpeedLessMAXSPEEDWithRedLightPlayerMustRemain(){
        GameCore.isGreenLight = false;
        GameCore.MAX_SPEED = 10;
        int speed = -7;
        boolean actual = GameCore.isPlayerOut(speed);
        Assertions.assertFalse(actual,
                "Speed less than limit is allowed");
    }

    @Test
    public void SpeedEqualMAXSPEEDWithReLightPlayerMustRemain(){
        GameCore.isGreenLight = false;
        GameCore.MAX_SPEED = 10;
        int speed = 10;
        boolean actual = GameCore.isPlayerOut(speed);
                Assertions.assertFalse(actual, "Speed equal limit is allowed");
    }

    @Test
    public void negativeSpeedEqualMAXSPEEDWithRedLightPlayerMustRemain(){
        GameCore.isGreenLight = false;
        GameCore.MAX_SPEED = 10;
        int speed = -10;
        boolean actual = GameCore.isPlayerOut(speed);
        Assertions.assertFalse(actual,"Speed equal limit is allowed");

    }

    @Test
    public void SpeedOverMAXSPEEDWithRedLightPlayerMustRemain(){
        GameCore.isGreenLight = false;
        GameCore.MAX_SPEED = 10;
        int speed = 11;
        boolean actual = GameCore.isPlayerOut(speed);
        Assertions.assertTrue(actual, "Player must out, because speed over limit and GreenLight:" + GameCore.isGreenLight);

    }

    @Test
    public void negativeSpeedOverMAXSPEEDWithRedLightPlayerMustRemain(){
        GameCore.isGreenLight = false;
        GameCore.MAX_SPEED = 10;
        int speed = -11;
        boolean actual = GameCore.isPlayerOut(speed);
        Assertions.assertTrue(actual, "Player must out, because speed over limit and GreenLight:" + GameCore.isGreenLight);

    }

    @Test
    public void movingWithGreenLight(){
        GameCore.isGreenLight = true;
        GameCore.MAX_SPEED = 10;
        int speed = 666;
        boolean actual = GameCore.isPlayerOut(speed);
        Assertions.assertFalse(actual, "Player moving with green light continue game, with red light leave, now GreenLight:" + GameCore.isGreenLight);

    }

    @Test
    public void ultimateMovingPlayerTest(){
        GameCore.MAX_SPEED = 10;
        int speed = 10;
        boolean actual = GameCore.isPlayerOut(speed);
        boolean expected = !GameCore.isGreenLight;
        Assertions.assertEquals(actual, expected, "If light green player continue game, else - leave, now GreenLight: " + GameCore.isGreenLight);
    }

    @Test
    public void numberOfAllPlayersOut(){
        GameCore.isGreenLight = false;
        GameCore.MAX_SPEED = 10;
        int[] players = {11, 21, 31, 41, 51};

        int actual = GameCore.numberOfPlayerOut(players);
        int expected = players.length;
        Assertions.assertEquals(actual, expected, "All players must out, greenLight: "+ GameCore.isGreenLight);
    }

    @Test
    public void numberOfANonePlayersOutRedLight(){
        GameCore.isGreenLight = false;
        GameCore.MAX_SPEED = 10;
        int[] players = {0, 0, 0, 0, 0};

        int actual = GameCore.numberOfPlayerOut(players);
        int expected = 0;
        Assertions.assertEquals(actual, expected, "None players out, greenLight: "+ GameCore.isGreenLight);
    }

    @Test
    public void numberOfANonePlayersOutGreenLight(){
        GameCore.isGreenLight = true;
        GameCore.MAX_SPEED = 10;
        int[] players = {0, 0, 0, 0, 0};

        int actual = GameCore.numberOfPlayerOut(players);
        int expected = 0;
        Assertions.assertEquals(actual, expected, "None players out, greenLight: "+ GameCore.isGreenLight);
    }

    @Test
    public void rightNumberPlayersOutRedLight(){
        GameCore.isGreenLight = false;
        GameCore.MAX_SPEED = 10;
        int[] players = {11, 21, 0, 41, 0};

        int actual = GameCore.numberOfPlayerOut(players);
        int expected = 3;
        Assertions.assertEquals(actual, expected, "3 players must out, greenLight: "+ GameCore.isGreenLight);
    }

    @Test
    public void allPlayersOutRedLight(){
        GameCore.isGreenLight = false;
        GameCore.MAX_SPEED = 10;
        int[] players = {11, 21, 31, 41, 51};

        int[] actual = GameCore.playersOut(players);
        int[] expected = players;

        boolean result = Arrays.equals(actual, expected);
        Assertions.assertTrue(result, "Expected result is players array, greenLight: "+ GameCore.isGreenLight);
    }

    @Test
    public void nonePlayersOutGreenLight(){
        GameCore.isGreenLight = true;
        GameCore.MAX_SPEED = 10;
        int[] players = {1, 2, 0, 4, 0};

        int[] actual = GameCore.playersOut(players);
        int[] expected = {};

        boolean result = Arrays.equals(actual, expected);
        Assertions.assertTrue(result, "Expected result is empty array, greenLight: "+ GameCore.isGreenLight);
    }

    @Test
    public void nonePlayersOutRedLight(){
        GameCore.isGreenLight = false;
        GameCore.MAX_SPEED = 10;
        int[] players = {0, 0, 0, 0, 0};

        int[] actual = GameCore.playersOut(players);
        int[] expected = {};

        boolean result = Arrays.equals(actual, expected);
        Assertions.assertTrue(result, "Expected result is players array, greenLight: "+ GameCore.isGreenLight);
    }


    @Test
    public void rightPlayersOutRedLight(){
        GameCore.isGreenLight = false;
        GameCore.MAX_SPEED = 10;
        int[] players = {11, 21, 0, 41, 0};

        int[] actual = GameCore.playersOut(players);
        int[] expected = {11, 21, 41};

        boolean result = Arrays.equals(actual, expected);
        Assertions.assertTrue(result, "Expected result hard coded btw, greenLight: "+ GameCore.isGreenLight);
    }

    @Test
    public void rightPlayersRemainRedLight(){
        GameCore.isGreenLight = false;
        GameCore.MAX_SPEED = 10;
        int[] players = {11, 21, 0, 14, 0};

        int[] actual = GameCore.playersRemain(players);
        int[] expected = {0, 0};

        boolean result = Arrays.equals(actual, expected);
        Assertions.assertTrue(result, "Expected result hard coded btw, greenLight: "+ GameCore.isGreenLight);
    }

    @Test
    public void allPlayersRemainGreenLight(){
        GameCore.isGreenLight = true;
        GameCore.MAX_SPEED = 10;
        int[] players = {1, 2, 0, 4, 0};

        int[] actual = GameCore.playersRemain(players);
        int[] expected = players;

        boolean result = Arrays.equals(actual, expected);
        Assertions.assertTrue(result, "Expected result is players array, greenLight: "+ GameCore.isGreenLight);
    }

    @Test
    public void allPlayersRemainRedLight(){
        GameCore.isGreenLight = true;
        GameCore.MAX_SPEED = 10;
        int[] players = {0, 0, 0, 0, 0};

        int[] actual = GameCore.playersRemain(players);
        int[] expected = players;

        boolean result = Arrays.equals(actual, expected);
        Assertions.assertTrue(result, "Expected result is players array, greenLight: "+ GameCore.isGreenLight);
    }

    @Test
    public void nonePlayersRemainRedLight(){
        GameCore.isGreenLight = false;
        GameCore.MAX_SPEED = 10;
        int[] players = {11, 21, 31, 41, 51};

        int[] actual = GameCore.playersRemain(players);
        int[] expected = {};

        boolean result = Arrays.equals(actual, expected);
        Assertions.assertTrue(result, "Expected result is empty array, greenLight: "+ GameCore.isGreenLight);
    }

    @Test
    public void correctPlayersRemainNamesRedLight(){
        GameCore.isGreenLight = false;
        GameCore.MAX_SPEED = 10;
        String[] players = {
                "Pikachu 11",
                "Vanya -21",
                "Petya -10",
                "Pak-kin-cho 1",
                "Number 0",
        };

        String[] actual = GameCore.playersRemainNames(players);
        String[] expected = {
                "Petya",
                "Pak-kin-cho",
                "Number",
        };

        boolean result = Arrays.equals(actual, expected);
        Assertions.assertTrue(result, "Expected result hardcoded, greenLight: "+ GameCore.isGreenLight);
    }

    @Test
    public void nonePlayersRemainNamesRedLight(){
        GameCore.isGreenLight = false;
        GameCore.MAX_SPEED = 10;
        String[] players = {
                "Pikachu 11",
                "Vanya -21",
                "Petya -111",
                "Pak-kin-cho 111",
                "Number 110",
        };

        String[] actual = GameCore.playersRemainNames(players);
        String[] expected = {};

        Assertions.assertArrayEquals(expected, actual,
                "Expected empty array, actual: " + Arrays.toString(actual) + " , expected " + Arrays.toString(expected ));
    }

    @Test
    public void allPlayersRemainNamesRedLight(){
        GameCore.isGreenLight = false;
        GameCore.MAX_SPEED = 10;
        String[] players = {
                "Pikachu 1",
                "Vanya -2",
                "Petya -1",
                "Pak-kin-cho 6",
                "Number 0"
        };

        String[] actual = GameCore.playersRemainNames(players);
        String[] expected = {
                "Pikachu",
                "Vanya",
                "Petya",
                "Pak-kin-cho",
                "Number"
        };

        Assertions.assertArrayEquals(expected, actual,
                "Expected array of all names, actual: " + Arrays.toString(actual) + " , expected " + Arrays.toString(expected ));
    }

    @Test
    public void allPlayersRemainNamesGreenLight(){
        GameCore.isGreenLight = true;
        GameCore.MAX_SPEED = 10;
        String[] players = {
                "Pikachu 100",
                "Vanya -2",
                "Petya -100",
                "Pak-kin-cho 666",
                "Number 0"
        };

        String[] actual = GameCore.playersRemainNames(players);
        String[] expected = {
                "Pikachu",
                "Vanya",
                "Petya",
                "Pak-kin-cho",
                "Number"
        };

        Assertions.assertArrayEquals(expected, actual,
                "Expected array of all names, actual: " + Arrays.toString(actual) + " , expected " + Arrays.toString(expected ));
    }

}
