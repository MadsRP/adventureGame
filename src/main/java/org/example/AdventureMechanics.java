package org.example;

import java.util.ArrayList;

public class AdventureMechanics {
    String direction = "";
    Boolean keepGoing = true;
    Room room = new Room();

    public void movement() {

        try {
            room.setCurrentRoom(room.getRoomNumber());
                switch (direction) {
                    case "go north":
                    case "go n":
                    case "n":
                    case "north":
                        room.setRoomNumber(room.getCurrentRoom() + 1);
                        System.out.println("You go north to room " + room.getRoomNumber());
                        break;
                    case "go south":
                    case "go s":
                    case "s":
                    case "south":
                        room.setRoomNumber(room.getCurrentRoom() + 1);
                        System.out.println("you go south to room " + room.getRoomNumber());
                        break;
                    case "go east":
                    case "go e":
                    case "e":
                    case "east":
                        room.setRoomNumber(room.getCurrentRoom() + 1);
                        System.out.println("you go east to room " + room.getRoomNumber());
                        break;
                    case "go west":
                    case "go w":
                    case "w":
                    case "west":
                        room.setRoomNumber(room.getCurrentRoom() + 1);
                        System.out.println("you go west to room " + room.getRoomNumber());
                        break;
                }
        } catch (Exception e) {
            System.out.println("Please enter a valid direction.");

        }
    }
}
