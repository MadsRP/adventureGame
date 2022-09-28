package org.example;

import java.util.ArrayList;

public class AdventureMechanics {
    String direction = "";
    boolean wrongDirection = false;
    Map map = new Map();
    Player player = new Player(map.getFirstRoom());
    public String lookAround() {
        String lookAround = player.currentRoom.getDescription();
        return lookAround;
    }

    public void movement() {

        Room currentRoom = player.getCurrentRoom();
        Room newRoom = null;

            if (direction.equals("north")) {
                newRoom = currentRoom.getNorthConnectingRoom();
            } else if (direction.equals("south")) {
                newRoom = currentRoom.getSouthConnectingRoom();
            } else if (direction.equals("east")) {
                newRoom = currentRoom.getEastConnectingRoom();
            } else if (direction.equals("west")) {
                newRoom = currentRoom.getWestConnectingRoom();
            } else if (direction.equals("look")){
                currentRoom.getDescription();
            }

            if (newRoom == null){
                wrongDirection = true;
            } else {
                player.setCurrentRoom(newRoom);
            }


        }

    }



