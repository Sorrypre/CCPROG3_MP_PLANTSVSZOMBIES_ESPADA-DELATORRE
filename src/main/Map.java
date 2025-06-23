package main;

import java.util.Timer;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.Random;
import main.Sprites.Zombie.*;


public class Map {
    public Map(int rows, int cols) {
        numRows = rows;
        numColumns = cols;
        gameTiles = new Tile[rows][cols];
        zombiesOnLawn = new ArrayList<Zombie>();
    }
    public void start(){
        Map m = this;
        Random randomYCoordinate = new Random();
        gameOver = false;
        gamePhaseTime = 30; // test 10 seconds of time
        //sunCounter = new Counter(100);
        m.addZombie(randomYCoordinate.nextInt(6), 16);
        System.out.println("Current Position of Zombie: (" + zombiesOnLawn.get(0).getXPosition() + ", " + zombiesOnLawn.get(0).getYPosition() + ") ");
        //refactor to make things a lot shorter like the scales and the coordinates just make it set getXPosition(int scale) so that it will be less cluttered
        Tile tileOccupied = gameTiles[zombiesOnLawn.get(0).getYPosition() / 16][zombiesOnLawn.get(0).getXPosition() / 16];
        System.out.println("Number of objects in tile (" + tileOccupied.getXCoordinate() + "," + tileOccupied.getYCoordinate() + ") where zombie is " + tileOccupied.getNumOfObjects());

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
                    //sunCounter.add(25);
                    //System.out.println("Current Sun: " + sunCounter.getValue());
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

    public void addZombie(int x, int scale){
        int scaledXCoordinate, scaledYCoordinate;
        Zombie zombie = new Zombie();
        System.out.println("Created a zombie");

        scaledXCoordinate = 8 * scale;

        scaledYCoordinate = x * scale;

        zombie.setXPosition(scaledXCoordinate);
        zombie.setYPosition(scaledYCoordinate);

        zombiesOnLawn.add(zombie);
        gameTiles[x][8].addObject();
        //instantiate a normal zombie
        //set its coordinates in the last x value which is 9 value
        //import random and place it on a random lawn
        //add number of

    }

    private int gamePhaseTime;

    private Timer gamePhaseTimer;
    private Timer sunGenerationTimer;
    private Timer zombieGenerationTimer;

    private boolean gameOver;
    //private Counter sunCounter;
    private int[] x;
    private int[] y;

    private int numRows;
    private int numColumns;
    private Tile[][] gameTiles;

    private ArrayList<Zombie> zombiesOnLawn;
}
