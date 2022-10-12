package org.example;


import java.util.ArrayList;

public class Player {


    private int health = 100;
    private int currentAmmo;
    private boolean itemExchange = true;
    private boolean wrongDirection;
    private boolean edibleItem = true;
    private boolean rangedWeaponFire = false;
    private boolean meleeWeapon;
    private Room currentRoom;
    private Weapon currentWeapon;
    private ItemList inventoryItems = new ItemList();
    private ArrayList<Item> inventory = new ArrayList<>();


    public Player(Room currentRoom, ArrayList inventory) {
        this.currentRoom = currentRoom;
        this.inventory = inventory;
    }

    public Player(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    public Player(int health) {
        this.health = health;
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
            wrongDirection = false;
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
        setHealth(health + healing);
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
        setHealth(health + healing);
        if (eatItem == null) {
            itemExchange = false;
        }
        if (health>100){
            health = 100;
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

    public void useWeapon() {
        if (currentWeapon != null) {
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

    public void attack(Monster monster){
        monster.setHealth(monster.getHealth()-currentWeapon.getDamage());
    }

    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isItemExchange() {
        return itemExchange;
    }

    public boolean isEdibleItem() {
        return edibleItem;
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public boolean isRangedWeaponFire() {
        return rangedWeaponFire;
    }

    public int getCurrentAmmo() {
        return currentAmmo;
    }

    public boolean isMeleeWeapon() {
        return meleeWeapon;
    }


}
