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
        zombieCounter++;

        moveTimer = new Timer();

        tileOccupied = gameTiles[rowPosition / Tile.getTileScale()][colPosition / Tile.getTileScale()];
        System.out.println("Tile Occupied: " + rowPosition / Tile.getTileScale() + rowPosition / Tile.getTileScale());
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
                    if (map.getGameStatus()) {
                        map.removeZombie();
                        moveTimer.cancel();
                        moveTimer.purge();
                        moveTimer = null;
                    }
                }
                //not finished the plant, idk how to remove plant object from tile pls fix help
                else if (tileOccupied.getPlant() != null && !isDead()) {
                    System.out.println("Eat Plant");
                    eatPlant(); //code a function
                    if(tileOccupied.getPlant().isDead())
                        map.removePlant(tileOccupied);
                }
                else if(!map.getGameStatus() && !isDead())
                    move();
            }
        };
        moveTimer.scheduleAtFixedRate(moveEverySecond, 1500, 1500);
    }

    //update zombie class to latest
    public Zombie(String zombieName, Armour zombieArmour){
        //you can use getName from the armor class and the base the zombie name from there
        NAME = zombieName;
        speed = 4 + zombieArmour.getMovementBonus();
        damage = 10;
        health = 70 + zombieArmour.getToleranceBonus();
        this.zombieArmour = zombieArmour;
        zombieCounter++;


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

    public int getRowPosition() { return rowPosition; }

    public int getColPosition() { return colPosition; }

    public int getSpeed(){
        return speed;
    }

    public int getDamage(){
        return damage;
    }

    public int getHealth(){
        return health;
    }

    public void equip(Armour zombieArmour){
        this.zombieArmour = zombieArmour;
    }

    public boolean isDead() { return health <= 0; }

    public static void die(Zombie zombie){
        zombieCounter--;
        zombie = null;
        //destroy zombie object created
    }
    public void move(){
        int xPrevious = tileOccupied.getRow();//save previous x value of the tile that was occupied
        int yPrevious = tileOccupied.getCol();//save previous y value of the tile that was occupied
        colPosition -= speed; //going to the left towards 0
        if (colPosition <= tileOccupied.getScaledCol() - Tile.getTileScale()){
            System.out.println("Current Zombie Location: (" + tileOccupied.getRow() + ", "+ tileOccupied.getCol() + ")");
            tileOccupied = gameTiles[xPrevious][yPrevious-1]; //If yes, update position of the tileOccupied
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

    private final String NAME;
    private int speed;
    private int damage;
    private int health;

    private int rowPosition;
    private int colPosition;
    private Tile tileOccupied;
    private Tile[][] gameTiles;

    private Armour zombieArmour;

    private static int zombieCounter;

    private Timer moveTimer;

    //add a sort of list of armour that can be equipped by a zombie
}
