/*********************************************************************************************************
 This is to certify that this project is our own work, based on our personal efforts in studying and applying the concepts
 learned. We have constructed the functions and their respective algorithms and corresponding code by ourselves. The
 program was run, tested, and debugged by our own efforts. We further certify that we have not copied in part or whole or
 otherwise plagiarized the work of other students and/or persons.

 Jensel John L. Espada, DLSU ID# 12409383
 Joramm Fredrik A. Dela Torre DLSU ID#12409529
 *********************************************************************************************************/

import java.util.Timer;
import java.util.TimerTask;

/**
 * The class Zombie represents the details of a zombie in Plant vs Zombies
 *
 * @author Jensel John L. Espada
 * @author Joramm Fredrik A. Dela Torre
 * @version 1.0
 */

public class Zombie {
    /** This constructor initializes the Map object, row position and column position to the parameter. It initializes the default values
     for speed, damage, health, armour of the Zombie. It initializes the Timer Task in which the Zombie moves
     @param map the Map of the Level
     @param scaledColPosition the row position of the Zombie
     @param scaledRowPosition the column position of the Zombie
     */
    public Zombie(Map map, int scaledRowPosition, int scaledColPosition){
        NAME = "Normal Zombie";
        speed = 4;
        damage = 10;
        health = 70;
        rowPosition = scaledRowPosition;
        colPosition = scaledColPosition;
        zombieArmour = null;
        this.gameTiles = map.getGameTiles();
        tileOccupied = gameTiles[rowPosition / Tile.getTileScale()][colPosition / Tile.getTileScale()];

        initializeTimer(map);
    }

    //update zombie class to latest
    /** This constructor initializes the Map object, row position and column position to the parameter. It initializes the default values
     for speed, damage, health of the Zombie. It initializes the Timer Task in which the Zombie moves. It also initializes the
     name of the zombie and its armour.
     @param map the Map of the Level
     @param scaledColPosition the row position of the Zombie
     @param scaledRowPosition the column position of the Zombie
     */
    public Zombie(Map map, int scaledRowPosition, int scaledColPosition, String zombieName, Armour zombieArmour){
        //you can use getName from the armor class and the base the zombie name from there
        NAME = zombieName;
        speed = 4 + zombieArmour.getMovementBonus();
        damage = 10;
        health = 70 + zombieArmour.getToleranceBonus();
        this.zombieArmour = zombieArmour;

        rowPosition = scaledRowPosition;
        colPosition = scaledColPosition;
        equip(zombieArmour);
        this.gameTiles = map.getGameTiles();
        tileOccupied = gameTiles[rowPosition / Tile.getTileScale()][colPosition / Tile.getTileScale()];

        initializeTimer(map);
    }
    //Setters

    /** This method sets the movement speed of the zombie to the parameter
     @param s the movement speed of the zombies
     */
    public void setSpeed(int s){
        speed = s;
    }

    /** This method sets the damage of the zombie to the parameter
    @param d the damage of the zombies to plants
     */
    public void setDamage(int d){
        damage = d;
    }

    /** This method sets the health of the zombie to the parameter
     @param h the health of the zombie
     */
    public void setHealth(int h){
        health = h;
    }

    /** This method sets the row position of the zombie to the parameter
     @param row the row where the Zombie object is located
     */
    public void setRowPosition(int row) { rowPosition = row; }

    /** This method sets the column position of the zombie to the parameter
     @param col the column where the Zombie object is located
     */
    public void setColPosition(int col) { colPosition = col; }

    //Getters

    /** This method returns the name of the Zombie Class
    @return NAME the name of the zombie
     */
    public String getName() { return NAME; }

    /** This method returns the movement speed of the Zombie Class
     @return speed the speed of the zombie
     */
    public int getSpeed(){
        return speed;
    }

    /** This method returns the damage of the Zombie Class
     @return damage the damage of the zombie
     */
    public int getDamage(){
        return damage;
    }

    /** This method returns the health of the Zombie Class
     @return health the health of the zombie
     */
    public int getHealth(){
        return health;
    }

    /** This method returns current row position of the Zombie Class
     @return rowPosition the row position of the zombie
     */
    public int getRowPosition() { return rowPosition; }

    /** This method returns current column position of the Zombie Class
     @return colPosition the column position of the zombie
     */
    public int getColPosition() { return colPosition; }

    /** This method returns the armour of the Zombie Class
     @return zombieArmour the armour of the zombie
     */
    public Armour getArmour() { return zombieArmour; }

    /** This method sets the zombieArmour to the parameter
     @param zombieArmour the armour of the zombie
     */
    public void equip(Armour zombieArmour){
        this.zombieArmour = zombieArmour;
    }

    /** This method sets the zombieArmour to null
     */
    public void unequip() { this.zombieArmour = null; }

    /** This method returns the boolean whether zombie health reaches below 0
     @return true if zombie health is less than or equal to 0
     */
    public boolean isDead() { return health <= 0; }

    /** This method updates current column position by how much speed the zombie has. It checks whether
     the zombie has reached to new Tile
     */
    public void move(){
        int rowPrevious = tileOccupied.getRow();//save previous x value of the tile that was occupied
        int colPrevious = tileOccupied.getCol();//save previous y value of the tile that was occupied
        colPosition -= speed; //going to the left towards 0
        if (colPosition <= tileOccupied.getScaledCol() - Tile.getTileScale() && colPosition != 0){
            System.out.println("Current Zombie Location: (" + tileOccupied.getRow() + ", "+ tileOccupied.getCol() + ")");
            tileOccupied = gameTiles[rowPrevious][colPrevious-1]; //If yes, update position of the tileOccupied
        }
    }

    /** This method reduces the plant health by the damage of the zombie if zombie is in the same tile with a plant.
     */
    public void eatPlant(){
        int plantHP;
        plantHP = tileOccupied.getPlant().getHealth();
        if (tileOccupied.getPlant().getHealth() > 0){
            plantHP -= damage;
            tileOccupied.getPlant().setHealth(plantHP);
        }
    }

    /** This method reduces health of zombie by the parameter
     */
    public void receivedDamage(int damage) {
        if (health > 0) {
            health -= damage;
        }
    }

    /** This method initializes the timer task of the zombie movement and actions
     @param map the Map object of the Level
     */
    private void initializeTimer(Map map){
        moveTimer = new Timer();
        TimerTask moveEverySecond = new TimerTask(){

            @Override
            public void run() {
                if (tileOccupied.getCol() == 0 && !isDead()){
                    System.out.println("Zombies Win, game over");
                    map.setGameStatus(true);
                    System.out.println("Zombie reached House at gameTile ("+  tileOccupied.getRow() + ", "+ tileOccupied.getCol() + ")");
                    moveTimer.cancel();
                    moveTimer.purge();
                    moveTimer = null;
                }
                //code a function
                else if (isDead()) { //if zombies ran out of time or killed by plant
                    System.out.println("Zombie Died");
                    map.removeZombie();
                    moveTimer.cancel();
                    moveTimer.purge();
                    moveTimer = null;

                }
                else if (tileOccupied.getPlant() != null && !isDead()) {
                    System.out.println("Eat Plant");
                    eatPlant();
                    if(tileOccupied.getPlant().isDead())
                        map.removePlant(tileOccupied);
                }
                else if(!map.getGameOverStatus() && !isDead())
                    move();
            }
        };
        moveTimer.scheduleAtFixedRate(moveEverySecond, 1250, 1250);
    }

    private final String NAME;
    private int speed;
    private int damage;
    private int health;

    private int rowPosition;
    private int colPosition;
    private Tile tileOccupied;
    private Tile[][] gameTiles;

    private Armour zombieArmour;

    private Timer moveTimer;

    //add a sort of list of armour that can be equipped by a zombie
}
