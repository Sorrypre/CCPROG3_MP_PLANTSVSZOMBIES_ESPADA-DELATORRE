/*********************************************************************************************************
 This is to certify that this project is our own work, based on our personal efforts in studying and applying the concepts
 learned. We have constructed the functions and their respective algorithms and corresponding code by ourselves. The
 program was run, tested, and debugged by our own efforts. We further certify that we have not copied in part or whole or
 otherwise plagiarized the work of other students and/or persons.

 Jensel John L. Espada, DLSU ID# 12409383
 Joramm Fredrik A. Dela Torre DLSU ID#12409529
 *********************************************************************************************************/
import java.util.ArrayList;
import main.Sprites.Plants.*;
import main.Sprites.Zombie.*;

/**
 * The class Tile represents the details of a plant tile in Plant vs Zombies
 *
 * @author Jensel John L. Espada
 * @author Joramm Fredrik A. Dela Torre
 * @version 1.0
 */
public class Tile {
    /** This constructor initializes the row and column to the given parameter. It also computes for the scaled dimensions
     of the tile using the constant tileScale
     @param row the row of the Tile
     @param col the column of the Tile
     */
    public Tile(int row, int col){
        this.row = row;
        this.col = col;

        scaledRowPosition = tileScale * row;
        scaledColPosition = tileScale * col;
        plantInTile = null;
    }

    /** This method sets the Plant parameter to the Tile, setting it to be occupied
     @param plant the Plant object placed inside the Tile
     */
    public void setPlant(Plant plant) { plantInTile = plant; }

    /** This method returns the Plant object placed in the Tile
     @return plantInTile the Plant object occupying the Tile
     */
    public Plant getPlant() {return plantInTile; }

    /** This method returns the row of the Tile
    @return row the row of the Tile
     */
    public int getRow() {return row; }

    /** This method returns the column of the Tile
     @return col the column of the Tile
     */
    public int getCol() { return col; }

    /** This method returns the scaled row of the Tile
     @return row the scaled row of the Tile
     */
    public int getScaledRow() {return scaledRowPosition;}

    /** This method returns the scaled column of the Tile
     @return col the scaled column of the Tile
     */
    public int getScaledCol() { return scaledColPosition; }

    /** This method returns the scale multiplier in which the row and column was scaled to
    @return tileScale multiplier to the dimensions of the Tile
     */
    public static int getTileScale() { return tileScale; }

    private final int row;
    private final int col;

    private final int scaledRowPosition;
    private final int scaledColPosition;

    private Plant plantInTile;

    private static final int tileScale = 16;
}
