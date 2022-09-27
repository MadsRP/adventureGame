package org.example;

import java.util.ArrayList;

public class AdventureMechanics {
    String direction = "";
    private ArrayList<Room> map;
    Player player;
    int newRoom = 0;

    public AdventureMechanics() {
        this.map = new ArrayList<>();
        map.add(new Room(0, "Forest clearing with two gates south and east.", -1, 3, 1, -1));
        map.add(new Room(1, "Small courtyard with a well.", -1, -1, 2, 0));
        map.add(new Room(2, "A courtyard with a moonlit sculpture.", -1, 5, -1, 1));
        map.add(new Room(3, "A small shack with random shit", 0, 6, -1, -1));
        map.add(new Room(4, "the patio of the house", -1, 7, -1, -1));
        map.add(new Room(5, "A small garden full of dangerous looking plants", 2, 8, -1, -1));
        map.add(new Room(6, "A small field with a scarecrow", 3, -1, 7, -1));
        map.add(new Room(7, "A courtyard with set of stairs leading to house", 4, -1, 6, 8));
        map.add(new Room(8, "A small shrine", 5, -1, -1, 7));

        player = new Player(map.get(0));

    }

    public String lookAround() {
        String lookAround = "";
        lookAround = player.currentRoom.getDescription();
        return lookAround;

    }

    public String gameStart(){
        String startDescription = "";
        startDescription = "You are lost in the woods, and wander around lost, looking for anything remotely looking like civilisation. " +
                "You stumple upon a " + player.currentRoom.getDescription().toLowerCase();
        System.out.println(startDescription);
        return startDescription;
    }

    public void movement() {

        Boolean keepPlaying = false;
        String movementDirection = "";
        do {
            keepPlaying = true;
            switch (direction) {
                case "n",
                        "north",
                    "go north",
                    "go n":
                    if (player.currentRoom.getNorthConnectingRoom() >= 0) {
                        System.out.println("You go north and enter " + player.currentRoom.getDescription().toLowerCase());
                        newRoom = player.currentRoom.getNorthConnectingRoom();
                        movementDirection = "north";
                    } else if (player.currentRoom.getNorthConnectingRoom() == -1) {
                        System.out.println("You cannot go this way");
                    }
                    break;
                case "w",
                        "west",
                        "go west",
                        "go w":
                    if (player.currentRoom.getWestConnectingRoom() >= 0) {
                        newRoom = player.currentRoom.getWestConnectingRoom();
                        movementDirection = "west";
                    } else if (player.currentRoom.getWestConnectingRoom() == -1) {
                        System.out.println("You cannot go this way");
                    }
                    break;
                case "e",
                        "east",
                        "go east",
                        "go e":
                    if (player.currentRoom.getEastConnectingRoom() >= 0) {
                        newRoom = player.currentRoom.getEastConnectingRoom();
                        movementDirection = "east";
                    } else if (player.currentRoom.getEastConnectingRoom() == -1) {
                        System.out.println("You cannot go this way");
                    }
                    break;
                case "s",
                        "south",
                        "go south",
                        "go s":
                    if (player.currentRoom.getSouthConnectingRoom() >= 0) {
                        newRoom = player.currentRoom.getSouthConnectingRoom();
                        movementDirection = "south";
                    } else if (player.currentRoom.getSouthConnectingRoom() == -1) {
                        System.out.println("You cannot go this way");
                    }
                    break;
                case "exit":
                    keepPlaying = false;
            }
            player.currentRoom = map.get(newRoom);
            System.out.println("You go " + movementDirection+ " and enter "  + player.currentRoom.getDescription().toLowerCase());
        } while (!keepPlaying);
    }
}



