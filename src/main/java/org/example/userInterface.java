package org.example;

import java.util.Scanner;

public class userInterface {
    adventureMechanics am = new adventureMechanics();
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

    public void menuCommands(){
        menuInput = input.nextLine().toLowerCase();
            switch (menuInput) {
                case "start":
                    do {
                        System.out.println("Which direction would you like to go?");
                        am.direction = input.nextLine().toLowerCase();
                        am.movement();
                        switch (am.direction) {
                            case "exit":
                                keepPlaying = false;
                                break;
                            case "help":
                                menuText();
                                break;
                            case "look":
                                System.out.println("You look around");
                                break;
                        }
                    }while (keepPlaying);
                case "exit":
                    keepRunning = false;
                    break;
                case "help":
                    menuText();
                    break;
                case "look":
                    System.out.println("You look around.");
                    break;
            }

    }

    public void startGame(){
        do{
            menuCommands();
        }while (keepRunning);

    }

}
