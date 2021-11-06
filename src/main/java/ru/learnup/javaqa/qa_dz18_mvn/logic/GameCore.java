package ru.learnup.javaqa.qa_dz18_mvn.logic;

import static java.lang.Math.abs;

public class GameCore {
    public boolean isGreenLight = false;
    public int MAX_SPEED = 10;

    public GameCore(boolean isGreenLight, int MAX_SPEED){
        this.isGreenLight = isGreenLight;
        this.MAX_SPEED = MAX_SPEED;
    }

    public boolean isPlayerOut(int speed){
        return !this.isGreenLight && (abs(speed) > this.MAX_SPEED);
    }

    public int numberOfPlayerOut(int[] playersSpeed){
        int counter =0;
        for (int speed: playersSpeed) {
            if (this.isPlayerOut(speed)){
                counter++;
            }
        }
        return counter;
    }

    public int[] playersOut(int[] playersSpeed){
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

    public int[] playersRemain(int[] playersSpeed){
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


    /*
    public static String[] playersRemainNames(String[] players){
        String stringOfNames = "";
        for (String player : players){
            String[] tempo = player.split(" ");
            int speed = Integer.parseInt(tempo[1]);
            if (!isPlayerOut(speed)) {
                stringOfNames  += tempo[0] + " ";
            }
        }
        if(stringOfNames == ""){
            String[] nullRes = {};
            return nullRes;
        }
        else
        {
            return stringOfNames.split(" ");
        }
    }
    */

    public String[] playersRemainNames(String[] players){
        int[] speeds = new int[players.length];
        for (int i = 0; i < players.length; i++){
            String[] tempo = players[i].split(" ");
            speeds[i] = Integer.parseInt(tempo[1]);
        }
        int numberOfSurvivers = players.length - numberOfPlayerOut(speeds);
        String[] result = new String[numberOfSurvivers];

        int pos = 0;
        for (String player : players){
            String[] tempo = player.split(" ");
            int speed = Integer.parseInt(tempo[1]);
            if (!isPlayerOut(speed)) {
                result[pos] = tempo[0];
                pos++;
            }
        }

        return result;
    }
}
