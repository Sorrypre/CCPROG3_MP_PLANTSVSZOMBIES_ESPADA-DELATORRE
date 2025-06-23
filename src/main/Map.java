import Plants.Counter;
import Plants.Sun;

import java.util.Timer;
import java.util.TimerTask;

public class Map {
    public Map() {
        x = new int[9];
        y = new int[5];
        gamePhaseTime = 60;
        Counter sun_Counter = new Counter();
        gamePhaseTimer = new Timer();

        gamePhaseTimer.scheduleAtFixedRate(countDown, 1000, 1000);
    }

    public void initializeColumns() {
        int coordinates = 0;
        int i;
        for (i = 0; i <x.length; i++) {
            x[i] = coordinates;
            coordinates += 16;
        }
    }

    public void initializeRows() {
        int coordinates = 0;
        int i;
        for (i = 0; i <x.length; i++) {
            x[i] = coordinates;
            coordinates += 16;
        }
    }

    public void dropSun() {
        Sun sun = new Sun();
        sun.sunDropped();
    }

    public Counter getSun_Counter() {
        return sun_Counter;
    }

    public int getGameTime() {
        return gamePhaseTime;
    }

    TimerTask countDown = new TimerTask() {
        @Override
        public void run() {
            gamePhaseTime--;
        }
    };

    private  int gamePhaseTime;
    private Timer gamePhaseTimer;
    private int[] x;
    private int[] y;
    private Counter sun_Counter;
}
