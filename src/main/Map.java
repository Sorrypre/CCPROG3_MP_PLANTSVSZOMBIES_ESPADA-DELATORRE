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
        int scaledRow, scaledCol;

        scaledRow = row * Tile.getTileScale();
        scaledCol = (numColumns-1) * Tile.getTileScale();

        Zombie zombie = new Zombie(map, scaledRow, scaledCol);
        System.out.println("Created a zombie");
        zombiesOnLawn.add(zombie);
        gameTiles[row][numColumns-1].addObject();

        //instantiate a normal zombie
        //set its coordinates in the last x value which is 9 value
        //import random and place it on a random lawn
        //add number of object in the tile

    }
    public void placeSunFlower(int row, int col, int gamePhaseTime, Counter sunCounter){
        int scaledRow, scaledCol;
        Sunflower sunflower = new Sunflower("Sunflower", 50, sunCounter);
        System.out.println("Created a Sunflower at Time: " + (gamePhaseTime/60) + ":" + (gamePhaseTime%60));
        sunCounter.subtract(sunflower.getSunCost());
        //fix coordinate system labelling
        scaledRow = row * Tile.getTileScale();
        scaledCol = col * Tile.getTileScale();

        sunflower.setRow(scaledRow);
        sunflower.setCol(scaledCol);

        plantsOnLawn.add(sunflower); //adds to the arrayList
        gameTiles[row][col].addObject();
        gameTiles[row][col].setPlant(sunflower);
    }
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
    public void removeZombie(){
        Iterator<Zombie> iterZombie = zombiesOnLawn.iterator();
        Zombie zombie;
        while(iterZombie.hasNext()){
            zombie = iterZombie.next();
            if(zombie.isDead())
                iterZombie.remove();
        }
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
