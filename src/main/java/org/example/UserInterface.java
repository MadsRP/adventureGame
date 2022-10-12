package org.example;

import java.util.Scanner;

public class UserInterface {

    private AdventureMechanics am = new AdventureMechanics();
    private boolean keepRunning = true;
    private Scanner input = new Scanner(System.in);

    public void menuText() {
        System.out.println("Welcome to the great game of Adventure!");
        System.out.println("Please use the terminal to type your desired action below:");
        System.out.println("(If it is your first time playing, use help to see commands, once you start the game.)");
        System.out.println("Start the game: start");
        System.out.println("Exit the game: exit");
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
            default:
                System.out.println("You did not input a correct command. Please input from the list above.");
                start();
        }
    }
    public String gameIntro() {
        String gameIntro = "You are lost in the woods, and wander around, looking for anything remotely looking like civilisation. " +
                "\nYou stumble upon " + am.getPlayer().getCurrentRoom().getDescription().toLowerCase() +
                "\nIn the clearing you see a zombie aimlessly walking around.";
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
            case "exit":
                System.out.println("Quitting game.");
                System.exit(0);
                break;

        }
    }
    public void attack(){
        int currentDamage = 0;
        if (am.getPlayer().getCurrentWeapon() == null){
            System.out.println("You do not have a weapon equipped");
            return;
        }
        if (am.getPlayer().isItemExchange()){
            am.getPlayer().useWeapon();
            if(am.getPlayer().isMeleeWeapon()){
                currentDamage = am.getPlayer().getCurrentWeapon().getDamage();
            }else if (am.getPlayer().isRangedWeaponFire() && !am.getPlayer().isMeleeWeapon()){
                System.out.println("You have " + am.getPlayer().getCurrentAmmo() + " ammo left.");
                currentDamage = am.getPlayer().getCurrentWeapon().getDamage();
            } else if (!am.getPlayer().isRangedWeaponFire() ){
                System.out.println("You have no more ammo in " + am.getPlayer().getCurrentWeapon().getItemName());
            }
        } else {
            System.out.println("You do not have a weapon equipped.");
        }
        Monster currentMonster = null;
        for (Monster monster : am.getPlayer().getCurrentRoom().getMonsterList()){
            am.attackMonster(monster);
            System.out.println("You deal " + currentDamage + " damage to the " + monster.getType());
            System.out.println("The " + monster.getType()+  " has " + monster.getHealth() + " health left.");
            currentMonster = monster;
        }
        if (am.isMonsterDead(currentMonster)) {
            System.out.println("The " + currentMonster.getType().toLowerCase() + " dies and drops a " + currentMonster.getWeapon().getItemName().toLowerCase());
        } else {
            am.attackPlayer(currentMonster, am.getPlayer());
            System.out.println("You get attacked by " + currentMonster.getType() + " for " + currentMonster.getWeapon().getDamage() + " damage");
            System.out.println("You have " + am.getPlayer().getHealth() + " health left.");
        }
        if (am.isPlayerDead(am.getPlayer()))
        {
            keepRunning = false;
            System.out.println("You have died.\n");

        }
    }
    public void inventory(){
        if (am.getPlayer().getInventory().size() == 0){
            System.out.println("You have no items");
        }
        System.out.println("You have: " + am.getPlayer().getHealth() + " health");
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
            System.out.println("You now have " + am.getPlayer().getHealth());
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
    private void helpText() {
        System.out.println("In this game you move around by writing 'go' and whichever cardinal direction you would like to go." +
                        "\neg. 'go north'."+
                        "\nYou can check your inventory and health by typing 'inv' or 'inventory'."+
                        "\nIf there is a monster in the room you are in, you may want to attack it, which you do by writing 'Attack'."+
                        "\nBefore you attack however, you should equip a weapon. You do so by writing 'equip *weaponname*'."+
                        "\nAround the map there will be items in the rooms."+
                        "\nYou can pick up items from rooms or drop items from your inventory by typing either 'take *itemname*' or 'drop *itemname'."+
                        "\nIf you lose health, you can regain health by eating food. You do so by typing 'eat *foodname'."+
                        "\nIf you would like to look at an items description, you can type 'inspect *itemname*' to see an items description."+
                        "\nYou can look around the room you are in by writing 'look'." +
                        "\nYou can exit the game by writing 'exit'.");
    }
    public void lookAround(){
        System.out.println("You are in a " + am.getPlayer().lookAround());

        if(am.getPlayer().getCurrentRoom().getMonsterList().size() == 0 ){
            System.out.println("There are no monsters in the room");
        } else {
            for (Monster monster : am.getPlayer().getCurrentRoom().getMonsterList()){
                System.out.println("There is a " + monster.getType() + " in the room");
            }
        }

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
        Monster currentMonster = null;
        if (!am.alreadyVisited()) {
            System.out.println("You are by " + am.getPlayer().getCurrentRoom().getDescription().toLowerCase());
            for (Monster monster : am.getPlayer().getCurrentRoom().getMonsterList()) {
                currentMonster = monster;
            }
            if (currentMonster==null){
                System.out.println("There are no monsters");
            }else {
                System.out.println("You find a " + currentMonster.getType().toLowerCase() + " in the room.");
            }
        }else if (am.alreadyVisited()) {
                System.out.println("You are back by " + am.getPlayer().getCurrentRoom().getDescriptionShort().toLowerCase());
            }
        }


    public void movement(String direction){
        am.playerMovement(direction);
        am.getPlayer().getCurrentRoom();
        if (am.getPlayer().isWrongDirection()){
            switch (direction){
                case "n": direction = "north"; break;
                case "s": direction = "south"; break;
                case "e": direction = "east"; break;
                case "w": direction = "west"; break;
            }
        }
        System.out.println("You try going " + direction + " but there is no path.");
        alreadyVisited();

    }
    public AdventureMechanics getAm() {
        return am;
    }

}