package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private AdventureMechanics am = new AdventureMechanics();
    private boolean keepRunning = true;
    private String menuInput;
    private Scanner input = new Scanner(System.in);

    public void menuText() {
        System.out.println("Start the game: start");
        System.out.println("Exit the game: exit");
        System.out.println("Help with the game: help");
        System.out.println("Get description of your room again: Look");
    }

    public String gameIntro() {
        String gameIntro = "You are lost in the woods, and wander around lost, looking for anything remotely looking like civilisation. " +
                "You stumble upon a " + am.player.currentRoom.getDescription().toLowerCase();
        System.out.println(gameIntro);
        return gameIntro;
    }

//    public void alreadyVisited() {
//        if (am.alreadyVisited.contains(am.player.currentRoom.getRoomNumber())) {
//            System.out.println("You are back by " + map.player.currentRoom.getDescriptionShort());
//        } else if (!map.alreadyVisited.contains(map.player.currentRoom.getRoomNumber())) {
//            System.out.println("You are by " + map.player.getCurrentRoom().getDescription().toLowerCase());
//        }
//        map.alreadyVisited.add(map.player.getCurrentRoom().getRoomNumber());
//    }

    public void gamePlay() {
        switch (am.direction) {
            case "n",
                    "north",
                    "go north",
                    "go n":
                am.direction = "north";
                am.movement();
                //alreadyVisited();
                if (am.wrongDirection){
                    System.out.println("You try going " + am.direction + " but it's not possible.");
                }
                break;
            case "w",
                    "west",
                    "go west",
                    "go w":
                am.direction = "west";
                am.movement();
                //alreadyVisited();
                if (am.wrongDirection){
                    System.out.println("You try going " + am.direction + " but it's not possible.");
                }
                break;
            case "e",
                    "east",
                    "go east",
                    "go e":
                am.direction = "east";
                am.movement();
                //alreadyVisited();
                if (am.wrongDirection){
                    System.out.println(am.player.currentRoom);
                    System.out.println("You try going " + am.direction + " but it's not possible.");
                }
                break;
            case "s",
                    "south",
                    "go south",
                    "go s":
                am.direction = "south";
                am.movement();
                //alreadyVisited();
                if (am.wrongDirection){
                    System.out.println("You try going " + am.direction + " but it's not possible.");
                }
                break;
        }
    }

    public void userInputsDuringGame() {
        System.out.println("Which direction would you like to go?");
        am.direction = input.nextLine().toLowerCase();
        gamePlay();
        switch (am.direction) {
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


    public void bootMenu() {
        switch (menuInput) {
            case "start":
                gameIntro();
                do {
                    userInputsDuringGame();
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

    public void startGame() {
        do {
            menuInput = input.nextLine().toLowerCase();
            bootMenu();
        } while (keepRunning);
    }
}