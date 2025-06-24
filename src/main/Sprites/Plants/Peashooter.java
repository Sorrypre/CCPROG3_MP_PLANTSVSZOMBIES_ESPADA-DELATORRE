package main.Sprites.Plants;

import java.util.TimerTask;

public class Peashooter extends Plant {
    public Peashooter (String n, int sc) {
        super(n, sc);

        TimerTask shootPeaTimer = new TimerTask() {
            @Override
            public void run() {

            }
        };

        actionTimer.scheduleAtFixedRate(shootPeaTimer, 500,500);
    }

    public void shootPea() {

    }

    public Peashooter (String n, int sc, int regen, int dmg, int hp, int range, float dd, int spd) {
        super(n, sc, regen, dmg, hp, range, dd, spd);
    }
}
