package org.example;


import java.util.ArrayList;

public class Player {


    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();
    private boolean wrongDirection;
    private ItemList iventoryItems = new ItemList();

    public Player (Room currentRoom, ArrayList inventory){
        this.currentRoom = currentRoom;
        this.inventory = inventory;
    }

    public Player(){
    }
    public void player(){
        inventory.add(iventoryItems.randomItem());
        inventory.add(iventoryItems.randomItem());
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

        if (newRoom == null) {
            wrongDirection = true;
        } else {
            setCurrentRoom(newRoom);
        }
    }
    public void pickUpItem(String userInputs){
        currentRoom = getCurrentRoom();
        if (currentRoom.getItemList().size()>1){
        for (Item pickUpItem: currentRoom.getItemList()) {
            {
                if (userInputs.contains(pickUpItem.itemName))
                    inventory.add(pickUpItem);
            }
        }
        } else{
                inventory.addAll(currentRoom.getItemList());
                currentRoom.getItemList().remove(0);
            }
    }

    public void dropItem(String userInputs){
        currentRoom = getCurrentRoom();
        for (Item dropItem: inventory) {{
            if (userInputs.contains(dropItem.itemName))
                inventory.remove(dropItem);
            currentRoom.getItemList().add(dropItem);
            }
        }
    }

    public ItemList getIventoryItems() {

        return iventoryItems;
    }

    public void setIventoryItems(ItemList iventoryItems) {
        this.iventoryItems = iventoryItems;
    }

    private  ArrayList<Item>inventory(){
        return inventory;
    }

    public Player (Room currentRoom){
        this.currentRoom = currentRoom;
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
