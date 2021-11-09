package ru.learnup.javaqa.qa_dz18_mvn.logic;

import static java.lang.Math.abs;

public class GameCore {
    public static boolean isGreenLight = false;
    public static int MAX_SPEED = 10;

    public static boolean isPlayerOut(int speed){
        return !isGreenLight && (abs(speed) > MAX_SPEED);
    }

    public static int numberOfPlayerOut(int[] playersSpeed){
        int counter =0;
        for (int speed: playersSpeed) {
            if (isPlayerOut(speed)){
                counter++;
            }
        }
        return counter;
    }

    public static int[] playersOut(int[] playersSpeed){
        int[] outers = new int[numberOfPlayerOut( playersSpeed)];
        int index = 0;
        for (int j : playersSpeed) {
            if (isPlayerOut(j)) {
                outers[index] = j;
                index++;
            }
        }
        return outers;
    }

    public static int[] playersRemain(int[] playersSpeed){
        int numberRemain =  playersSpeed.length - numberOfPlayerOut( playersSpeed);
        int[] remains = new int[numberRemain];
        int index = 0;
        for (int j : playersSpeed) {
            if (!isPlayerOut(j)) {
                remains[index] = j;
                index++;
            }
        }
        return remains;
    }
}
