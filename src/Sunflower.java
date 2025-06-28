/*********************************************************************************************************
 This is to certify that this project is our own work, based on our personal efforts in studying and applying the concepts
 learned. We have constructed the functions and their respective algorithms and corresponding code by ourselves. The
 program was run, tested, and debugged by our own efforts. We further certify that we have not copied in part or whole or
 otherwise plagiarized the work of other students and/or persons.

 Jensel John L. Espada, DLSU ID# 12409383
 Joramm Fredrik A. Dela Torre DLSU ID#12409529
 *********************************************************************************************************/

import java.util.Scanner;
import java.util.TimerTask;

/**
 * The class Sunflower represents the details of a sunflower in PvZ that
 * could not be found in Plant class
 *
 * @author Jensel John L. Espada
 * @author Joramm Fredrik A. Dela Torre
 * @version 1.0
 */
public class Sunflower extends Plant {
    /** This constructor initializes the name, sun cost to the parameter. It also initializes regeneration rate in milliseconds
     damage, health, range, direct damage, speed, regeneration timer, action timer, and when was Sunflower object created. It also
     initializes the Timer Task for regeneration which is scheduled at a fixed interval. It initializes a scanner, the rate of sun
     production and a sun counter. It also initializes the Timer Task for sun production.
     @param n name of the plant
     @param sc sun cost of the plant
     @param sunCounter the accumulated value of sun
     */
    public Sunflower(String n, int sc, Counter sunCounter) {
        super(n, sc);
        SUN_RATE = 24000;
        kb = new Scanner(System.in);
        this.sunCounter = sunCounter;

        TimerTask produceSunTimer = new TimerTask() {
            long curTime;
            @Override
            public void run() {
                if (!isDead()) {
                    curTime = System.currentTimeMillis();
                    if (curTime >= lastAdded + SUN_RATE) {
                        produceSun();
                        lastAdded = curTime;
                    }
                }
                else {
                    System.out.println("Sunflower Died");
                    actionTimer.cancel();
                    actionTimer.purge();
                    actionTimer = null;
                }
            }
        };
        actionTimer.scheduleAtFixedRate(produceSunTimer, 300, 300);
    }

    /** This constructor initializes the name, sun, damage, health, range, direct damage, speed cost to the parameter.
     It also initializes regeneration rate in milliseconds. regeneration timer, action timer, and when was Plant object created. It also
     initializes the Timer Task for regeneration which is scheduled at a fixed interval. IIt initializes a scanner, the rate of sun
     production and a sun counter. It also initializes the Timer Task for sun production.
     @param n name of the plant
     @param sc sun cost of the plant
     @param sunCounter the counter of accumulated sun
     @param regen regeneration rate of plant in milliseconds
     @param dmg damage of plant
     @param hp the health of plant
     @param range the range of plant
     @param dd the direct damage of plant
     @param spd the speed of the actionTimer
     */
    public Sunflower (String n, int sc, Counter sunCounter, int regen, int dmg, int hp, int range, float dd, int spd) {
        super(n, sc, regen, dmg, hp, range, dd, spd);
        SUN_RATE = 24000;
        kb = new Scanner(System.in);
        this.sunCounter = sunCounter;

        TimerTask produceSunTimer = new TimerTask() {
            long curTime;
            @Override
            public void run() {
                if (!isDead()) {
                    curTime = System.currentTimeMillis();
                    if (curTime >= lastAdded + SUN_RATE) {
                        produceSun();
                        lastAdded = curTime;
                    }
                }
                else {
                    System.out.println("Sunflower Action Timer is Over");
                    actionTimer.cancel();
                    actionTimer.purge();
                    actionTimer = null;
                }
            }
        };
        actionTimer.scheduleAtFixedRate(produceSunTimer, 300, 300);
    }

    /** This method produces a sun and asks the user for collection of sun
     */
    public void produceSun() {
        System.out.println("Sunflower generated a Sun");
        System.out.println("Would you like to collect the sun? (y/n)");
        try {
            if (kb.next().equalsIgnoreCase("y"))
                sunCounter.add(25);
        }
        catch(Exception e) {
            System.out.println("Wrong Format");
        }
        System.out.println("Current Sun: " + sunCounter.getValue());
    }

    /** This method returns the rate of sun generation
     @return SUN_RATE the rate of sun production
     */
    public int getSunGenerationRate() {
        return SUN_RATE;
    }

    private Counter sunCounter;
    private Scanner kb;
    private final int SUN_RATE;
}