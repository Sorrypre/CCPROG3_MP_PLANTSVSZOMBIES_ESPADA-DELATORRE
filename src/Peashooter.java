
import java.util.TimerTask;

/**
 * The class Peashooter represents the peashooter plant from Plants vs Zombies.
 *
 * @author Jensel John L. Espada
 * @author Joramm Fredrik A. Dela Torre
 * @version 1.0
 */
public class Peashooter extends Plant {
    /** This constructor initializes the name, sun cost to the parameter. It also initializes regeneration rate in milliseconds
     damage, health, range, direct damage, speed, regeneration timer, action timer, and when was Peashooter object created. It also
     initializes the Timer Task for regeneration which is scheduled at a fixed interval. It also initializes the action timer indicating
     how fast the Peashooter shoots Pea objects.
     @param n name of the plant
     @param sc sun cost of the plant
     */
    public Peashooter (Map map, String n, int sc) {
        super(n, sc);

        TimerTask shootPeaTimer = new TimerTask() {
            boolean status;
            @Override
            public void run() {
                status = isDead();
                if (!isDead() && map.zombieOnRow(rowPosition)){
                    System.out.println("SHOOT! Created a Pea Instance");
                    pea = new Pea(map, rowPosition, colPosition, status, damage, directDamage, range);
                    if (pea.isHit()) {
                        pea = null;
                    }
                }
                else if (isDead()) {
                    System.out.println("Peashooter Action Timer is Over");
                    actionTimer.cancel();
                    actionTimer.purge();
                    actionTimer = null;
                }
            }
        };

        actionTimer.scheduleAtFixedRate(shootPeaTimer, speed, speed);
    }

    /** This constructor initializes the map, name, sun, damage, health, range, direct damage, speed cost to the parameter.
     It also initializes regeneration rate in milliseconds. regeneration timer, action timer, and when was Peashooter object created. It also
     initializes the Timer Task for regeneration which is scheduled at a fixed interval. It also initializes the action timer indicating
     how fast the Peashooter shoots Pea objects.
     @param map the Map object of the Level
     @param n name of the plant
     @param sc sun cost of the plant
     @param regen regeneration rate of plant in milliseconds
     @param dmg damage of plant
     @param range the range of plant
     @param hp the health of plant
     @param dd the direct damage of plant
     @param spd the speed of in which actionTimer is activated
     */
    public Peashooter (Map map, String n, int sc, int regen, int dmg, int hp, int range, float dd, int spd) {
        super(n, sc, regen, dmg, hp, range, dd, spd);

        TimerTask shootPeaTimer = new TimerTask() {
            boolean status;
            @Override
            public void run() {
                status = isDead();
                if (!isDead() && map.zombieOnRow(rowPosition)){
                    System.out.println("SHOOT!");
                    pea = new Pea(map, rowPosition, colPosition, status, damage, directDamage, range);
                    if (pea.isHit()) {
                        pea = null;
                    }
                }
                else if (isDead()) {
                    System.out.println("Peashooter Died");
                    actionTimer.cancel();
                    actionTimer.purge();
                    actionTimer = null;
                }
            }
        };

        actionTimer.scheduleAtFixedRate(shootPeaTimer, speed, speed);
    }

    private Pea pea;
}
