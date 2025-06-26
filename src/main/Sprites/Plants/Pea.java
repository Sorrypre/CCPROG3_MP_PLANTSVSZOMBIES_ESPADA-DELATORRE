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

public class Pea {
    public Pea(boolean status) {
        speed = 4;
        isDead = status;

        TimerTask peaMove =  new TimerTask() {
            @Override
            public void run() {
                if (!status) {
                    move();
                }
                else if (status) {
                    moveTimer.cancel();
                    moveTimer.purge();
                    moveTimer = null;
                }
            }
        };
        moveTimer.scheduleAtFixedRate(peaMove, 500,500);
    }

    public void move() {

    }
    public void setSpeed(int speed) { this.speed = speed; }

    public int getSpeed() {
        return speed;
    }
    private Timer moveTimer;
    private boolean isDead;
    private int speed;
}
