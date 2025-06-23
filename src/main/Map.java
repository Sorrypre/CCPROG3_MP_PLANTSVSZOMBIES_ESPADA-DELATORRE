package main;

import java.util.Timer;
import java.util.TimerTask;

public class Map {
    public Map(int rows, int cols) {
        numRows = rows;
        numColumns = cols;
        gameTiles = new Tile[rows][cols];
    }
    public void start(){
        gameOver = false;
        gamePhaseTime = 30; // test 10 seconds of time

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
        TimerTask sunGenerationTimerTask = new TimerTask(){

            @Override
            public void run() {
                if(!gameOver)
                    System.out.println("Sun generated");
                else {
                    System.out.println("end sun timer task");
                    sunGenerationTimer.cancel();
                    sunGenerationTimer.purge();
                    sunGenerationTimer = null;
                }
            }
        };

        gamePhaseTimer.scheduleAtFixedRate(gamePhaseTimerTask, 1000, 1000);
        sunGenerationTimer.scheduleAtFixedRate(sunGenerationTimerTask, 4000, 4000);
    }
//    public void initializeColumns(int scale) {
//        //scale represents number of actual x values in one column (16)
//        int i;
//        for (i = 0; i <x.length; i++) {
//            x[i] = scale;
//        }
//    }
//
//    public void initializeRows(int coordinates) {
//        int i;
//        for (i = 0; i <x.length; i++) {
//            x[i] = coordinates;
//            coordinates += 16;
//        }
//    }
    public void populateGameTiles(int scale) {
        int i,j;

        for (i = 0; i < numRows; i++)
            for(j = 0; j < numColumns; j++)
                gameTiles[i][j] = new Tile(i,j,scale);

    }
    public int getGameTime() {
        return gamePhaseTime;
    }

    public void addZombie(){
        //instantiate a normal zombie
        //set its coordinates in the last 9 value
        //import random and place it on a random lawn
    }

    private int gamePhaseTime;

    private Timer gamePhaseTimer;
    private Timer sunGenerationTimer;
    private Timer zombieGenerationTimer;

    private boolean gameOver;

    private int numRows;
    private int numColumns;
    private Tile[][] gameTiles;
}
