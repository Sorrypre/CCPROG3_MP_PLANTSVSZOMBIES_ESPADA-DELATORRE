package main.Sprites.Zombie;

public class Armour {
    public Armour(){
        NAME = "No Armour";
        toleranceBonus = 0;
        movementBonus = 0;
    }
    public Armour(String n, int tB, int mB){
        NAME = n;
        toleranceBonus = tB;
        movementBonus = mB;
    }
    public String getName(){
        return NAME;
    }
    public int getToleranceBonus(){
        return toleranceBonus;
    }
    public int getMovementBonus(){
        return movementBonus;
    }
    private String NAME;
    private int toleranceBonus;
    private int movementBonus;
}
