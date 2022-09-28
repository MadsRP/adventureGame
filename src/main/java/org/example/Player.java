package org.example;


import java.util.ArrayList;

public class Player {

    Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();

    public Player (Room currentRoom, ArrayList inventory){
        this.currentRoom = currentRoom;
        this.inventory = inventory;
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

}
