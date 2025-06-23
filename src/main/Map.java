package main;

import java.util.Timer;
import java.util.TimerTask;

public class Map {
    public Map(int rows, int cols) {
        x = new int[rows];
        y = new int[cols];
    }
    public void start(){
        gameOver = false;
        gamePhaseTime = 30; // test 10 seconds of time
        sunCounter = new Counter(100);

        //each timer object creates a thread that will allow multithreading
        gamePhaseTimer = new Timer();
        sunGenerationTimer = new Timer();

        //execute until time is not a negative integer
         TimerTask gamePhaseTimerTask = new TimerTask() {
            @Override
            public void run() {
                //execute until time is not a negative integer
                if (gamePhaseTime > 0) {
                    System.out.println(gamePhaseTime-- + " seconds");
                } else {
                    System.out.println("Level is Over");
                    gameOver = true;
                    //terminate this timer and remove any currently scheduled tasks
                    gamePhaseTimer.cancel();
                    //mark the timer reference for garbage collection
                    gamePhaseTimer.purge();
                    gamePhaseTimer = null;
                }
            }
        };
        TimerTask sunGenerationTimerTask = new TimerTask() {

            @Override
            public void run() {
                if(!gameOver) {
                    System.out.println("Sun generated");
                    sunCounter.add(25);
                    System.out.println("Current Sun: " + sunCounter.getValue());
                }
                else {
                    System.out.println("end sun timer task");
                    sunGenerationTimer.cancel();
                    sunGenerationTimer.purge();
                    sunGenerationTimer = null;
                }
            }
        };

        gamePhaseTimer.scheduleAtFixedRate(gamePhaseTimerTask, 1000, 1000);
        sunGenerationTimer.scheduleAtFixedRate(sunGenerationTimerTask, 8000, 8000);
    }
    public void initializeColumns(int scale) {
        //scale represents number of actual x values in one column (16)
        int i;
        for (i = 0; i <x.length; i++) {
            x[i] = scale;
        }
    }

    public void initializeRows(int coordinates) {
        int i;
        for (i = 0; i <x.length; i++) {
            x[i] = coordinates;
            coordinates += 16;
        }
    }

    public int getGameTime() {
        return gamePhaseTime;
    }
    private int gamePhaseTime;
    private Timer gamePhaseTimer;


    private Timer sunGenerationTimer;

    private Timer zombieGenerationTimer;

    private boolean gameOver;
    private Counter sunCounter;
    private int[] x;
    private int[] y;
}
