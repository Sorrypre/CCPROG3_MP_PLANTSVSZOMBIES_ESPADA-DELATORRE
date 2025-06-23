package Plants;

public class Sunflower extends Plant {
    public Sunflower (String n, int sc) {
        super(n, sc);
        SUN_RATE = 24000;
    }

    public void act() {
        produceSun(SUN_RATE);
    }

    public void produceSun(int sunRate) {
        long curTime = System.currentTimeMillis();
        if (curTime >= lastAdded + sunRate) {
            lastAdded = curTime;
            Sun sun = new Sun();
        }
    }

    public int getSunGenerationRate() {
        return SUN_RATE;
    }

    private final int SUN_RATE;
}