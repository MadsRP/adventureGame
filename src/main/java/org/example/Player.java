package org.example;


import java.util.ArrayList;

public class Player {

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();
    private boolean wrongDirection;

    public Player (Room currentRoom, ArrayList inventory){
        this.currentRoom = currentRoom;
        this.inventory = inventory;
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
        } else if (direction.charAt(0) == 'l'){
            newRoom = currentRoom;
        }

        if (newRoom == null){
            wrongDirection = true;
        } else {
            setCurrentRoom(newRoom);
        }


    }



    public Player (Room currentRoom){
        this.currentRoom = currentRoom;
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
