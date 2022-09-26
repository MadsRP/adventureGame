package org.example;

import java.util.Scanner;

public class adventureMechanics {

    String direction;
    Scanner input = new Scanner(System.in);



    public void movement() {
            try {

                switch (direction) {
                    case "go north":
                    case "go n":
                    case "n":
                    case "north":
                        System.out.println("you go north");
                        break;
                    case "go south":
                    case "go s":
                    case "s":
                    case "south":
                        System.out.println("you go south");
                        break;
                    case "go east":
                    case "go e":
                    case "e":
                    case "east":
                        System.out.println("you go east");
                        break;
                    case "go west":
                    case "go w":
                    case "w":
                    case "west":
                        System.out.println("you go west");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid direction.");
            }
    }
}
