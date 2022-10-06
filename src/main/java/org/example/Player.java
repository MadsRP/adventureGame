package org.example;


import java.util.ArrayList;

public class Player {


    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();
    private boolean wrongDirection;
    private ItemList inventoryItems = new ItemList();
    private int totalHealth = 100;
    private boolean itemExchange = true;
    private Weapon currentWeapon;
    private boolean edibleItem = true;

    public Player(Room currentRoom, ArrayList inventory) {
        this.currentRoom = currentRoom;
        this.inventory = inventory;
    }

    public Player(Weapon currentWeapon){
        this.currentWeapon = currentWeapon;
    }
    public Player(int health) {
        this.totalHealth = health;
    }

    public Player() {
    }

    public void player() {
        inventory.add(inventoryItems.getPaper());
        inventory.add(inventoryItems.getSword());
        inventory.add(inventoryItems.getRedApple());
        inventory.add(inventoryItems.getStarFruit());
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
        for (Item item : currentRoom.getItemList()) {
            if (item.getItemName().equalsIgnoreCase(userInputs)) {
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
        for (Item item : inventory) {
            if (item.getItemName().toLowerCase().equalsIgnoreCase(userInputs)) {
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

    public void eatItem(String userInputs) {
        Item eatItem = null;
        Food food = null;
        int healing = 0;
        for (Item item : inventory) {
            if (item.getItemName().toLowerCase().equalsIgnoreCase(userInputs)) {
                eatItem = item;
                switch (eatItem.getEdible()) {
                    case EDIBLE:
                        food = (Food) eatItem;
                        healing = food.getHealing();
                        itemExchange = true;
                        break;
                    case NON_EDIBLE:
                        edibleItem = false;
                        break;
                    default:
                        eatItem = null;
                        break;
                }
            }
        }
        inventory.remove(food);
        setTotalHealth(totalHealth + healing);

        if (eatItem == null) {
            for (Item item : currentRoom.getItemList()) {
                if (item.getItemName().equalsIgnoreCase(userInputs)) {
                    eatItem = item;
                    switch (eatItem.getEdible()) {
                        case EDIBLE:
                            food = (Food) eatItem;
                            healing = food.getHealing();
                            itemExchange = true;
                            break;
                        case NON_EDIBLE:
                            edibleItem = false;
                            break;
                        default:
                            eatItem = null;
                            break;
                    }
                }
            }
            currentRoom.getItemList().remove(food);
            setTotalHealth(totalHealth + healing);
        }


        if (eatItem == null) {
            itemExchange = false;
        }
    }

    public void equipWepaon(String userInputs){

    }
    public void attack(){

    }

    public ItemList getInventoryItems() {

        return inventoryItems;
    }

    public void setInventoryItems(ItemList inventoryItems) {
        this.inventoryItems = inventoryItems;
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

    public int getTotalHealth() {
        return totalHealth;
    }

    public void setTotalHealth(int totalHealth) {
        this.totalHealth = totalHealth;
    }

    public boolean isItemExchange() {
        return itemExchange;
    }

    public void setItemExchange(boolean itemExchange) {
        this.itemExchange = itemExchange;
    }

    public boolean isEdibleItem() {
        return edibleItem;
    }

    public void setEdibleItem(boolean edibleItem) {
        this.edibleItem = edibleItem;
    }


}
