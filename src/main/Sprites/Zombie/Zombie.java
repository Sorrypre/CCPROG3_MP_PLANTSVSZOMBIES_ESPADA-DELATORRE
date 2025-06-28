/*********************************************************************************************************
 This is to certify that this project is our own work, based on our personal efforts in studying and applying the concepts
 learned. We have constructed the functions and their respective algorithms and corresponding code by ourselves. The
 program was run, tested, and debugged by our own efforts. We further certify that we have not copied in part or whole or
 otherwise plagiarized the work of other students and/or persons.

 Jensel John L. Espada, DLSU ID# 12409383
 Joramm Fredrik A. Dela Torre DLSU ID#12409529
 *********************************************************************************************************/
package main.Sprites.Zombie;

import java.util.Timer;
import java.util.TimerTask;
import main.Tile;
import main.Map;
public class Zombie {
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

    public void setSpeed(int s){
        speed = s;
    }

    public void setDamage(int d){
        damage = d;
    }

    public void setHealth(int h){
        health = h;
    }

    public void setRowPosition(int row) { rowPosition = row; }

    public void setColPosition(int col) { colPosition = col; }

    //Getters
    public String getName() { return NAME; }

    public int getSpeed(){
        return speed;
    }

    public int getDamage(){
        return damage;
    }

    public int getHealth(){
        return health;
    }

    public int getRowPosition() { return rowPosition; }

    public int getColPosition() { return colPosition; }

    public Armour getArmour() { return zombieArmour; }

    public void equip(Armour zombieArmour){
        this.zombieArmour = zombieArmour;
    }

    public void unequip() { this.zombieArmour = null; }

    public boolean isDead() { return health <= 0; }

    public void move(){
        int rowPrevious = tileOccupied.getRow();//save previous x value of the tile that was occupied
        int colPrevious = tileOccupied.getCol();//save previous y value of the tile that was occupied
        colPosition -= speed; //going to the left towards 0
        if (colPosition <= tileOccupied.getScaledCol() - Tile.getTileScale() && colPosition != 0){
            System.out.println("Current Zombie Location: (" + tileOccupied.getRow() + ", "+ tileOccupied.getCol() + ")");
            tileOccupied = gameTiles[rowPrevious][colPrevious-1]; //If yes, update position of the tileOccupied
        }
    }
    public void eatPlant(){
        int plantHP;
        plantHP = tileOccupied.getPlant().getHealth();
        if (tileOccupied.getPlant().getHealth() > 0){
            plantHP -= damage;
            tileOccupied.getPlant().setHealth(plantHP);
        }
    }

    public void receivedDamage(int damage) {
        if (health > 0) {
            health -= damage;
        }
    }

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
                    eatPlant(); //code a function
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
