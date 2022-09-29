package org.example;


import java.util.ArrayList;

public class Player {


    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();
    private boolean wrongDirection;

    public Player (Room currentRoom, ArrayList inventory){
        this.currentRoom = currentRoom;
        this.inventory = inventory;
    }

    public Player (Room currentRoom){
        this.currentRoom = currentRoom;
    }


    public String lookAround(){
        String currentRoomDescription = currentRoom.getDescription();
        String lookAround = "You are by " + currentRoomDescription.toLowerCase();


        return lookAround;

    }
    public void movement(String direction) {

        currentRoom = getCurrentRoom();
        Room newRoom = null;

        if (direction.charAt(0) == 'n') {
            newRoom = currentRoom.getNorthConnectingRoom();
        } else if (direction.charAt(0) == 's') {
            newRoom = currentRoom.getSouthConnectingRoom();
        } else if (direction.charAt(0) == 'e') {
            newRoom = currentRoom.getEastConnectingRoom();
        } else if (direction.charAt(0) == 'w') {
            newRoom = currentRoom.getWestConnectingRoom();
        }

        if (newRoom == null){
            wrongDirection = true;
        } else {
            setCurrentRoom(newRoom);
        }


    }


    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public boolean isWrongDirection() {
        return wrongDirection;
    }

    public void setWrongDirection(boolean wrongDirection) {
        this.wrongDirection = wrongDirection;
    }

}
