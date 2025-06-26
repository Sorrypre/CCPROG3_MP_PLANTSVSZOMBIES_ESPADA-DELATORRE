package main;
import java.util.Scanner;

public class GameMain {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Level lvl1 = new Level(1, 1, 1);

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
            lvl1.getAvailablePlants().add("sunflower");
            lvl1.getAvailablePlants().add("peashooter");
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
