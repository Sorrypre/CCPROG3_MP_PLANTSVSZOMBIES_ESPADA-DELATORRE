package Sprites.Plants;

public class Sunflower extends Plant {
    public Sunflower (String n, int sc) {
        super(n, sc);
        SUN_RATE = 24000;
    }

    public void act() {
        produceSun(SUN_RATE);
    }

    public void produceSun(int sunRate) {
    }

    public int getSunGenerationRate() {
        return SUN_RATE;
    }

    private final int SUN_RATE;
}