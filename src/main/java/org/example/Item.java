package org.example;

public class Item {

    String itemName;
    String itemDescpription;



    Room room = new Room();
    Room currentRoom = new Room();

    public Item(String itemName, String itemDescription){
        this.itemName = itemName;
        this.itemDescpription = itemDescription;
    }
    public Item(String itemName){
        this.itemName = itemName;
    }
    public Item(){
    }
    public Item(Room currentRoom){
        this.currentRoom = currentRoom;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public String getItemDescpription() {
        return itemDescpription;
    }

    public void setItemDescpription(String itemDescpription) {
        this.itemDescpription = itemDescpription;
    }


    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }



}
