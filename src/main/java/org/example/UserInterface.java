package org.example;

import java.util.Scanner;

public class UserInterface {
    private AdventureMechanics am = new AdventureMechanics();
    private boolean keepRunning = true;
    private Scanner input = new Scanner(System.in);

    public void menuText() {
        System.out.println("Start the game: start");
        System.out.println("Exit the game: exit");
        System.out.println("Help with the game: help");
    }
    public String gameIntro() {
        am.getMap().map();
        String gameIntro = "You are lost in the woods, and wander around lost, looking for anything remotely looking like civilisation. " +
                "You stumble upon a " + am.getPlayer().getCurrentRoom().getDescription().toLowerCase();
        System.out.println(gameIntro);
        return gameIntro;
    }

    public void game() {
        gameIntro();
        do{
        System.out.println("Which direction would you like to go?");
        String userInputs = input.nextLine().toLowerCase();
        String[] userInputsList = userInputs.split(" ");
        String userCommand = userInputsList[0];
        if (userInputsList.length > 1) {
            userCommand = userInputsList[1];
        }
        gamePlay(userCommand);
    }while(keepRunning);

    }

    public void start() {
        String menuInput = input.nextLine().toLowerCase();
        switch (menuInput) {
            case "start":
                game();
                break;
            case "exit":
                System.out.println("Quitting game.");
                System.exit(0);
                break;
            case "help":
                menuText();
                break;

        }
    }

    public void gamePlay(String direction) {
        switch (direction){
            case "n",
                    "north":
                movement(direction);
                break;
            case "w",
                    "west":
                movement(direction);
                break;
            case "e",
                    "east":
                movement(direction);
                break;
            case "s",
                    "south":
                movement(direction);
                break;
            case "help":
                gameText();
                break;
            case "l",
                    "look":
                lookAround();
                break;
            case "exit":
                System.out.println("Quitting game.");
                System.exit(0);
                break;

        }
    }

    private void gameText() {
        System.out.println("In this game you move around by writing 'go' and whichever cardinal direction you would like to go." +
                "\neg. 'go north'."+
                "\nYou can look around the room you are in by writing 'look'." +
        "\nYou can exit the game by writing 'exit'.");
    }


    public void lookAround(){
        System.out.println(am.getPlayer().lookAround());
    }

    public void alreadyVisited() {
        if (!am.alreadyVisited()) {
            System.out.println("You are by " + am.getPlayer().getCurrentRoom().getDescription().toLowerCase());
        } else if (am.alreadyVisited()) {
            System.out.println("You are by " + am.getPlayer().getCurrentRoom().getDescriptionShort().toLowerCase());
        }
    }

    public void movement(String direction){
        am.playerMovement(direction);
        am.getPlayer().getCurrentRoom();
        alreadyVisited();
        if (am.getPlayer().isWrongDirection()){
            System.out.println("You try going " + direction + " but it's not possible.");
        }
    }

}