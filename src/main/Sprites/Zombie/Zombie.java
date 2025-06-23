package main.Sprites.Zombie;

public class Zombie {
    public Zombie(){
        NAME = "Zombie";
        speed = 4;
        damage = 10;
        health = 70;
        zombieArmour = new Armour();
        zombieCounter++;
    }
    public Zombie(String zombieName){
        //you can use getName from the armor class and the base the zombie name from there
        NAME = zombieName;
        speed = 4;
        damage = 10;
        health = 70;
        zombieArmour = new Armour();
        zombieCounter++;
    }
    public Zombie(String zombieName, Armour zombieArmour){
        //you can use getName from the armor class and the base the zombie name from there
        NAME = zombieName;
        speed = 4 + zombieArmour.getMovementBonus();
        damage = 10;
        health = 70 + zombieArmour.getToleranceBonus();
        this.zombieArmour = zombieArmour;
        zombieCounter++;
    }

    public void setSpeed(int s){
        speed = s;
    }
    public void setDamage(int d){
        damage = d;
    }
    public void setHealth(int h){
        health = h;
    }

    public int getSpeed(){
        return speed;
    }
    public int getDamage(){
        return damage;
    }
    public int getHealth(){
        return health;
    }

    public void equip(Armour zombieArmour){
        this.zombieArmour = zombieArmour;
    }
    public void die(Zombie zombie){
        zombieCounter--;
        zombie = null;
        //destroy zombie object created
    }
    public void hit(){

    }


    private final String NAME;
    private int speed;
    private int damage;
    private int health;

    private Armour zombieArmour;

    private static int zombieCounter;

    //add a sort of list of armour that can be equipped by a zombie
}
