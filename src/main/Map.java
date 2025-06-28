/*********************************************************************************************************
 This is to certify that this project is our own work, based on our personal efforts in studying and applying the concepts
 learned. We have constructed the functions and their respective algorithms and corresponding code by ourselves. The
 program was run, tested, and debugged by our own efforts. We further certify that we have not copied in part or whole or
 otherwise plagiarized the work of other students and/or persons.

 Jensel John L. Espada, DLSU ID# 12409383
 Joramm Fredrik A. Dela Torre DLSU ID#12409529
 *********************************************************************************************************/
package main;

import java.util.*;

import main.Sprites.Zombie.*;
import main.Sprites.Plants.*;

/**
 * The class Map represents the details of the game map of PvZ
 *
 * @author Jensel John L. Espada
 * @author Joramm Fredrik A. Dela Torre
 * @version 1.0
 */
public class Map {
    /** This constructor initializes the rows and columns to the parameter. It initializes the dimensions of the 2D array of Tile class.
     It also initializes an ArrayList of Zombie and an ArrayList of Plant object. It also initializes the game over boolean to false.
     */
    public Map(int rows, int cols) {
        numRows = rows;
        numColumns = cols;
        gameTiles = new Tile[rows][cols];
        zombiesOnLawn = new ArrayList<Zombie>();
        plantsOnLawn = new ArrayList<Plant>();
        gameOver = false;
    }

    /** This method initializes the elements of the 2D array of Tile
     */
    public void populateGameTiles() {
        int i,j;

        for (i = 0; i < numRows; i++)
            for(j = 0; j < numColumns; j++)
                gameTiles[i][j] = new Tile(i,j);

    }

    /** This method adds a Zombie object to the ArrayList indicating that a zombie exists on the lawn
     @param row the row which the zombie will spawn
     @param map the map object which the zombie will be spawned
     */
    public void addNormalZombie(int row, Map map){
        int scaledRow, scaledCol;

        scaledRow = row * Tile.getTileScale();
        scaledCol = (numColumns-1) * Tile.getTileScale();

        Zombie zombie = new Zombie(map, scaledRow, scaledCol);
        System.out.println("Created a zombie at row " + row + " column " + scaledCol/Tile.getTileScale());
        zombiesOnLawn.add(zombie);
    }

    public void addFlagZombie(int row, Map map){
        int scaledRow, scaledCol;
        Armour flag = new Armour("Flag", 0, 2);

        scaledRow = row * Tile.getTileScale();
        scaledCol = (numColumns-1) * Tile.getTileScale();

        Zombie zombie = new Zombie(map, scaledRow, scaledCol, "Flag Zombie", flag);
        System.out.println("Created a zombie at row " + row + " column " + scaledCol/Tile.getTileScale());
        zombiesOnLawn.add(zombie);
    }

    /** This method adds a Sunflower object to the ArrayList indicating that a Sunflower Plant exists on the lawn
     @param row the row which the plant will be planted
     @param col the column which the plant will be planted
     @param gamePhaseTime the current time indicating how long the game has been running
     @param sunCounter the accumulated value of sun
     */
    public void placeSunFlower(int row, int col, int gamePhaseTime, Counter sunCounter){
        int scaledRow, scaledCol;
        Sunflower sunflower = new Sunflower("Sunflower", 50, sunCounter, 3000, 0, 50, 0, 0, 0);
        System.out.println("Created a Sunflower at Time: " + (gamePhaseTime/60) + ":" + (gamePhaseTime%60));
        sunCounter.subtract(sunflower.getSunCost());
        //fix coordinate system labelling
        scaledRow = row * Tile.getTileScale();
        scaledCol = col * Tile.getTileScale();

        sunflower.setRow(scaledRow);
        sunflower.setCol(scaledCol);

        plantsOnLawn.add(sunflower); //adds to the arrayList
        gameTiles[row][col].setPlant(sunflower);
    }

    public void placePeashooter(Map map, int row, int col, int gamePhaseTime, Counter sunCounter){
        int scaledRow, scaledCol;
        Peashooter peashooter = new Peashooter(map, "Peashooter", 100, 3000, 90, 20,  160, (float)1.25, 3000);
        System.out.println("Created a Peashooter at Time: " + (gamePhaseTime/60) + ":" + (gamePhaseTime%60));
        sunCounter.subtract(peashooter.getSunCost());
        //fix coordinate system labelling
        scaledRow = row * Tile.getTileScale();
        scaledCol = col * Tile.getTileScale();

        peashooter.setRow(scaledRow);
        peashooter.setCol(scaledCol);

        plantsOnLawn.add(peashooter); //adds to the arrayList
        gameTiles[row][col].setPlant(peashooter);
    }

    /** This method removes the Plant object from a Tile and from the list of Plant objects if the plant died in game
     @param occupiedTilePlant the tile where a plant is planted
     */
    public void removePlant(Tile occupiedTilePlant){
        Iterator<Plant> iterPlant = plantsOnLawn.iterator();
        Plant plant;
        occupiedTilePlant.setPlant(null);
        while (iterPlant.hasNext()){
            plant = iterPlant.next();
            if (plant.isDead())
                iterPlant.remove();
        }
    }

    /** This method removes the Zombie object from the
     list of Zombie objects on the map if the zombie died in game
     */
    public void removeZombie(){
        Iterator<Zombie> iterZombie = zombiesOnLawn.iterator();
        Zombie zombie;
        while(iterZombie.hasNext()){
            zombie = iterZombie.next();
            if(zombie.isDead())
                iterZombie.remove();
        }
    }

    public Zombie closestZombie (int rowPosition, int colPosition) {
        Zombie min = null;

        for (Zombie zombie: zombiesOnLawn) {
            if ( zombie.getRowPosition() == rowPosition && //checks if the zombie is in the same row as the parameter
                zombie.getColPosition() >= colPosition &&  //checks if zombie has not yet passed the parameter
                min == null) { //to instantiate the first instance of viable zombie
                min = zombie;
            }
            else if ( zombie.getRowPosition() == rowPosition &&
                    zombie.getColPosition() >= colPosition &&
                    min != null) {
                if (min.getColPosition() > zombie.getColPosition()) {
                    min = zombie;
                }
            }
        }
        return min;
    }

    public boolean zombieOnRow (int rowPosition) {
        for (Zombie zombie: zombiesOnLawn) {
            if (zombie.getRowPosition() == rowPosition)
                return true;
        }
        return false;
    }

    /** This method sets the status of the game phase to the parameter
     @param isGameOver will contain true if the game is over, otherwise false
     */
    public void setGameStatus(boolean isGameOver) { gameOver = isGameOver; }

    /** This method returns the current game phase status
     @return true if the game is over, otherwise false
     */
    public boolean getGameOverStatus() { return gameOver; }

    /** This method returns the 2D array of TIle
     @return gameTiles an array of containing the tiles of the map
     */
    public Tile[][] getGameTiles() { return gameTiles; }

    /** This method returns the number of rows in the map
     @return numRows number of rows in the map
     */
    public int getNumRows() { return numRows; }

    /** This method returns the number of columns in the map
     @return numColumns number of columns in the map
     */
    public int getNumCols() { return numColumns; }

    /** This method returns the list of zombies spawned in the map
     @return zombiesOnLaw a list containing Zombie objects
     */
    public ArrayList<Zombie> getZombiesOnLawn() { return zombiesOnLawn; }

    /** This method returns the list of plants planted in the map
     @return plantsOnLawn a list containing Plant objects
     */
    public ArrayList<Plant> getPlantsOnLawn() { return plantsOnLawn; }

    //Variables
    private boolean gameOver;

    private int numRows;
    private int numColumns;
    private Tile[][] gameTiles;

    private ArrayList<Zombie> zombiesOnLawn;
    private ArrayList<Plant>  plantsOnLawn;
}
