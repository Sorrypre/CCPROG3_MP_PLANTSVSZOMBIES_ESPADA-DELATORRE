package main.Sprites.Plants;

import java.util.TimerTask;

public class Peashooter extends Plant {
    public Peashooter (String n, int sc) {
        super(n, sc);

        TimerTask shootPeaTimer = new TimerTask() {
            boolean status;
            @Override
            public void run() {
                status = isDead();
                if (!isDead())
                    pea = new Pea(status);
                else if (isDead()) {
                    actionTimer.cancel();
                    actionTimer.purge();
                    actionTimer = null;
                }
            }
        };

        actionTimer.scheduleAtFixedRate(shootPeaTimer, 1500,1500);
    }

    public void shootPea() {

    }

    public Peashooter (String n, int sc, int regen, int dmg, int hp, int range, float dd, int spd) {
        super(n, sc, regen, dmg, hp, range, dd, spd);
    }

    private Pea pea;
}
