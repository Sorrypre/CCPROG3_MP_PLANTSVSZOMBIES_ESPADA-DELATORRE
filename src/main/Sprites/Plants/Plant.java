package main.Sprites.Plants;

import java.util.Timer;
import java.util.TimerTask;

public class Plant {
    public Plant (String n, int sc) {
        name = n;
        if (isValidSunCost(sc))
            sunCost = sc;
        else
            sunCost = 100;
        regenerationRate = 1500;
        damage = 0;
        health = 20;
        range = 0;
        directDamage = 0;
        speed = 0;
        regenTimer = new Timer();
        actionTimer = new Timer();
        lastAdded = System.currentTimeMillis();

        TimerTask regenPlant = new TimerTask() {
            final int MAX_HP = health;
            long curTime;
            @Override
            public void run() {
                if (!isDead()) {
                    curTime = System.currentTimeMillis();
                    System.out.println("HP: " + health);
                    if (curTime >= lastAdded + regenerationRate) {
                        if (health < MAX_HP) {
                            health += 1;
                            lastAdded = curTime;
                        }
                    }
                }
                else {
                    System.out.println("Regen Timer is Over");
                    regenTimer.cancel();
                    regenTimer.purge();
                    regenTimer = null;
                }
            }
        };

        regenTimer.scheduleAtFixedRate(regenPlant, 300, 300);
    }


    public Plant (String n, int sc, int regen, int dmg, int hp, int range, float dd, int spd) {
        this(n, sc);
        regenerationRate = regen;
        damage = dmg;
        health = hp;
        this.range = range;
        directDamage = dd;
        speed = spd;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setSunCost(int sunCost) {
        this.sunCost = sunCost;
    }

    public void setRegenerationRate(int regenerationRate) {
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

    public void setRow(int x) { rowPosition = x; }

    public void setCol(int y) { colPosition = y; }

    public String getName() { return name; }

    public int getSunCost() { return sunCost; }

    public float getRegenerationRate() { return regenerationRate; }

    public int getDamage() {return damage; }

    public int getHealth() { return health; }

    public int getRange() { return range; }

    public float getDirectDamage() { return directDamage; }

    public int getSpeed() { return speed; }

    public Timer getActionTimer() { return actionTimer; }

    public int getRow() { return rowPosition; }

    public int getCol() { return colPosition; }

    public boolean isDead() {
        return health <= 0;
    }
    protected boolean isValidSunCost(int sc) {
        if (sc > 0)
            return true;
        return false;
    }
    //public access modifier reason is that there are inheritor classes
    protected Timer regenTimer;
    protected Timer actionTimer;
    protected String name;
    protected int sunCost;
    protected int regenerationRate;
    protected int damage;
    protected int health;
    protected int range;
    protected float directDamage;
    protected int speed;
    protected int rowPosition;
    protected int colPosition;
    protected long lastAdded; //used for action timer interval
}
