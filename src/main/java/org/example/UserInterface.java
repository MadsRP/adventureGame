package org.example;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class UserInterface {
    AdventureMechanics am = new AdventureMechanics();
    boolean keepRunning = true;
    boolean keepPlaying = true;
    String directionN = "";
    String directionS = "";
    String directionW = "";
    String directionE = "";
    String menuInput;
    Scanner input = new Scanner(System.in);

    public void menuText() {
        System.out.println("Start the game: start");
        System.out.println("Exit the game: exit");
        System.out.println("Help with the game: help");
        System.out.println("Get description of your room again: Look");
    }

    public void startOfTheGame() {
        am.gameStart();

    }

    public void menuCommands() {
        menuInput = input.nextLine().toLowerCase();
        switch (menuInput) {
            case "start":
                startOfTheGame();
                do {
                    System.out.println("Which direction would you like to go?");
                    am.direction = input.nextLine().toLowerCase();
                    am.movement();
                    switch (am.direction) {
//                        case "n",
//                                "north",
//                                "go north",
//                                "go n":
//                            directionN = "n";
//                        case "w",
//                                "west",
//                                "go west",
//                                "go w":
//                            directionW = "w";
//                        case "e",
//                                "east",
//                                "go east",
//                                "go e":
//                            directionE = "e";
//                        case "s",
//                                "south",
//                                "go south",
//                                "go s":
//                            directionS = "s";
                        case "exit":
                            keepPlaying = false;
                            break;
                        case "help":
                            menuText();
                            break;
                        case "look":
                            System.out.println(am.lookAround());
                            break;
                    }

                    System.out.println(am.direction);
                } while (keepRunning = true);
            case "exit":
                keepRunning = false;
                break;
            case "help":
                menuText();
                break;
            case "look":
                System.out.println(am.lookAround());
                break;
        }

    }

    public void startGame() {
        do {
            menuCommands();
        } while (keepRunning);

    }

}
