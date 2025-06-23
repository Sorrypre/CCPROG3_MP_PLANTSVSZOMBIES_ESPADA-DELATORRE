package main;
import java.util.ArrayList;

public class Level {
    Level() {
        levelNumber = 1;
        totalZombies = 0;
        numWaves = 4;
        map =  new Map();
        availableZombies.add("Normal Zombie");
        availablePlants.add("Sunflower");
        availablePlants.add("Peashooter");
    }
    private int levelNumber;
    private int totalZombies;
    private int numWaves;
    private Map map;
    private ArrayList<String> availablePlants;
    private ArrayList<String> availableZombies;
}
