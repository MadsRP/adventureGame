package org.example;


import java.util.ArrayList;

public class Player {


    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();
    private boolean wrongDirection;
    private ItemList iventoryItems = new ItemList();
    private int health = 100;
    private boolean itemExchange = true;

    public Player(Room currentRoom, ArrayList inventory) {
        this.currentRoom = currentRoom;
        this.inventory = inventory;
    }

    public Player(int health) {
        this.health = health;
    }

    public Player() {
    }
    public void player() {
        inventory.add(iventoryItems.getItem2());
        inventory.add(iventoryItems.getItem1());
    }
    public String lookAround() {
        String lookAround = currentRoom.getDescription();
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
    public void pickUpItem(String userInputs) {
        Item takeItem = null;
        for(Item item : currentRoom.getItemList()) {
            if (item.getItemName().equalsIgnoreCase(userInputs)){
                takeItem = item;
                itemExchange = true;
            }
            }
        if (takeItem == null) {
            itemExchange = false;
            return;
        }
            inventory.add(takeItem);
            currentRoom.getItemList().remove(takeItem);

    }
    public void dropItem(String userInputs) {
        Item dropItem = null;
        for(Item item : inventory) {
            if (item.getItemName().toLowerCase().equalsIgnoreCase(userInputs)){
                dropItem = item;
                itemExchange = true;
            }
        }
        if (dropItem == null) {
            itemExchange = false;
            return;
        }
        inventory.remove(dropItem);
        currentRoom.getItemList().add(dropItem);
    }
    public void eatItem(String userInputs){

    }

    public ItemList getIventoryItems() {

        return iventoryItems;
    }

    public void setIventoryItems(ItemList iventoryItems) {
        this.iventoryItems = iventoryItems;
    }

    private ArrayList<Item> inventory() {
        return inventory;
    }

    public Player(Room currentRoom) {
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isItemExchange() {
        return itemExchange;
    }

    public void setItemExchange(boolean itemExchange) {
        this.itemExchange = itemExchange;
    }



}
