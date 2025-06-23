package main;

public class Tile {
    Tile(int x, int y){
        xCoordinate = x;
        yCoordinate = y;
    }
    public int getXCoord() {return this.xCoordinate; }
    public int getYCoord() { return this.yCoordinate; }
    public void addObject() {numOfObjects++;}
    public void removeObject() {
        if (numOfObjects > 0)
            numOfObjects--;
    }
    public int getNumOfObjects(){ return this.numOfObjects; }

    private int xCoordinate;
    private int yCoordinate;
    private int numOfObjects;
}
