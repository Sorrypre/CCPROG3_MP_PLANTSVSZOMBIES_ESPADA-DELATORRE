package main.Sprites.Plants;

import java.util.Timer;
import java.util.TimerTask;

import main.Tile;
import main.Map;

public class Pea {
    public Pea(Map map, int startingRow, int startingCol, boolean status) {
        speed = 4;
        this.status = status;
        moveTimer = new Timer();
        gameTiles = map.getGameTiles();
        tileOccupied = gameTiles[startingRow/16][startingCol/16];

        TimerTask peaMove =  new TimerTask() {
            @Override
            public void run() {
                if (!isHit(map)) {//tile occupied is not containing any zombie and not reached last column (this is where collision will be checked for nearest zombie to peashooter)
                    //if there is no zombie, move until the last column
                    move(map); // changing xx value and then once it deals damage to the zombie it will disappear
                    //else if there is a zombie found
                    //apply zombie hit collision logic
                }
                else {
                    removePea();
                    moveTimer.cancel();
                    moveTimer.purge();
                    moveTimer = null;
                }
            }
        };
        moveTimer.scheduleAtFixedRate(peaMove, 500,500);
    }

    public void move(Map map) {

        int rowPrevious = tileOccupied.getRow();//save previous x value of the tile that was occupied
        int colPrevious = tileOccupied.getCol();//save previous y value of the tile that was occupied
        colPosition -= speed; //going to the right towards n-1
        if (colPosition >= tileOccupied.getScaledCol() + Tile.getTileScale() && colPosition != map.getNumCols()){
            System.out.println("Current Pea Location: (" + tileOccupied.getRow() + ", "+ tileOccupied.getCol() + ")");
            tileOccupied = gameTiles[rowPrevious][colPrevious-1]; //If yes, update position of the tileOccupied
        }
    }

    public boolean isHit(Map map) {
        if (colPosition >= map.closestZombie(rowPosition, colPosition).getColPosition() - 4 &&
           colPosition <= map.closestZombie(rowPosition, colPosition).getColPosition() + 4)
                return true;
        else if (colPosition >= 160)
            return true;
        return false;
    }
    public void removePea() { status = true;}
    public void setSpeed(int speed) { this.speed = speed; }
    public boolean isDead() {return status; }

    private int rowPosition;
    private int colPosition;

    private Tile tileOccupied;
    private Tile[][] gameTiles;

    public int getSpeed() {
        return speed;
    }
    private Timer moveTimer;

    private boolean status;
    private int speed;
}
