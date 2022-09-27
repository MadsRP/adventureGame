package org.example;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    AdventureMechanics am = new AdventureMechanics();
    ArrayList<Integer> alreadyVisited = new ArrayList<>();
    boolean keepRunning = true;
    String menuInput;
    Scanner input = new Scanner(System.in);

    public void menuText() {
        System.out.println("Start the game: start");
        System.out.println("Exit the game: exit");
        System.out.println("Help with the game: help");
        System.out.println("Get description of your room again: Look");
    }

    public String gameIntro() {
        am.map();
        String gameIntro = "You are lost in the woods, and wander around lost, looking for anything remotely looking like civilisation. " +
                "You stumple upon a " + am.player.currentRoom.getDescription().toLowerCase();
        System.out.println(gameIntro);
        return gameIntro;
    }

    public void moveInput() {
        System.out.println("Which direction would you like to go?");
        am.direction = input.nextLine().toLowerCase();
            switch (am.direction) {
                case "n",
                        "north",
                        "go north",
                        "go n":
                    am.direction = "north";
                    am.movement();
                    alreadyVisited();
                    break;
                case "w",
                        "west",
                        "go west",
                        "go w":
                    am.direction = "west";
                    am.movement();
                    alreadyVisited();
                    break;
                case "e",
                        "east",
                        "go east",
                        "go e":
                    am.direction = "east";
                    am.movement();
                    alreadyVisited();
                    break;
                case "s",
                        "south",
                        "go south",
                        "go s":
                    am.direction = "south";
                    am.movement();
                    alreadyVisited();
                    break;
                case "exit":
                    System.out.println("Quitting game.");
                    System.exit(0);
                    break;
                case "help":
                    menuText();
                    break;
                case "look":
                    System.out.println("You see " + am.lookAround());
                    break;

            }
    }


    private void alreadyVisited(){
        if(alreadyVisited.contains(am.player.currentRoom.getRoomNumber())){
            System.out.println("You are back by " + am.player.currentRoom.getDescriptionShort());
        } else if(!alreadyVisited.contains(am.player.currentRoom.getRoomNumber())){
            System.out.println("You are by " + am.player.getCurrentRoom().getDescription().toLowerCase());
        }
        alreadyVisited.add(am.player.getCurrentRoom().getRoomNumber());
    }

    public void menuInput() {
        switch (menuInput) {
            case "start":
                gameIntro();
                do {
                    moveInput();
                } while (keepRunning);
            case "exit":
                System.out.println("Quitting game.");
                System.exit(0);
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
