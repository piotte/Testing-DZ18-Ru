package ru.learnup.javaqa.qa_dz18_mvn.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void getIsGreenLight(){
        Game game = new Game(false);

        boolean actual = game.getIsGreenLight();

        Assertions.assertFalse(actual, "Object was created with false");
    }

    @Test
    public void setIsGreenLight(){
        Game game = new Game(false);
        game.setIsGreenLight(true);

        boolean actual = game.getIsGreenLight();

        Assertions.assertTrue(actual, "Object was created with false and set to true");
    }



    @Test
    public void playerMoveMustOutRedLight(){
        Game game = new Game(false);
        int speed = 4000;

        boolean actual = game.isPlayerOut(speed);
        Assertions.assertTrue(actual, "Player must out");
    }

    @Test
    public void playerNotMoveRemainRedLight(){
        Game game = new Game(false);
        int speed = 0;

        boolean actual = game.isPlayerOut(speed);
        Assertions.assertFalse(actual, "Player must remain");
    }

    @Test
    public void playerMoveRemainGreenLight(){
        Game game = new Game(true);
        int speed = 4000;

        boolean actual = game.isPlayerOut(speed);
        Assertions.assertFalse(actual, "Player must remain");
    }


}
