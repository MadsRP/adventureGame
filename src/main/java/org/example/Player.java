package org.example;


public class Player {

    Room currentRoom = new Room();

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
