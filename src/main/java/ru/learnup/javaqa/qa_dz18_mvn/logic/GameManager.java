package ru.learnup.javaqa.qa_dz18_mvn.logic;

public class GameManager {
    private Game game;

    public GameManager(Game game){
        this.game = game;
    }

    public Game getGame(){
        return  this.game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int roundsSurvive(int[] speeds){
        int result = 0;
        for (int speed : speeds) {
            if (game.isPlayerOut(speed)) {
                return result;
            } else {
                result++;
            }
        }
        return result;
    }
}
