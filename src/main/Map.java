package main;

import java.util.*;

import main.Sprites.Zombie.*;
import main.Sprites.Plants.*;


public class Map {
    public Map(int rows, int cols) {
        numRows = rows;
        numColumns = cols;
        gameTiles = new Tile[rows][cols];
        zombiesOnLawn = new ArrayList<Zombie>();
        plantsOnLawn = new ArrayList<Plant>();
        kb = new Scanner(System.in);
    }
    public void start(){
        Map m = this;
        Random randomYCoordinate = new Random();
        gameOver = false;
        gamePhaseTime = 30; // test 10 seconds of time
        sunCounter = new Counter(100);
        m.addZombie(randomYCoordinate.nextInt(6), 16);
        System.out.println("Current Position of Zombie: (" + zombiesOnLawn.get(0).getXPosition() + ", " + zombiesOnLawn.get(0).getYPosition() + ") ");
        //refactor to make things a lot shorter like the scales and the coordinates just make it set getXPosition(int scale) so that it will be less cluttered
        tileOccupied = gameTiles[zombiesOnLawn.get(0).getYPosition() / 16][zombiesOnLawn.get(0).getXPosition() / 16];
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
                int x,y;
                if(!gameOver) {
                    System.out.println("Sun generated");
                    System.out.println("Would you like to collect the sun? (yes/no)");
                    choice = kb.nextLine();
                        if (choice.equalsIgnoreCase("yes"))
                            sunCounter.add(25);
                    System.out.println("Current Sun: " + sunCounter.getValue());
                    if(sunCounter.getValue() >= 50){
                        System.out.println("You have enough sun to place a sunflower");
                        System.out.println("Would you like to place? (yes/no)");
                        choice = kb.nextLine();
                        if (choice.equalsIgnoreCase("yes"))
                        {
                            System.out.print("Enter x: ");
                            xInput = kb.nextInt();
                            System.out.print("Enter y: ");
                            yInput = kb.nextInt();
                            m.placeSunFlower(xInput, yInput, 16, sunCounter);
                            //first plant placed
                            System.out.println("Current position of Plant: (" + plantsOnLawn.get(0).getXPosition() + ", " + plantsOnLawn.get(0).getYPosition() + ") ");
                            tileOccupied = gameTiles[plantsOnLawn.get(0).getYPosition() / 16][plantsOnLawn.get(0).getXPosition() / 16];
                            System.out.println("Number of objects in tile (" + tileOccupied.getXCoordinate() + "," + tileOccupied.getYCoordinate() + ") where zombie is " + tileOccupied.getNumOfObjects());
                            System.out.println("What plant is current on the tile: " + tileOccupied.getPlant().getName());

                        }
                    }
                }
                else {
                    System.out.println("End sun timer task");
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
    public void placeSunFlower(int x, int y, int scale, Counter sunCounter){
        int scaledXCoordinate, scaledYCoordinate;
        Sunflower sunflower = new Sunflower("Sunflower", 50, sunCounter);
        System.out.println("Created a sunflower");

        //fix coordinate system labelling
        scaledXCoordinate = y * scale;
        scaledYCoordinate = x * scale;

        sunflower.setXPosition(scaledXCoordinate);
        sunflower.setYPosition(scaledYCoordinate);

        plantsOnLawn.add(sunflower); //adds to the arrayList
        gameTiles[x][y].addObject();
        gameTiles[x][y].setPlant(sunflower);
    }

    public Counter getSunCounter() {
        return sunCounter;
    }

    private int gamePhaseTime;

    private Timer gamePhaseTimer;
    private Timer sunGenerationTimer;
    private Timer zombieGenerationTimer;

    private boolean gameOver;
    private Counter sunCounter;
    private int[] x;
    private int[] y;

    private int numRows;
    private int numColumns;
    private Tile[][] gameTiles;

    private ArrayList<Zombie> zombiesOnLawn;
    private ArrayList<Plant>  plantsOnLawn;

    private Scanner kb;
    private String choice;
    private int xInput;
    private int yInput;
    private Tile tileOccupied;
}
