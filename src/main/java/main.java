import ru.learnup.javaqa.qa_dz18_mvn.logic.*;

import java.util.Arrays;

class Main {
    public static void main(String[] args) {

        SpeedyGame speedyGame = new SpeedyGame(false, 10);
        GameManager gameManager = new GameManager(speedyGame);
        ConstantPlayer Ali = new ConstantPlayer(9);
        FastPlayer SunMoonDon = new FastPlayer(1, 2);

        if (gameManager.loser(Ali, SunMoonDon, speedyGame, 5) == 0) {
            System.out.println("Good new everyone alive");
        } else {
            System.out.println("Good new prize increased");
        }
    }
}