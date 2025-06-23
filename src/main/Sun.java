package Plants;

public class Sun {
    public Sun() {
        sun_dropped = false;
    }

    public void act() {
        Map backyard = new Map();
        Counter sunCounter = backyard.getSun_Counter();
        sunCounter.add(25);
    }

    public void sunDropped() {
        sun_dropped = true;
    }
    private boolean sun_dropped;
}
