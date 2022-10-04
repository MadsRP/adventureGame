package org.example;

import org.w3c.dom.ls.LSOutput;

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
        String gameIntro = "You are lost in the woods, and wander around lost, looking for anything remotely looking like civilisation. " +
                "You stumble upon a " + am.getPlayer().getCurrentRoom().getDescription().toLowerCase();
        System.out.println(gameIntro);
        return gameIntro;
    }

    public String currentHealth(){
        int currentHealth = am.getCurrentHealth();
        String currentHealthOutput = "You currently have " + currentHealth + " health";
        return currentHealthOutput;
    }

    public void game() {
        gameIntro();
        do{
        System.out.println("Which action would you like to take?");
        String userInputs = input.nextLine().toLowerCase();
        String[] userInputsList = userInputs.split(" ");
        String userCommand = userInputsList[0];
        if (userInputsList.length>1){
            if (userCommand.equals("drop") || userCommand.equals("d")){
                userCommand = userInputsList[1];
                am.getPlayer().dropItem(userCommand);
                if (am.getPlayer().isItemExchange() == true){
                    System.out.println("You drop a " + userCommand);
                } else {
                    System.out.println("Cannot find " + userCommand);
                }
            } else if (userCommand.equals("take") || userCommand.equals("t")){
                userCommand = userInputsList[1];
                am.getPlayer().pickUpItem(userCommand);
                if (am.getPlayer().isItemExchange() == true){
                    System.out.println("You take a " + userCommand);
                } else {
                    System.out.println("Cannot find " + userCommand);
                }
            }else {
                userCommand = userInputsList[1];
            }

        }
        gamePlay(userCommand);
    }while(keepRunning);

    }

    public void start() {
        String menuInput = input.nextLine().toLowerCase();
        switch (menuInput) {
            case "start", "s":
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

    public void gamePlay(String userInputs) {
        switch (userInputs){
            case "n","north",
                    "s","south",
                    "w","west",
                    "e","east":
                movement(userInputs);
                break;
            case "help":
                gameText();
                break;
            case "l",
                    "look":
                lookAround();
                break;
            case "inv",
                    "inventory":
                if (am.getPlayer().getInventory().size() == 0){
                    System.out.println("You have no items");
                }
                for (Item items : am.getPlayer().getInventory()){
                    System.out.println("inventory: " + items.getItemName());
                }
                break;
            case "health",
                        "hp":
                System.out.println(currentHealth());
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
        System.out.println("You are in a " + am.getPlayer().lookAround());
        if(am.getPlayer().getCurrentRoom().getItemList().size() == 0){
            System.out.println("You find no items in " + am.getPlayer().getCurrentRoom().getDescriptionShort());
        } else {
            for (Item items : am.getPlayer().getCurrentRoom().getItemList()) {
                System.out.println(items.getItemName());
                if (items == null){
                    am.getPlayer().getCurrentRoom().getItemList().remove(null);
                }
            }

        }
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

    public AdventureMechanics getAm() {
        return am;
    }

    public void setAm(AdventureMechanics am) {
        this.am = am;
    }

}