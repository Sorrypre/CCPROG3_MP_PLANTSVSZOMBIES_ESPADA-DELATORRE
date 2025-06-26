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
