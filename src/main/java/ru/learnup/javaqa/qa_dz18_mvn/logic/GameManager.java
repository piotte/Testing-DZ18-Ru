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

    public int loser(Movable p1, Movable p2, Game game, int rounds){
        //Unclear but p1 making first move each round
        for (int i = 0; i < rounds; i++) {
            if (game.isPlayerOut(p1.getSpeed())) {
                return -1;
            }
            if (game.isPlayerOut(p2.getSpeed())) {
                return 1;
            }
        }
        return 0;
    }
}
