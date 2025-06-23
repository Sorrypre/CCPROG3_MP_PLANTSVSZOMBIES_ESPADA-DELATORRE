package main.Sprites.Plants;

import java.util.Timer;
import java.util.TimerTask;

public class Sunflower extends Plant {
    public Sunflower (String n, int sc) {
        super(n, sc);
        SUN_RATE = 24000;
    }

    public int getSunGenerationRate() {
        return SUN_RATE;
    }

    private final int SUN_RATE;
}