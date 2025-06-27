package main;

import java.util.ArrayList;
import main.Sprites.Plants.*;
import main.Sprites.Zombie.*;

public class Tile {
    public Tile(int x, int y){
        row = x;
        col = y;

        scaledRowPosition = tileScale * x;
        scaledColPosition = tileScale * y;
        plantInTile = null;
    }
    public void setPlant(Plant plant) { plantInTile = plant; }
    public Plant getPlant() {return plantInTile; }
    public int getRow() {return this.row; }
    public int getCol() { return this.col; }
    public int getScaledRow() {return this.scaledRowPosition;}
    public int getScaledCol() { return this.scaledColPosition; }
    public static int getTileScale() { return tileScale; }

    public void addObject() {numOfObjects++;}
    public void removeObject() {
        if (numOfObjects > 0)
            numOfObjects--;
    }
    public int getNumOfObjects(){ return this.numOfObjects; }

    private final int row;
    private final int col;

    private final int scaledRowPosition;
    private final int scaledColPosition;
    private int numOfObjects;

    private Plant plantInTile;

    private static final int tileScale = 16;
}
