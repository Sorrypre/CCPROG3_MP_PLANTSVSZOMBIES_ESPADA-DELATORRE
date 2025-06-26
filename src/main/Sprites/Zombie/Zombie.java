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
                if (tileOccupied.getYCoordinate() == 0 && !isDead()){
                    System.out.println("Zombies Win, game over");
                    map.setGameStatus(true);
                    System.out.println("Zombie reached House at gameTile ("+  tileOccupied.getXCoordinate() + ", "+ tileOccupied.getYCoordinate() + ")");
                    moveTimer.cancel();
                    moveTimer.purge();
                    moveTimer = null;
                }
                    //code a function
                else if (isDead()) { //if zombies ran out of time or killed by plant
                    if (map.getGameStatus()) {
                        moveTimer.cancel();
                        moveTimer.purge();
                        moveTimer = null;
                    }
                }
                //not finished the plant, idk how to remove plant object from tile pls fix help
                else if (tileOccupied.getPlant() != null && !isDead() && !tileOccupied.getPlant().isDead()) {
                    System.out.println("Eat Plant");
                    eatPlant(); //code a function
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

    public void setRowPosition(int x) { rowPosition = x; }

    public void setColPosition(int y) { colPosition = y; }

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
        int xPrevious = tileOccupied.getXCoordinate();//save previous x value of the tile that was occupied
        int yPrevious = tileOccupied.getYCoordinate();//save previous y value of the tile that was occupied
        colPosition -= speed; //going to the left towards 0
        if (colPosition <= tileOccupied.getScaleYCoordinate() - Tile.getTileScale()){
            System.out.println("Current Zombie Location: (" + tileOccupied.getXCoordinate() + ", "+ tileOccupied.getYCoordinate() + ")");
            tileOccupied = gameTiles[xPrevious][yPrevious-1]; //If yes, update position of the tileOccupied
        }
    }
    public void eatPlant(){
        int plant_hp;
        plant_hp = tileOccupied.getPlant().getHealth();
        if (plant_hp > 0)
            plant_hp -= damage;

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
