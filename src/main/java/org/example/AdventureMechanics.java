package org.example;

import com.sun.jdi.event.BreakpointEvent;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;

public class AdventureMechanics {
    String direction = "";
    Room room1 = new Room(1, "Forest clearing with two gates south and east.");
    Room room2 = new Room(2, "Small courtyard with a well.");
    Room room3 = new Room(3, "A courtyard with a moonlit sculpture.");
    Room room4 = new Room(4, "A small shack with random shit.");
    Room room5 = new Room(5, "the patio of the house.");
    Room room6 = new Room(6, "A small garden full of dangerous looking plants.");
    Room room7 = new Room(7, "A small field with a scarecrow.");
    Room room8 = new Room(8, "A courtyard with set of stairs leading to house.");
    Room room9 = new Room(9, "A small shrine.");
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

        room3.setWestConnectingRoom(room2);
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
        Room previousRoom = player.getCurrentRoom();
        map();

            if (direction.equals("n")) {
                player.setCurrentRoom(currentRoom.getNorthConnectingRoom());
            } else if (direction.equals("s")) {
                player.setCurrentRoom(currentRoom.getSouthConnectingRoom());
            } else if (direction.equals("e")) {
                player.setCurrentRoom(currentRoom.getEastConnectingRoom());
            } else if (direction.equals("w")) {
                player.setCurrentRoom(currentRoom.getWestConnectingRoom());
            }

            if (player.getCurrentRoom() == null){
                System.out.println("You cant go this way.");
                player.setCurrentRoom(previousRoom);
            }

        }

    }



