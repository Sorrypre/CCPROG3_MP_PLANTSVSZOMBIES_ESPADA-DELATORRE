/*********************************************************************************************************
 This is to certify that this project is our own work, based on our personal efforts in studying and applying the concepts
 learned. We have constructed the functions and their respective algorithms and corresponding code by ourselves. The
 program was run, tested, and debugged by our own efforts. We further certify that we have not copied in part or whole or
 otherwise plagiarized the work of other students and/or persons.

 Jensel John L. Espada, DLSU ID# 12409383
 Joramm Fredrik A. Dela Torre DLSU ID#12409529
 *********************************************************************************************************/
package main.Sprites.Zombie;

/**
 * The class Armour represents the details of armours that a Zombie from PvZ can wear.
 *
 * @author Jensel John L. Espada
 * @author Joramm Fredrik A. Dela Torre
 * @version 1.0
 */
public class Armour {
    /** This constructor initializes the name to "No Armour" and gives no bonus stats to the zombie
     */
    public Armour(){
        NAME = "No Armour";
        toleranceBonus = 0;
        movementBonus = 0;
    }

    /** This constructor initializes the name, tolerance, movement to the parameter.
     */
    public Armour(String n, int tB, int mB){
        NAME = n;
        toleranceBonus = tB;
        movementBonus = mB;
    }

    /** This method returns the name of the armour of the zombie
     @return NAME the name of the armour of the Zombie
     */
    public String getName(){
        return NAME;
    }

    /** This method returns the bonus health that the armour gives
     @return toleranceBonus the bonus health given to zombies
     */
    public int getToleranceBonus(){
        return toleranceBonus;
    }

    /** This method returns the speed that the armour gives to zombies or takes from zombies
     @return movementBonus the speed that the armour adds or takes
     */
    public int getMovementBonus(){
        return movementBonus;
    }

    private String NAME;
    private int toleranceBonus;
    private int movementBonus;
}
