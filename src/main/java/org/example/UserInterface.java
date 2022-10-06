package org.example;

import java.util.Scanner;

public class UserInterface {

    private AdventureMechanics am = new AdventureMechanics();
    private boolean keepRunning = true;
    private Scanner input = new Scanner(System.in);
    private String userInputs;
    private String[] userInputsList;
    private String userCommand;

    public void menuText() {

        System.out.println("Start the game: start");
        System.out.println("Exit the game: exit");
        System.out.println("Help with the game: help");
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
    public String gameIntro() {
        String gameIntro = "You are lost in the woods, and wander around lost, looking for anything remotely looking like civilisation. " +
                "You stumble upon a " + am.getPlayer().getCurrentRoom().getDescription().toLowerCase();
        System.out.println(gameIntro);
        return gameIntro;
    }
    public void game() {
        gameIntro();
        do{
            System.out.println("Which action would you like to take?");
            String userInputs = input.nextLine().toLowerCase();
            String[] userInputsList = userInputs.split(" ");
            String userCommand = userInputsList[0];
            if (userInputsList.length>1){
                switch (userCommand) {
                    case "drop", "d" -> {
                        userCommand = userInputsList[1];
                        dropItem(userCommand);
                    }
                    case "take", "t" -> {
                        userCommand = userInputsList[1];
                        takeItem(userCommand);
                    }
                    case "eat", "e" -> {
                        userCommand = userInputsList[1];
                        eat(userCommand);
                    }
                    case "inspect", "i" -> {
                        userCommand = userInputsList[1];
                        inspect(userCommand);
                    }
                    case "equip" -> {
                        userCommand = userInputsList[1];
                        equip(userCommand);
                    }
                    default -> userCommand = userInputsList[1];
                }
            }
            gamePlay(userCommand);
        }while(keepRunning);

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
                helpText();
                break;
            case "l",
                    "look":
                lookAround();
                break;
            case "attack", "a":
                attack();
                break;
            case "inv",
                    "inventory":
                inventory();
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

    public void attack(){
        if (am.getPlayer().isItemExchange()){
            am.getPlayer().attack();
            if (!am.getPlayer().isRangedWeaponFire()){
                System.out.println("You have no more ammo in " + am.getPlayer().getCurrentWeapon().getItemName());
                return;
            } else {
                System.out.println("You have " + am.getPlayer().getCurrentAmmo() + " ammo left.");
            }
            System.out.println("You deal " + am.getPlayer().getCurrentWeapon().getDamage() + " damage");
        } else {
            System.out.println("You do not have a weapon equipped.");
        }

    }
    public void inventory(){
        if (am.getPlayer().getInventory().size() == 0){
            System.out.println("You have no items");
        }
        System.out.println("You have: " + am.getPlayer().getTotalHealth() + " health");
        if (am.getPlayer().getCurrentWeapon() != null) {
            System.out.println("You have a " + am.getPlayer().getCurrentWeapon().getItemName().toLowerCase() + " equipped");
            if (am.getPlayer().isRangedWeaponFire()){
                System.out.println("You have " + am.getPlayer().getCurrentAmmo() + " ammo left");
            }
        } else {
            System.out.println("You have no weapons equipped");
        }
        for (Item items : am.getPlayer().getInventory()){
            System.out.println("inventory: " + items.getItemName());

        }
    }
    private void equip(String userCommand) {
        am.getPlayer().equipWeapon(userCommand);
        if (am.getPlayer().isItemExchange()) {
            System.out.println("You equip a " + userCommand);
        } else  if (!am.getPlayer().isItemExchange()){
            System.out.println("Cannot equip " + userCommand);
        }
    }
    private void dropItem(String userCommand) {
        am.getPlayer().dropItem(userCommand);
        if (am.getPlayer().isItemExchange()) {
            System.out.println("You drop a " + userCommand);
        } else {
            System.out.println("Cannot find " + userCommand);
        }
    }
    public void takeItem(String userCommand){
        am.getPlayer().pickUpItem(userCommand);
        if (am.getPlayer().isItemExchange()) {
            System.out.println("You take a " + userCommand + ", it is " + am.getPlayer().inspectItem(userCommand));
        } else {
            System.out.println("Cannot find " + userCommand);
        }
    }
    public void eat(String userCommand){
        am.getPlayer().eatItem(userCommand);
        if (am.getPlayer().isItemExchange() && !am.getPlayer().isEdibleItem()) {
            System.out.println("You cannot eat " + userCommand);
        } else if (am.getPlayer().isItemExchange()) {
            System.out.println("You eat a " + userCommand);
            System.out.println("You now have " + am.getPlayer().getTotalHealth());
        } else {
            System.out.println("Cannot find " + userCommand);
        }
    }
    public void inspect(String userCommand){
        am.getPlayer().inspectItem(userCommand);
        if (am.getPlayer().isItemExchange()) {
            System.out.println(am.getPlayer().inspectItem(userCommand));
        } else {
            System.out.println("Cannot find " + userCommand);
        }
    }
    public String currentHealth(){
        int currentHealth = am.getCurrentHealth();
        String currentHealthOutput = "You currently have " + currentHealth + " health";
        return currentHealthOutput;
    }
    private void helpText() {
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