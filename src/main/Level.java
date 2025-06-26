package main;
import java.util.ArrayList;
import java.util.*;

import main.Sprites.Plants.*; //for each
import main.Sprites.Zombie.Zombie;

public class Level {
    Level(int levelNumber, int totalZombies, int numWaves) {
        this.levelNumber = levelNumber;
        this.totalZombies = totalZombies;
        this.numWaves = numWaves;
        map =  new Map(5,9);
        map.populateGameTiles();
        availablePlants = new ArrayList<String>();
        availableZombies = new ArrayList<String>();
        sunCounter = new Counter(100); //starting sun in this level
        gamePhaseTime = 0;
    }
    public void start(){
        kb = new Scanner(System.in);
        Random randomRow = new Random();
        //each timer object creates a thread that will allow multithreading
        gamePhaseTimer = new Timer();
        sunGenerationTimer = new Timer();
        map.addZombie(randomRow.nextInt(5), map); //5 rows only
        System.out.println("Current Position of Zombie: (" + map.getZombiesOnLawn().get(0).getRowPosition() + ", " + map.getZombiesOnLawn().get(0).getColPosition() + ") ");
        //refactor to make things a lot shorter like the scales and the coordinates just make it set getXPosition(int scale) so that it will be less cluttered
        Tile tileOccupied = map.getGameTiles()[map.getZombiesOnLawn().get(0).getRowPosition() / 16][map.getZombiesOnLawn().get(0).getColPosition() / 16];
        System.out.println("Number of objects in tile (" + tileOccupied.getXCoordinate() + "," + tileOccupied.getYCoordinate() + ") where zombie is " + tileOccupied.getNumOfObjects());
        //test place plant
        map.placeSunFlower(0,0, gamePhaseTime, sunCounter);


        //execute until time is not a negative integer
        TimerTask gamePhaseTimerTask = new TimerTask() {
            @Override
            public void run() {
                //execute until time desired time
                if (gamePhaseTime < 30) {
                    gamePhaseTime++;
                }
                else {
                    System.out.println("Level is Over");
                    map.setGameStatus(true);
                    kb.close();
                    //terminate this timer and remove any currently scheduled tasks
                    gamePhaseTimer.cancel();
                    //mark the timer reference for garbage collection
                    gamePhaseTimer.purge();
                    gamePhaseTimer = null;
                    for (Plant i: map.getPlantsOnLawn())
                        i.setHealth(0);
                    for (Zombie i: map.getZombiesOnLawn())
                        i.setHealth(0);
                }
            }
        };
        TimerTask sunGenerationTimerTask = new TimerTask() {

            @Override
            public void run() {
                if(!map.getGameStatus()) {
                    System.out.println("Sky Generated a Sun at Time: " + (gamePhaseTime/60) + ":" + gamePhaseTime%60);
                    System.out.println("Would you like to collect the sun? (y/n)");
                    if (kb.next().equalsIgnoreCase("y"))
                        sunCounter.add(25);
                    System.out.println("Current Sun: " + sunCounter.getValue());
//                    if(sunCounter.getValue() >= 50){
//                        System.out.println("You have enough sun to place a sunflower");
//                        System.out.println("Would you like to place? (yes/no)");
//                        choice = kb.nextLine();
//                        if (choice.equalsIgnoreCase("yes"))
//                        {
//                            System.out.print("Enter x: ");
//                            xInput = kb.nextInt();
//                            System.out.print("Enter y: ");
//                            yInput = kb.nextInt();
//                            m.placeSunFlower(xInput, yInput, 16, sunCounter);
//                            //first plant placed
//                            System.out.println("Current position of Plant: (" + plantsOnLawn.get(0).getXPosition() + ", " + plantsOnLawn.get(0).getYPosition() + ") ");
//                            tileOccupied = gameTiles[plantsOnLawn.get(0).getYPosition() / 16][plantsOnLawn.get(0).getXPosition() / 16];
//                            System.out.println("Number of objects in tile (" + tileOccupied.getXCoordinate() + "," + tileOccupied.getYCoordinate() + ") where zombie is " + tileOccupied.getNumOfObjects());
//                            System.out.println("What plant is current on the tile: " + tileOccupied.getPlant().getName());
//
//                       }
//                    }
                }
                else {
                    System.out.println("End Sun Timer Task");
                    kb.close();
                    sunGenerationTimer.cancel();
                    sunGenerationTimer.purge();
                    sunGenerationTimer = null;
                }
            }
        };

        gamePhaseTimer.scheduleAtFixedRate(gamePhaseTimerTask, 1000, 1000);
        sunGenerationTimer.scheduleAtFixedRate(sunGenerationTimerTask, 8000, 8000);
    }
    public int getLevelNum(){ return this.levelNumber; }
    public int getTotalZombies(){ return this.totalZombies; }
    public int getNumWaves() {return this.numWaves; }
    public Map getMap() { return this.map; }
    public ArrayList<String> getAvailablePlants(){ return this.availablePlants; }
    public ArrayList<String> getAvailableZombies() { return this.availableZombies; }

    //start function variables
    private int gamePhaseTime;
    private Timer gamePhaseTimer;
    private Timer sunGenerationTimer;
    private Timer zombieGenerationTimer;
    //start fucntion variables
    private Scanner kb;
    private int xInput;
    private int yInput;

    private int levelNumber;
    private int totalZombies;
    private int numWaves;
    private Map map;
    private ArrayList<String> availablePlants;
    private ArrayList<String> availableZombies;
    private Counter sunCounter;


}
