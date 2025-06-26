/*********************************************************************************************************
 This is to certify that this project is our own work, based on our personal efforts in studying and applying the concepts
 learned. We have constructed the functions and their respective algorithms and corresponding code by ourselves. The
 program was run, tested, and debugged by our own efforts. We further certify that we have not copied in part or whole or
 otherwise plagiarized the work of other students and/or persons.

 Jensel John L. Espada, DLSU ID# 12409383
 Joramm Fredrik A. Dela Torre DLSU ID#12409529
 *********************************************************************************************************/
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
                    deletePea();
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

    public void deletePea() {
        pea = null;
    }

    public Peashooter (String n, int sc, int regen, int dmg, int hp, int range, float dd, int spd) {
        super(n, sc, regen, dmg, hp, range, dd, spd);
    }

    private Pea pea;
}
