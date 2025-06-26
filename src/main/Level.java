/*********************************************************************************************************
 This is to certify that this project is our own work, based on our personal efforts in studying and applying the concepts
 learned. We have constructed the functions and their respective algorithms and corresponding code by ourselves. The
 program was run, tested, and debugged by our own efforts. We further certify that we have not copied in part or whole or
 otherwise plagiarized the work of other students and/or persons.

 Jensel John L. Espada, DLSU ID# 12409383
 Joramm Fredrik A. Dela Torre DLSU ID#12409529
 *********************************************************************************************************/
package main;
import java.util.ArrayList;
import java.util.*;

import main.Sprites.Plants.*; //for each
import main.Sprites.Zombie.Zombie;

/**
 * The class Level represents the details of what a level will contain in a PvZ Gameplay
 *
 * @author Jensel John L. Espada
 * @author Joramm Fredrik A. Dela Torre
 * @version 1.0
 */
public class Level {
    /** This constructor initializes the level to the parameter. It also initializes the Map object and the list of tiles inside the map.
     It also initializes what zombies and plants are able to be spawn and plant, respectively. It initializes the starting sun to a certain
     value and sets the game timer to 0.
    @param levelNumber the level of the player in PvZ
     */
    Level(int levelNumber) {
        this.levelNumber = levelNumber;
        map =  new Map(5,9);
        map.populateGameTiles();
        availablePlants = new ArrayList<String>();
        availableZombies = new ArrayList<String>();
        sunCounter = new Counter(100); //starting sun in this level
        gamePhaseTime = 0;
    }

    /** This method signals the start of the game. It initializes the game phase timer, sun production from the sky timer,
     zombie spawn timer. It initializes a Scanner and Random class. The timers are also scheduled at a fixed interval to run their
     respective timers.
     */
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
        map.placeSunFlower(3,7, gamePhaseTime, sunCounter);


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
                    if(kb.hasNext())
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

    /** This method returns the level of the game
     @return levelNumber integer value of the current level in the game
     */
    public int getLevelNum(){ return this.levelNumber; }

    /** This method returns the map of the game
     @return map the Map object of the level
     */
    public Map getMap() { return this.map; }

    /** This method returns the list of plants available to be planted in the map
     @return availablePlants a list containing the names of available plants
     */
    public ArrayList<String> getAvailablePlants(){ return this.availablePlants; }

    /** This method returns the list of zombies available to be spawned in the map
     @return availableZombies a list containing names of the available zombies
     */
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
