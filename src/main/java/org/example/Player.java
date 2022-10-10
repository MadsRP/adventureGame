package org.example;


import java.util.ArrayList;

public class Player {


    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();
    private boolean wrongDirection;
    private ItemList inventoryItems = new ItemList();
    private int totalHealth = 100;
    private int damage;
    private boolean itemExchange = true;
    private Weapon currentWeapon;
    private boolean edibleItem = true;
    private RangedWeapon ranged;
    private int currentAmmo;
    private boolean rangedWeaponFire = false;
    private Item eatItem;
    private Food food;
    private int healing;

    public boolean isMeleeWeapon() {
        return meleeWeapon;
    }

    private boolean meleeWeapon;

    public Player(Room currentRoom, ArrayList inventory) {
        this.currentRoom = currentRoom;
        this.inventory = inventory;
    }

    public Player(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    public Player(int health) {
        this.totalHealth = health;
    }

    public Player() {
    }

    public void player() {
        inventory.add(inventoryItems.getPaper());
        inventory.add(inventoryItems.getDagger());
        inventory.add(inventoryItems.getCrossbow());
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
        }
        currentRoom.getItemList().remove(food);
        setTotalHealth(totalHealth + healing);
        if (eatItem == null) {
            itemExchange = false;
        }
    }

    public String inspectItem(String userInputs) {
        Item inspectItem = null;
        for (Item item : inventory) {
            if (item.getItemName().toLowerCase().equalsIgnoreCase(userInputs)) {
                inspectItem = item;
            }
        }

        if (inspectItem == null) {
            for (Item item : currentRoom.getItemList()) {
                if (item.getItemName().equalsIgnoreCase(userInputs)) {
                    inspectItem = item;
                }
            }
        }
        if (inspectItem == null) {
            itemExchange = false;
            return null;
        }

        return inspectItem.getItemDescription();

    }

    public void equipWeapon(String userInputs) {
        Item equipItem;
        Weapon weapon;
        if (currentWeapon != null) {
            inventory.add(currentWeapon);
        }
        for (Item item : inventory) {
            if (item.getItemName().toLowerCase().equalsIgnoreCase(userInputs)) {
                equipItem = item;
                if (equipItem instanceof Weapon) {
                    weapon = (Weapon) equipItem;
                    currentWeapon = weapon;
                    itemExchange = true;
                }
            }

            if (currentWeapon == null) {
                itemExchange = false;
            }
        }
        inventory.remove(currentWeapon);
    }

    public void attack() {
        if (currentWeapon != null) {
            damage = currentWeapon.getDamage();
            switch (currentWeapon.getWeaponType()) {
                case RANGED_WEAPON:
                    if (currentWeapon.getAmmo() > 0) {
                        rangedWeaponFire = true;
                        currentAmmo = currentWeapon.getAmmo() - 1;
                        currentWeapon.setAmmo(currentAmmo);
                    } else {
                        rangedWeaponFire = false;
                    }
                    break;
                case MELEE_WEAPON:
                    meleeWeapon = true;
                    break;
            }
        } else {
            itemExchange = false;
        }
    }

    public void getHit() {
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

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isRangedWeaponFire() {
        return rangedWeaponFire;
    }

    public void setRangedWeaponFire(boolean rangedWeaponFire) {
        this.rangedWeaponFire = rangedWeaponFire;
    }

    public int getCurrentAmmo() {
        return currentAmmo;
    }

    public void setCurrentAmmo(int currentAmmo) {
        this.currentAmmo = currentAmmo;
    }


}
