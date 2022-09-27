package org.example;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    AdventureMechanics am = new AdventureMechanics();
    boolean keepRunning = true;
    boolean keepPlaying = true;
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

    public void moveInput(){
        System.out.println("Which direction would you like to go?");
        am.direction = input.nextLine().toLowerCase();
        switch (am.direction) {
            case "n",
                    "north",
                    "go north",
                    "go n":
                am.direction = "n";
                break;
            case "w",
                    "west",
                    "go west",
                    "go w":
                am.direction = "w";
                break;
            case "e",
                    "east",
                    "go east",
                    "go e":
                am.direction = "e";
                break;
            case "s",
                    "south",
                    "go south",
                    "go s":
                am.direction = "s";
                break;
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
        am.movement();
        outputRoom();

    }

    private void outputRoom() {

        System.out.println("You ");

        ArrayList<AdventureMechanics> alreadyVisited = new ArrayList<>();


    }

    public void menuInput() {
        switch (menuInput) {
            case "start":
                startOfTheGame();
                do {
                    moveInput();
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

    public void menuCommands() {
        menuInput = input.nextLine().toLowerCase();
        menuInput();
    }

    public void startGame() {
        do {
            menuCommands();
        } while (keepRunning);

    }

}
