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
    public void addZombie(int row, Map map){
        int scaledRowCoordinate, scaledColumnCoordinate;

        scaledRowCoordinate = row * Tile.getTileScale();
        scaledColumnCoordinate = 8 * Tile.getTileScale();

        Zombie zombie = new Zombie(map, scaledRowCoordinate, scaledColumnCoordinate);
        System.out.println("Created a zombie");
        zombiesOnLawn.add(zombie);
        gameTiles[row][8].addObject();
        //instantiate a normal zombie
        //set its coordinates in the last x value which is 9 value
        //import random and place it on a random lawn
        //add number of object in the tile
    }

    /** This method adds a Sunflower object to the ArrayList indicating that a Sunflower Plant exists on the lawn
     @param rows the number of rows in the map
     @param cols the number of columns in the map
     @param gamePhaseTime the current time indicating how long the game has been running
     @param sunCounter the accumulated value of sun
     */
    public void placeSunFlower(int rows, int cols, int gamePhaseTime, Counter sunCounter){
        int scaledRowCoordinate, scaledColumnCoordinate;
        Sunflower sunflower = new Sunflower("Sunflower", 50, sunCounter);
        System.out.println("Created a Sunflower at Time: " + (gamePhaseTime/60) + ":" + (gamePhaseTime%60));
        sunCounter.subtract(sunflower.getSunCost());
        //fix coordinate system labelling
        scaledRowCoordinate = rows * Tile.getTileScale();
        scaledColumnCoordinate = cols * Tile.getTileScale();

        sunflower.setXPosition(scaledRowCoordinate);
        sunflower.setYPosition(scaledColumnCoordinate);

        plantsOnLawn.add(sunflower); //adds to the arrayList
        gameTiles[rows][cols].addObject();
        gameTiles[rows][cols].setPlant(sunflower);
    }

    /** This method sets the status of the game phase to the parameter
     @param isGameOver will contain true if the game is over, otherwise false
     */
    public void setGameStatus(boolean isGameOver) { gameOver = isGameOver; }

    /** This method returns the current game phase status
     @return true if the game is over, otherwise false
     */
    public boolean getGameStatus() { return gameOver; }

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
