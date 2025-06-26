/*********************************************************************************************************
 This is to certify that this project is our own work, based on our personal efforts in studying and applying the concepts
 learned. We have constructed the functions and their respective algorithms and corresponding code by ourselves. The
 program was run, tested, and debugged by our own efforts. We further certify that we have not copied in part or whole or
 otherwise plagiarized the work of other students and/or persons.

 Jensel John L. Espada, DLSU ID# 12409383
 Joramm Fredrik A. Dela Torre DLSU ID#12409529
 *********************************************************************************************************/
package main;

import main.Sprites.Plants.*;

/**
 * The class Tile represents the details of the
 * dimensions and positions of a single tile in the game
 *
 * @author Jensel John L. Espada
 * @author Joramm Fredrik A. Dela Torre
 * @version 1.0
 */
public class Tile {
    /** This constructor initializes the row and column of a tile as well initializing
    the scaled row and columns to be used in transversing between tiles.
    It sets the tile to null meaning it does not contain a Plant object
        @param row the row of the tile
        @param col the column of the tile
     */
    public Tile(int x, int y){
        xCoordinate = x;
        yCoordinate = y;

        scaledXCoordinate = tileScale * x;
        scaledYCoordinate = tileScale * y;
        plantInTile = null;
    }

    /** This method sets a Plant object to the parameter
        @param plant the Plant object occupying the tile
     */
    public void setPlant(Plant plant) { plantInTile = plant; }

    /** This method returns the Plant object occupying the tile
        @return plantInTile the Plant object in the tile
     */
    public Plant getPlant() {return plantInTile; }

    /** This method returns the row which the tile is located
        @return row the row of the tile
     */
    public int getXCoordinate() {return this.xCoordinate; }

    /** This method returns the column which the tile is located
        @return row the column of the tile
     */
    public int getYCoordinate() { return this.yCoordinate; }

    /** This method returns the scaled row which the tile is located
        @return row the scaled dimension of the row
     */
    public int getScaledXCoordinate() {return this.scaledXCoordinate; }

    /** This method returns the scaled column which the tile is located
     @return col the scaled dimension of the column
     */
    public int getScaleYCoordinate() { return this.scaledYCoordinate; }

    /** This method returns the multiplier/scaler to the dimensions of a tile
        @return tileScale the multiplier to the dimension of the tile
     */
    public static int getTileScale() { return tileScale; }

    //DELETE METHODS
    public void addObject() {numOfObjects++;}
    public void removeObject() {
        if (numOfObjects > 0)
            numOfObjects--;
    }
    public int getNumOfObjects(){ return this.numOfObjects; }

    private final int xCoordinate;
    private final int yCoordinate;

    private final int scaledXCoordinate;
    private final int scaledYCoordinate;
    private int numOfObjects;

    private Plant plantInTile;

    private static final int tileScale = 16;
}
