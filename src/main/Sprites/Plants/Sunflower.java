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
        actionTimer = new Timer();
        kb = new Scanner(System.in);
        this.sunCounter = sunCounter;

        TimerTask produceSunTimer = new TimerTask() {
            @Override
            public void run() {
                produceSun();
            }
        };
        actionTimer.scheduleAtFixedRate(produceSunTimer, SUN_RATE, SUN_RATE);
    }

    public void produceSun() {
        System.out.println("Sun generated");
        System.out.println("Would you like to collect the sun? (yes/no)");
        choice = kb.nextLine();
            if (choice.equalsIgnoreCase("yes"))
                sunCounter.add(25);
        System.out.println("Current Sun: " + sunCounter.getValue());
    }

    public int getSunGenerationRate() {
        return SUN_RATE;
    }

    private Counter sunCounter;
    private Scanner kb;
    private String choice;
    private final int SUN_RATE;
}