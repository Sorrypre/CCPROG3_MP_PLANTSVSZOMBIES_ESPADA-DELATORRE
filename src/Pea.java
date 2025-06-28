

import java.util.Timer;
import java.util.TimerTask;
/**
 * The class Pea represents the details of pea projectile from Peashooter.
 *
 * @author Jensel John L. Espada
 * @author Joramm Fredrik A. Dela Torre
 * @version 1.0
 */
public class Pea {
    /** This constructor initializes the map, the position of Peashooter, the current status, damage, direct damage, and range
     of Peashooter class.
     @param map number of rows in the game
     @param startingRow number of columns in the game
     @param startingCol num
     @param status the status of the Plant whether it is currently alive or not
     @param dmg the damage the Peashooter deals
     @param dd the multiplier to damage when Zombies are within certain range
     @param range the maximum travel distance of Pea object
     */
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

    /** This method moves the Pea object through the Map and Tiles of the game
     */
    public void move(Map map) {
        int rowPrevious = tileOccupied.getRow();//save previous x value of the tile that was occupied
        int colPrevious = tileOccupied.getCol();//save previous y value of the tile that was occupied
        colPosition += speed; //going to the right towards n-1
        if (colPosition >= tileOccupied.getScaledCol() + Tile.getTileScale() && colPosition != map.getNumCols()){
            tileOccupied = gameTiles[rowPrevious][colPrevious+1]; //If yes, update position of the tileOccupied
        }
    }

    /** This method checks if Pea object position is near within the position of the closest Zombie object@
     @param map the Map object where it contains the position of Zombie and Plant objects
     */
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

    /** This method gets the health of parameter zombie and inflict damage, reducing its health
    @param zombie the Zombie object that was hit by Pea object
     */
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

    /** This method sets the status to true indicating that the Pea object will be deleted
     */
    public void removePea() { status = true;}

    /** This method sets the speed of the Pea class, indicating how far it moves per call of move()
     @param speed how far it moves in a tile
     */
    public void setSpeed(int speed) { this.speed = speed; }

    /** This method returns the status of the Pea class
     @return true if the Pea is removed, false otherwise
     */
    public boolean isDead() {return status; }

    /** This method returns whether the Pea object hits a Zombie object
        @return true if Zombie has collided with Pea object, false otherwise
     */
    public boolean isHit() {
        return hit;
    }

    /** This method returns the speed of the Pea
     @return speed how fast it moves through a tile
     */
    public int getSpeed() {
        return speed;
    }

    private int rowPosition;
    private int colPosition;

    private Tile tileOccupied;
    private Tile[][] gameTiles;

    private Timer moveTimer;

    private int range;
    private int startingColumn;
    private int damage;
    private float directDamage;
    private boolean hit;
    private boolean status;
    private int speed;
}
