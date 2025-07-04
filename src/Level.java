/*********************************************************************************************************
 This is to certify that this project is our own work, based on our personal efforts in studying and applying the concepts
 learned. We have constructed the functions and their respective algorithms and corresponding code by ourselves. The
 program was run, tested, and debugged by our own efforts. We further certify that we have not copied in part or whole or
 otherwise plagiarized the work of other students and/or persons.

 Jensel John L. Espada, DLSU ID# 12409383
 Joramm Fredrik A. Dela Torre DLSU ID#12409529
 *********************************************************************************************************/
import java.util.ArrayList;
import java.util.*;

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
        this.totalZombies = totalZombies;
        this.numWaves = numWaves;
        map =  new Map(5,11);
        map.populateGameTiles();
        availablePlants = new ArrayList<String>();
        availableZombies = new ArrayList<String>();
        sunCounter = new Counter(500); //starting sun in this level
        gamePhaseTime = 0;
        userTakingInput = false;
    }

    /** This method signals the start of the game. It initializes the game phase timer, sun production from the sky timer,
     zombie spawn timer. It initializes a Scanner and Random class. The timers are also scheduled at a fixed interval to run their
     respective timers. It also initializes the timer task that asks user in planting plants.
     */
    public void start(){
        kb = new Scanner(System.in);
        sc = new Scanner(System.in);
        Random randomRow = new Random();
        //each timer object creates a thread that will allow multithreading
        gamePhaseTimer = new Timer();
        sunGenerationTimer = new Timer();
        zombieGenerationTimer = new Timer();
        inputReaderTimer = new Timer();
        startTime = System.currentTimeMillis();

        //testing of plants
        //map.placePeashooter(map, 0,9, gamePhaseTime, sunCounter);
        //map.placePeashooter(map, 1,1, gamePhaseTime, sunCounter);
        //map.placePeashooter(map, 2,1, gamePhaseTime, sunCounter);
        //map.placePeashooter(map, 3,1, gamePhaseTime, sunCounter);
        //map.placePeashooter(map, 4,1, gamePhaseTime, sunCounter);

        //execute until time is not a negative integer
        TimerTask gamePhaseTimerTask = new TimerTask() {
            @Override
            public void run() {
                //execute until time desired time
                if (gamePhaseTime < 180 && !map.getGameOverStatus()) { //zombieGeneration Timer Task won't cancel until gamePhaseTime >= 180
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

        TimerTask inputReaderTimerTask = new TimerTask(){
            String userInput;
            String plantType = null;
            int row, col;
            @Override
            public void run() {
                if (!userTakingInput) {
                    if (!(map.getGameOverStatus())){
                        if (sunCounter.getValue() >= 50) {
                            System.out.println("You have enough sun to plant :)");
                            System.out.println("Would you like to plant? (y/n) ");
                            userTakingInput = true;
                            if (kb.next().equalsIgnoreCase("y")) {
                                System.out.println("Type..");
                                try {
                                    userInput = kb.next();
                                    for (String availablePlant : availablePlants) {
                                        if (availablePlant.equalsIgnoreCase(userInput)) {
                                            plantType = userInput;
                                            break;
                                        }
                                    }

                                    row = Integer.parseInt(kb.next());
                                    col = Integer.parseInt(kb.next());
                                }
                                catch(Exception e) {
                                    System.out.println("Wrong Format!");
                                    plantType = null;
                                    row = 0;
                                    col = 0;
                                }
                                if (row >= 0 &&
                                        row < map.getNumRows() &&
                                        col > 0 &&
                                        col < (map.getNumCols() - 1) &&
                                        plantType != null &&
                                        map.getGameTiles()[row][col].getPlant() == null) {

                                    if (plantType.equalsIgnoreCase("sf"))
                                        map.placeSunFlower(row, col, gamePhaseTime, sunCounter);
                                    else if (plantType.equalsIgnoreCase("ps"))
                                        map.placePeashooter(map, row, col, gamePhaseTime, sunCounter);
                                    else System.out.println("Not valid plant or position");
                                }
                            }
                            userTakingInput = false;
                        }
                    }
                    else {
                        kb.close();
                        inputReaderTimer.cancel();
                        inputReaderTimer.purge();
                        inputReaderTimer = null;
                    }
                }
                else {
                    if (map.getGameOverStatus()) {
                        kb.close();
                        inputReaderTimer.cancel();
                        inputReaderTimer.purge();
                        inputReaderTimer = null;
                    }
                    else  System.out.println("Another Task is asking for Input!");
                }
            }

        };
        TimerTask sunGenerationTimerTask = new TimerTask() {

            @Override
            public void run() {
                if (!userTakingInput) {
                    if(!map.getGameOverStatus()) {
                        userTakingInput = true;
                        System.out.println("Sky Generated a Sun at Time: " + (gamePhaseTime/60) + ":" + gamePhaseTime%60);
                        System.out.println("Would you like to collect the sun? (y/n)");
                        try {
                            if (sc.next().equalsIgnoreCase("y"))
                                sunCounter.add(25);
                        }
                        catch(Exception e) {
                            System.out.println("Wrong Format");
                        }
                        System.out.println("Current Sun: " + sunCounter.getValue());
                        userTakingInput = false;
                    }
                    else {
                        userTakingInput = false;
                        System.out.println("End Sun Timer Task");
                        sc.close();
                        sunGenerationTimer.cancel();
                        sunGenerationTimer.purge();
                        sunGenerationTimer = null;
                    }
                }
                else {
                    if (map.getGameOverStatus()) {
                        kb.close();
                        sunGenerationTimer.cancel();
                        sunGenerationTimer.purge();
                        sunGenerationTimer = null;
                    }
                    else System.out.println("Another Task is Asking for Input!");
                }
            }
        };

        TimerTask generateZombie = new TimerTask() {
            int i;
            @Override
            public void run() {
                if (gamePhaseTime >= 30 && gamePhaseTime <= 80 && !map.getGameOverStatus()) {
                    if (gamePhaseTime % 10 == 0) {
                        map.addNormalZombie(randomRow.nextInt(5), map);
                        System.out.println("Time Created: " + (gamePhaseTime/60) + ":" + gamePhaseTime%60);
                    }

                }
                else if (gamePhaseTime >= 81 && gamePhaseTime <= 140 && !map.getGameOverStatus()) {
                    if (gamePhaseTime % 5 == 0)
                        map.addNormalZombie(randomRow.nextInt(5), map);
                }
                else if (gamePhaseTime >= 141 && gamePhaseTime <= 170 && !map.getGameOverStatus()) {
                    if (gamePhaseTime % 3 == 0)
                        map.addNormalZombie(randomRow.nextInt(5), map);
                }
                else if (gamePhaseTime >= 171 && gamePhaseTime < 180 && !map.getGameOverStatus()) {
                    for (i = 1; i < 5 + ((levelNumber - 1) * 2); i++)
                        map.addNormalZombie(randomRow.nextInt(5), map);
                    map.addFlagZombie(randomRow.nextInt(5), map);

                }
                else if (map.getGameOverStatus()) {
                    System.out.println("Wave TImer Over");
                    zombieGenerationTimer.cancel();
                    zombieGenerationTimer.purge();
                    zombieGenerationTimer = null;
                }
            }
        };

        gamePhaseTimer.scheduleAtFixedRate(gamePhaseTimerTask, 1000, 1000);
        inputReaderTimer.scheduleAtFixedRate(inputReaderTimerTask, 11000, 11000);
        zombieGenerationTimer.scheduleAtFixedRate(generateZombie, 950, 1000);
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
    private long startTime;
    private boolean userTakingInput;
    private int gamePhaseTime;
    private Timer gamePhaseTimer;
    private Timer sunGenerationTimer;
    private Timer zombieGenerationTimer;
    private Timer inputReaderTimer;
    //start fucntion variables
    private Scanner sc;
    private Scanner kb;

    private int levelNumber;
    private int totalZombies;
    private int numWaves;
    private Map map;
    private ArrayList<String> availablePlants;
    private ArrayList<String> availableZombies;
    private Counter sunCounter;
}
