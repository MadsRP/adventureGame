package org.example;

public class Room {

    private int roomNumber;
    private Room currentRoom;
    private Room northConnectingRoom;
    private Room southConnectingRoom;
    private Room eastConnectingRoom;
    private Room westConnectingRoom;
    private String description;
    private String descriptionShort;

    public Room(Room northConnectingRoom, Room southConnectingRoom, Room eastConnectingRoom, Room westConnectingRoom ){
        this.northConnectingRoom = northConnectingRoom;
        this.southConnectingRoom = southConnectingRoom;
        this.eastConnectingRoom = eastConnectingRoom;
        this.westConnectingRoom = westConnectingRoom;
    }

    public Room(int roomNumber, String description, String descriptionShort)
    {
        this.roomNumber = roomNumber;
        this.description = description;
        this.descriptionShort = descriptionShort;
    }

    public Room(int roomNumber){
        this.roomNumber = roomNumber;
    }
    public Room() {
    }




    public String getDescriptionShort() {
        return descriptionShort;
    }

    public void setDescriptionShort(String descriptionShort) {
        this.descriptionShort = descriptionShort;
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

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

}