import ru.learnup.javaqa.qa_dz18_mvn.logic.GameCore;

import java.util.Arrays;

class Main {
    public static void main(String[] args) {

        int[] playersSpeed = { 5, 0, 2 };

        // Допишите здесь логику так, что будет подсчитано и выведено
        // количество игроков, которые выбывают.
        // Если свет зелёный, то проходят все игроки (0 выбывают).
        // Если свет красный, то выбывает каждый, чья скорость не 0.


        System.out.println("Количество выбывших игроков: " + GameCore.numberOfPlayerOut(playersSpeed));
        System.out.println("Выбыли игроки со скоростями: " + Arrays.toString(GameCore.playersOut(playersSpeed)));
        System.out.println("Остались игроки со скоростями: " + Arrays.toString(GameCore.playersRemain(playersSpeed)));
    }
}