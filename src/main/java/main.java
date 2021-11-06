import ru.learnup.javaqa.qa_dz18_mvn.logic.GameCore;

import java.util.Arrays;

class Main {
    public static void main(String[] args) {

        String[] players = {
                "Pikachu 11",
                "Vanya -21",
                "Petya -10",
                "Pak-kin-cho 1",
                "Number 0",
        };

        // Допишите здесь логику так, что будет подсчитано и выведено
        // количество игроков, которые выбывают.
        // Если свет зелёный, то проходят все игроки (0 выбывают).
        // Если свет красный, то выбывает каждый, чья скорость не 0.


        System.out.println("Входные данные: " + Arrays.toString(players));
        System.out.println("Имена выживших игроков: " + Arrays.toString(GameCore.playersRemainNames(players)));
    }
}