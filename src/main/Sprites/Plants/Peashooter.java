package main.Sprites.Plants;

import java.util.TimerTask;
import main.Map;
import main.Sprites.Zombie.*;

public class Peashooter extends Plant {
    public Peashooter (Map map, String n, int sc) {
        super(n, sc);

        TimerTask shootPeaTimer = new TimerTask() {
            boolean status;
            @Override
            public void run() {
                status = isDead();
                if (!isDead()){
                    System.out.println("SHOOT!");
                    pea = new Pea(map, rowPosition, colPosition, status);
                    if (pea.isHit(map))
                        damageZombie(map.closestZombie(rowPosition, colPosition));
                    if(pea.isDead())
                        pea = null;
                }
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
    public void deletePea(){
        pea = null;
    }
    public void damageZombie(Zombie zombie){
        //If within 32 distance between peashooter and zombie
        //dmg is amplified by direct damage
        if(colPosition + 32 <= zombie.getColPosition())
            zombie.setHealth(zombie.getHealth() - (int)(damage * directDamage));
        else zombie.setHealth(zombie.getHealth() - damage);
    }

    public Peashooter (String n, int sc, int regen, int dmg, int hp, int range, float dd, int spd) {
        super(n, sc, regen, dmg, hp, range, dd, spd);
    }

    private Pea pea;
}
