package main;
import java.util.Scanner;

import main.Sprites.Zombie.Zombie;

public class GameMain {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Level lvl1 = new Level(1, 1, 1);

        System.out.println("-- | WELCOME TO LEVEL " + lvl1.getLevelNum() + " OF PVZ | --");

        System.out.print("Do you want to start the game (yes/no) ? ");
        if (kb.nextLine().equals("yes")){
            //test sunflower, peashooter
            lvl1.getAvailablePlants().add("sunflower");
            lvl1.getAvailablePlants().add("peashooter");
            //test normal zombie
            lvl1.getAvailableZombies().add("Normal Zombie");
            //start map processes and timers
            lvl1.getMap().start();
        }
        else {
            System.out.println("Game Terminated.");
        }
    }
}
