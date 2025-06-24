package main;

import main.Sprites.Plants.*;

public class Tile {
    Tile(int x, int y, int scale){
        xCoordinate = x;
        yCoordinate = y;

        scaledXCoordinate = scale * x;
        scaledYCoordinate = scale * y;
        plantInTile = null;
    }
    public void setPlant(Plant plant) { plantInTile = plant; }
    public Plant getPlant() {return plantInTile; }
    public int getXCoordinate() {return this.xCoordinate; }
    public int getYCoordinate() { return this.yCoordinate; }
    public int getScaledXCoordinate() {return this.scaledXCoordinate;}
    public int getScaleYCoordinate() { return this.scaledYCoordinate; }

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
}
