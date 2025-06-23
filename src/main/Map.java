package main;

import java.util.Timer;
import java.util.TimerTask;

public class Map {
    public Map() {
        x = new int[9];
        y = new int[5];
        gamePhaseTime = 60;
        gamePhaseTimer = new Timer();

        gamePhaseTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (gamePhaseTime > 0) {
                    System.out.println(gamePhaseTime-- + " seconds");
                }
                else {
                    System.out.println("Level is Over");
                    gamePhaseTimer.cancel();
                    gamePhaseTimer.purge();
                    gamePhaseTimer = null;
                }
            }
        }, 1000, 1000);
    }

    public void initializeColumns() {
        int coordinates = 0;
        int i;
        for (i = 0; i <x.length; i++) {
            x[i] = coordinates;
            coordinates += 16;
        }
    }

    public void initializeRows() {
        int coordinates = 0;
        int i;
        for (i = 0; i <x.length; i++) {
            x[i] = coordinates;
            coordinates += 16;
        }
    }

    public int getGameTime() {
        return gamePhaseTime;
    }

    private  int gamePhaseTime;
    private Timer gamePhaseTimer;
    private int[] x;
    private int[] y;
}
