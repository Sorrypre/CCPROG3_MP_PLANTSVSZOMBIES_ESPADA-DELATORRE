package main;
import java.util.ArrayList;

public class Level {
    Level(int levelNumber, int totalZombies, int numWaves) {
        this.levelNumber = levelNumber;
        this.totalZombies = totalZombies;
        this.numWaves = numWaves;
        map =  new Map(5,9);
        availablePlants = new ArrayList<String>();
        availableZombies = new ArrayList<String>();
    }
    public int getLevelNum(){ return this.levelNumber; }
    public int getTotalZombies(){ return this.totalZombies; }
    public int getNumWaves() {return this.numWaves; }
    public Map getMap() { return this.map; }
    public ArrayList<String> getAvailablePlants(){ return this.availablePlants; }
    public ArrayList<String> getAvailableZombies() { return this.availableZombies; }



    private int levelNumber;
    private int totalZombies;
    private int numWaves;
    private Map map;
    private ArrayList<String> availablePlants;
    private ArrayList<String> availableZombies;
}
