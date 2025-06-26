package main;

import java.util.*;

import main.Sprites.Zombie.*;
import main.Sprites.Plants.*;


public class Map {
    public Map(int rows, int cols) {
        numRows = rows;
        numColumns = cols;
        gameTiles = new Tile[rows][cols];
        zombiesOnLawn = new ArrayList<Zombie>();
        plantsOnLawn = new ArrayList<Plant>();
        gameOver = false;
    }

    public void populateGameTiles() {
        int i,j;

        for (i = 0; i < numRows; i++)
            for(j = 0; j < numColumns; j++)
                gameTiles[i][j] = new Tile(i,j);

    }

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
    public void placeSunFlower(int x, int y, int gamePhaseTime, Counter sunCounter){
        int scaledXCoordinate, scaledYCoordinate;
        Sunflower sunflower = new Sunflower("Sunflower", 50, sunCounter);
        System.out.println("Created a Sunflower at Time: " + (gamePhaseTime/60) + ":" + (gamePhaseTime%60));
        sunCounter.subtract(sunflower.getSunCost());
        //fix coordinate system labelling
        scaledXCoordinate = y * Tile.getTileScale();
        scaledYCoordinate = x * Tile.getTileScale();

        sunflower.setXPosition(scaledXCoordinate);
        sunflower.setYPosition(scaledYCoordinate);

        plantsOnLawn.add(sunflower); //adds to the arrayList
        gameTiles[x][y].addObject();
        gameTiles[x][y].setPlant(sunflower);
    }

    public void setGameStatus(boolean isGameOver) { gameOver = isGameOver; }

    public boolean getGameStatus() { return gameOver; }
    public Tile[][] getGameTiles() { return gameTiles; }
    public int getNumRows() { return numRows; }
    public int getNumCols() { return numColumns; }
    public ArrayList<Zombie> getZombiesOnLawn() { return zombiesOnLawn; }
    public ArrayList<Plant> getPlantsOnLawn() { return plantsOnLawn; }

    private boolean gameOver;

    private int numRows;
    private int numColumns;
    private Tile[][] gameTiles;

    private ArrayList<Zombie> zombiesOnLawn;
    private ArrayList<Plant>  plantsOnLawn;
}
