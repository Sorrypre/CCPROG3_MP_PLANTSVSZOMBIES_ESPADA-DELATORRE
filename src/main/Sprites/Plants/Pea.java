package main.Sprites.Plants;

import java.util.Timer;
import java.util.TimerTask;

import main.Sprites.Zombie.Zombie;
import main.Tile;
import main.Map;

public class Pea {
    public Pea(Map map, int startingRow, int startingCol, boolean status, int dmg, float dd, int range) {
        speed = 8;
        damage = dmg;
        directDamage = dd;
        this.status = status;
        this.range = range;
        moveTimer = new Timer();
        gameTiles = map.getGameTiles();
        tileOccupied = gameTiles[startingRow/Tile.getTileScale()][startingCol/Tile.getTileScale()];
        rowPosition = startingRow;
        colPosition = startingCol;
        startingColumn = startingCol;
        hit = false;

        TimerTask peaMove =  new TimerTask() {
            @Override
            public void run() {
                if (!isHit()) {
                    checkCollision(map);//tile occupied is not containing any zombie and not reached last column (this is where collision will be checked for nearest zombie to peashooter)
                    move(map); // changing x value and then once it deals damage to the zombie it will disappear
                }
                else {
                    System.out.println("HIT!");
                    damageZombie(map.closestZombie(rowPosition, startingColumn));
                    removePea();
                    moveTimer.cancel();
                    moveTimer.purge();
                    moveTimer = null;
                }
            }
        };
        moveTimer.scheduleAtFixedRate(peaMove,250 ,250);
    }

    public void move(Map map) {
        int rowPrevious = tileOccupied.getRow();//save previous x value of the tile that was occupied
        int colPrevious = tileOccupied.getCol();//save previous y value of the tile that was occupied
        colPosition += speed; //going to the right towards n-1
        if (colPosition >= tileOccupied.getScaledCol() + Tile.getTileScale() && colPosition != map.getNumCols()){
            tileOccupied = gameTiles[rowPrevious][colPrevious+1]; //If yes, update position of the tileOccupied
        }
    }

    public void checkCollision(Map map) {
        if (map.closestZombie(rowPosition, startingColumn) != null &&
           colPosition >= map.closestZombie(rowPosition, startingColumn).getColPosition() - 4 &&
           colPosition <= map.closestZombie(rowPosition, startingColumn).getColPosition() + 4) {
            hit = true;
        }
        else if (colPosition >= 160)
            hit = true;
        else {
            hit = false;
        }
    }

    public void damageZombie(Zombie zombie){
        //If within 32 distance between peashooter and zombie
        //dmg is amplified by direct damage
        if (zombie != null) {
            if(startingColumn + 32 >= zombie.getColPosition()) {
                zombie.receivedDamage((int)(damage * directDamage));
            }
            else {
                zombie.receivedDamage(damage);
            }
        }
    }

    public void removePea() { status = true;}
    public void setSpeed(int speed) { this.speed = speed; }
    public boolean isDead() {return status; }

    public boolean isHit() {
        return hit;
    }

    private int rowPosition;
    private int colPosition;

    private Tile tileOccupied;
    private Tile[][] gameTiles;

    public int getSpeed() {
        return speed;
    }
    private Timer moveTimer;

    private int range;
    private int startingColumn;
    private int damage;
    private float directDamage;
    private boolean hit;
    private boolean status;
    private int speed;
}
