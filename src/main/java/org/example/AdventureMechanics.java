package org.example;

import java.util.ArrayList;

public class AdventureMechanics {
    String direction = "";
    Room room1 = new Room(1, "Forest clearing with two gates south and east.");
    Room room2 = new Room(2, "Small courtyard with a well.");
    Room room3 = new Room(3, "A courtyard with a moonlit sculpture.");
    Room room4 = new Room(4, "A small shack with random shit");
    Room room5 = new Room(5, "the patio of the house");
    Room room6 = new Room(6, "A small garden full of dangerous looking plants");
    Room room7 = new Room(7, "A small field with a scarecrow");
    Room room8 = new Room(8, "A courtyard with set of stairs leading to house");
    Room room9 = new Room(9, "A small shrine");
    Player player = new Player(room1);





    public String lookAround() {
        String lookAround = "";
        lookAround = player.currentRoom.getDescription();
        return lookAround;

    }

    public String gameStart() {
        String startDescription = "";
        startDescription = "You are lost in the woods, and wander around lost, looking for anything remotely looking like civilisation. " +
                "You stumple upon a " + player.currentRoom.getDescription().toLowerCase();
        System.out.println(startDescription);
        return startDescription;
    }

    public void map(){

        room1.setEastConnectingRoom(room2);
        room1.setSouthConnectingRoom(room4);

        room2.setEastConnectingRoom(room3);
        room2.setWestConnectingRoom(room1);

        room3.setEastConnectingRoom(room2);
        room3.setSouthConnectingRoom(room6);

        room4.setNorthConnectingRoom(room1);
        room4.setSouthConnectingRoom(room7);

        room5.setSouthConnectingRoom(room8);

        room6.setNorthConnectingRoom(room3);
        room6.setSouthConnectingRoom(room9);

        room7.setNorthConnectingRoom(room4);
        room7.setEastConnectingRoom(room8);

        room8.setNorthConnectingRoom(room5);
        room8.setWestConnectingRoom(room7);
        room8.setEastConnectingRoom(room9);

        room9.setWestConnectingRoom(room8);
        room9.setNorthConnectingRoom(room6);
    }

    public void movement() {

        Room currentRoom = player.getCurrentRoom();
        Room newRoom = new Room();
        map();

         if(direction.equals("n"))
        {
            player.setCurrentRoom(currentRoom.getNorthConnectingRoom());
        } else if(direction.equals("s")) {
             player.setCurrentRoom(currentRoom.getSouthConnectingRoom());
        } else if(direction.equals("e"))
        {
            player.setCurrentRoom(currentRoom.getEastConnectingRoom());
        }else if(direction.equals("w"))
        {
            player.setCurrentRoom(currentRoom.getWestConnectingRoom());
        }

        System.out.println(player.getCurrentRoom().getDescription());


//        if ()
//        do {
//            keepPlaying = true;
//            switch (direction) {
//                case "n",
//                        "north",
//                        "go north",
//                        "go n":
//                    if (player.currentRoom.getNorthConnectingRoom() >= 0) {
//                        System.out.println("You go north and enter " + player.currentRoom.getDescription().toLowerCase());
//                        newRoom = player.currentRoom.getNorthConnectingRoom();
//                        movementDirection = "north";
//                    } else if (player.currentRoom.getNorthConnectingRoom() == -1) {
//                        System.out.println("You cannot go this way");
//                    }
//                    break;
//                case "w",
//                        "west",
//                        "go west",
//                        "go w":
//                    if (player.currentRoom.getWestConnectingRoom() >= 0) {
//                        newRoom = player.currentRoom.getWestConnectingRoom();
//                        movementDirection = "west";
//                    } else if (player.currentRoom.getWestConnectingRoom() == -1) {
//                        System.out.println("You cannot go this way");
//                    }
//                    break;
//                case "e",
//                        "east",
//                        "go east",
//                        "go e":
//                    if (player.currentRoom.getEastConnectingRoom() >= 0) {
//                        newRoom = player.currentRoom.getEastConnectingRoom();
//                        movementDirection = "east";
//                    } else if (player.currentRoom.getEastConnectingRoom() == -1) {
//                        System.out.println("You cannot go this way");
//                    }
//                    break;
//                case "s",
//                        "south",
//                        "go south",
//                        "go s":
//                    if (player.currentRoom.getSouthConnectingRoom() >= 0) {
//                        newRoom = player.currentRoom.getSouthConnectingRoom();
//                        movementDirection = "south";
//                    } else if (player.currentRoom.getSouthConnectingRoom() == -1) {
//                        System.out.println("You cannot go this way");
//                    }
//                    break;
//                case "exit":
//                    keepPlaying = false;
//            }
//            player.currentRoom = map.get(newRoom);
//            System.out.println("You go " + movementDirection + " and enter " + player.currentRoom.getDescription().toLowerCase());
//        } while (!keepPlaying);
    }
}



