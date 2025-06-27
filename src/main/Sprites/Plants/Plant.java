/*********************************************************************************************************
 This is to certify that this project is our own work, based on our personal efforts in studying and applying the concepts
 learned. We have constructed the functions and their respective algorithms and corresponding code by ourselves. The
 program was run, tested, and debugged by our own efforts. We further certify that we have not copied in part or whole or
 otherwise plagiarized the work of other students and/or persons.

 Jensel John L. Espada, DLSU ID# 12409383
 Joramm Fredrik A. Dela Torre DLSU ID#12409529
 *********************************************************************************************************/
package main.Sprites.Plants;

import java.util.Timer;
import java.util.TimerTask;

/**
 * The class Plant represents the details of a Plant in Plant vs Zombies
 *
 * @author Jensel John L. Espada
 * @author Joramm Fredrik A. Dela Torre
 * @version 1.0
 */
public class Plant {
    /** This constructor initializes the name, sun cost to the parameter. It also initializes regeneration rate in milliseconds
     damage, health, range, direct damage, speed, regeneration timer, action timer, and when was Plant object created. It also
     initializes the Timer Task for regeneration which is scheduled at a fixed interval.
     @param n name of the plant
     @param sc sun cost of the plant
     */
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

    /** This constructor initializes the name, sun, damage, health, range, direct damage, speed cost to the parameter.
     It also initializes regeneration rate in milliseconds. regeneration timer, action timer, and when was Plant object created. It also
     initializes the Timer Task for regeneration which is scheduled at a fixed interval.
     @param n name of the plant
     @param sc sun cost of the plant
     @param regen regeneration rate of plant in milliseconds
     @param dmg damage of plant
     @param range the range of plant
     @param hp the health of plant
     @param dd the direct damage of plant
     */
    public Plant (String n, int sc, int regen, int dmg, int hp, int range, float dd, int spd) {
        this(n, sc);
        regenerationRate = regen;
        damage = dmg;
        health = hp;
        this.range = range;
        directDamage = dd;
        speed = spd;
    }

    /** This method sets the name of the plant to the parameter
     @param name the name of the plant
     */
    public void setName (String name) {
        this.name = name;
    }

    /** This method sets the sun cost of the plant to the parameter
     @param sunCost the sun cost of the plant
     */
    public void setSunCost(int sunCost) {
        this.sunCost = sunCost;
    }

    /** This method sets the regeneration rate of the plant to the parameter
     @param regenerationRate the rate where the plant recovers health
     */
    public void setRegenerationRate(int regenerationRate) {
        this.regenerationRate = regenerationRate;
    }

    /** This method sets the damage of the plant to the parameter
     @param damage the damage of the plant to zombies
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /** This method sets the health the plant to the parameter
     @param health the health of the plant
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /** This method sets the range the plant to the parameter
     @param range the range of the plant
     */
    public void setRange(int range) {
        this.range = range;
    }

    /** This method sets the multiplier to the damage of the plant to the parameter
     @param directDamage the multiplier to the damage when zombies are near
     */
    public void setDirectDamage(float directDamage) {
        this.directDamage = directDamage;
    }

    /** This method sets the attack speed of the plant to the parameter
     @param speed the attack speed of the plant
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /** This method sets the row position of the plant to the parameter
     @param row the row where the Plant object is located
     */
    public void setRow(int row) { rowPosition = row; }

    /** This method sets the column position of the plant to the parameter
     @param col the column where the Plant object is located
     */
    public void setCol(int col) { colPosition = col; }

    /** This method returns the name of the plant to the parameter
     @return name the name of the plant
     */
    public String getName() { return name; }

    /** This method returns the sun cost of the plant to the parameter
     @return sunCost the sun cost of the plant
     */
    public int getSunCost() { return sunCost; }

    /** This method returns the regeneration rate of the plant to the parameter
     @return regenerationRate the rate where the plant recovers health
     */
    public float getRegenerationRate() { return regenerationRate; }

    /** This method returns the damage of the plant to the parameter
     @return damage the damage of the plant to zombies
     */
    public int getDamage() {return damage; }

    /** This method returns the health the plant to the parameter
     @return health the health of the plant
     */
    public int getHealth() { return health; }

    /** This method returns the range the plant to the parameter
     @return range the range of the plant
     */
    public int getRange() { return range; }

    /** This method returns the multiplier to the damage of the plant to the parameter
     @return  directDamage the multiplier to the damage when zombies are near
     */
    public float getDirectDamage() { return directDamage; }

    /** This method returns the attack speed of the plant to the parameter
     @return speed the attack speed of the plant
     */
    public int getSpeed() { return speed; }

    /** This method returns the row position of the plant to the parameter
     @return rowPosition the row where the Plant object is located
     */
    public int getRow() { return rowPosition; }

    /** This method returns the column position of the plant to the parameter
     @return colPosition the column where the Plant object is located
     */
    public int getCol() { return colPosition; }

    /** This method returns true if plant health is less than or equal to 0
     @return true if health less than equal to 0, otherwise false
     */
    public boolean isDead() {
        return health <= 0;
    }

    /** This method returns true if sun cost is greater than 0
     @return true if sun cost is greater than 0
     */
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
