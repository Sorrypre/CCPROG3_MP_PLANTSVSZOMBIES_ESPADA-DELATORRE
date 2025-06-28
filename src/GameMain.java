/*********************************************************************************************************
 This is to certify that this project is our own work, based on our personal efforts in studying and applying the concepts
 learned. We have constructed the functions and their respective algorithms and corresponding code by ourselves. The
 program was run, tested, and debugged by our own efforts. We further certify that we have not copied in part or whole or
 otherwise plagiarized the work of other students and/or persons.

 Jensel John L. Espada, DLSU ID# 12409383
 Joramm Fredrik A. Dela Torre DLSU ID#12409529
 *********************************************************************************************************/
import java.util.Scanner;

/**
 * The class GameMain represents the main game phase details of the game PvZ. Used to test the classes,
 * methods, constructors with the main method.
 *
 * @author Jensel John L. Espada
 * @author Joramm Fredrik A. Dela Torre
 * @version 1.0
 */
public class GameMain {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Level lvl1 = new Level(1);

        System.out.println("-- | WELCOME TO LEVEL " + lvl1.getLevelNum() + " OF PVZ | --");
        System.out.println("Welcome to Plants vs Zombies");
        System.out.println("Type \'y\' or \'n\' for Yes or No inputs");
        System.out.println("Type \'p\' to plant Plants");
        System.out.println("Type \"ps\" or \"sf\" for Peashooter or Sunflower");
        System.out.println("Guide on row and column tile for the Plants and Zombies");
        System.out.println(" ___ ___ ___ ___ ___ ___ ___ ___ ___ ___ ___");
        System.out.println("|   |   |   |   |   |   |   |   |   |   |   |");
        System.out.println("| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |   |");
        System.out.println("|___|___|___|___|___|___|___|___|___|___|___|");
        System.out.println("|   |   |   |   |   |   |   |   |   |   |   |");
        System.out.println("| H |   |   |   |   |   |   |   |   |   | 1 |");
        System.out.println("|___|___|___|___|___|___|___|___|___|___|___|");
        System.out.println("|   |   |   |   |   |   |   |   |   |   |   |");
        System.out.println("| O |   |   |   |   |   |   |   |   |   | 2 |");
        System.out.println("|___|___|___|___|___|___|___|___|___|___|___|");
        System.out.println("|   |   |   |   |   |   |   |   |   |   |   |");
        System.out.println("| U |   |   |   |   |   |   |   |   |   | 3 |");
        System.out.println("|___|___|___|___|___|___|___|___|___|___|___|");
        System.out.println("|   |   |   |   |   |   |   |   |   |   |   |");
        System.out.println("| S |   |   |   |   |   |   |   |   |   | 4 |");
        System.out.println("|___|___|___|___|___|___|___|___|___|___|___|");
        System.out.println("|   |   |   |   |   |   |   |   |   |   |   |");
        System.out.println("| E |   |   |   |   |   |   |   |   |   | 5 |");
        System.out.println("|___|___|___|___|___|___|___|___|___|___|___|");

        System.out.print("Do you want to start the game (y/n) ? ");
        if (kb.next().equals("y")) {
            System.out.println("Game Start.");
            //test sunflower, peashooter
            lvl1.getAvailablePlants().add("sf");
            lvl1.getAvailablePlants().add("ps");
            //test normal zombie
            lvl1.getAvailableZombies().add("Normal Zombie");
            //start map processes and timers
            lvl1.start();
        }
        else {
            System.out.println("Game Terminated.");
        }
    }
}
