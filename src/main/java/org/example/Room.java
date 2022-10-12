package org.example;

import java.util.ArrayList;

public class Room {

    private int roomNumber;
    private Room currentRoom;
    private Room northConnectingRoom;
    private Room southConnectingRoom;
    private Room eastConnectingRoom;
    private Room westConnectingRoom;
    private String description;
    private String descriptionShort;
    private Item item;
    private ArrayList<Item> itemList = new ArrayList<>();
    public ArrayList<Monster> getMonsterList() {
        return monsterList;
    }

    public void setMonsterList(ArrayList<Monster> monsterList) {
        this.monsterList = monsterList;
    }

    private ArrayList<Monster> monsterList = new ArrayList<>();


    public Room(Room northConnectingRoom, Room southConnectingRoom, Room eastConnectingRoom, Room westConnectingRoom, ArrayList itemList, ArrayList monsterList) {
        this.northConnectingRoom = northConnectingRoom;
        this.southConnectingRoom = southConnectingRoom;
        this.eastConnectingRoom = eastConnectingRoom;
        this.westConnectingRoom = westConnectingRoom;
        this.itemList = itemList;
        this.monsterList = monsterList;
    }

    public Room(Room northConnectingRoom, Room southConnectingRoom, Room eastConnectingRoom, Room westConnectingRoom) {
        this.northConnectingRoom = northConnectingRoom;
        this.southConnectingRoom = southConnectingRoom;
        this.eastConnectingRoom = eastConnectingRoom;
        this.westConnectingRoom = westConnectingRoom;
    }

    public Room(Item item) {
        this.item = item;
    }

    public Room(int roomNumber, String description, String descriptionShort) {
        this.roomNumber = roomNumber;
        this.description = description;
        this.descriptionShort = descriptionShort;
    }

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Room(ArrayList itemList) {
        this.itemList = itemList;
    }

    public Room() {
    }

    public String getDescriptionShort() {
        return descriptionShort;
    }

    public Room getNorthConnectingRoom() {
        return northConnectingRoom;
    }

    public void setNorthConnectingRoom(Room northConnectingRoom) {
        this.northConnectingRoom = northConnectingRoom;
    }

    public Room getSouthConnectingRoom() {
        return southConnectingRoom;
    }

    public void setSouthConnectingRoom(Room southConnectingRoom) {
        this.southConnectingRoom = southConnectingRoom;
    }

    public Room getEastConnectingRoom() {
        return eastConnectingRoom;
    }

    public void setEastConnectingRoom(Room eastConnectingRoom) {
        this.eastConnectingRoom = eastConnectingRoom;
    }

    public Room getWestConnectingRoom() {
        return westConnectingRoom;
    }

    public void setWestConnectingRoom(Room westConnectingRoom) {
        this.westConnectingRoom = westConnectingRoom;
    }

    public String getDescription() {
        return description;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }
}