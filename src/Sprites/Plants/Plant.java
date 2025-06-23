package Sprites.Plants;

public class Plant {
    public Plant (String n, int sc) {
        name = n;
        sunCost = sc;
        regenerationRate = 1;
        damage = 0;
        health = 100;
        range = 0;
        directDamage = 0;
        speed = 0;
        lastAdded = System.currentTimeMillis(); //current time in milliseconds
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setSunCost(int sunCost) {
        this.sunCost = sunCost;
    }

    public void setRegenerationRate(float regenerationRate) {
        this.regenerationRate = regenerationRate;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public void setDirectDamage(float directDamage) {
        this.directDamage = directDamage;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getSunCost() {
        return sunCost;
    }

    public float getRegenerationRate() {
        return regenerationRate;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public int getRange() {
        return range;
    }

    public float getDirectDamage() {
        return directDamage;
    }

    public int getSpeed() {
        return speed;
    }

    public long getLastAdded() {
        return lastAdded;
    }

    public boolean isValidSunCost() {
        return sunCost > 0;
    }
    //public access modifier reason is that there are inheritor classes
    protected String name;
    protected int sunCost;
    protected float regenerationRate;
    protected int damage;
    protected int health;
    protected int range;
    protected float directDamage;
    protected int speed;
    protected long lastAdded;
}
