package main.Sprites.Plants;

import main.Map;
import main.Counter;
import main.Level;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Sunflower extends Plant {
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
                    System.out.println("Sunflower Action Timer is Over");
                    kb.close();
                    actionTimer.cancel();
                    actionTimer.purge();
                    actionTimer = null;
                }
            }
        };
        actionTimer.scheduleAtFixedRate(produceSunTimer, 300, 300);
    }

    public void produceSun() {
        System.out.println("Sunflower generated a Sun");
        System.out.println("Would you like to collect the sun? (y/n)");
        if(kb.hasNext())
            if (kb.next().equalsIgnoreCase("y"))
                sunCounter.add(25);
        System.out.println("Current Sun: " + sunCounter.getValue());
    }

    public int getSunGenerationRate() {
        return SUN_RATE;
    }

    private Counter sunCounter;
    private Scanner kb;
    private final int SUN_RATE;
}