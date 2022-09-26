package org.example;

public class Room {

    private int roomNumber;
    private int currentRoom;
    private int northConnectingRoom;
    private int southConnectingRoom;
    private int eastConnectingRoom;
    private int westConnectingRoom;
    private String description;

    public Room(int roomNumber, String description, int northConnectingRoom, int southConnectingRoom, int eastConnectingRoom, int westConnectingRoom ){
        this.roomNumber = roomNumber;
        this.description = description;
        this.northConnectingRoom = northConnectingRoom;
        this.southConnectingRoom = southConnectingRoom;
        this.eastConnectingRoom = eastConnectingRoom;
        this.westConnectingRoom = westConnectingRoom;
    }
    public Room() {
    }



    public int getNorthConnectingRoom() {
        return northConnectingRoom;
    }

    public void setNorthConnectingRoom(int northConnectingRoom) {
        this.northConnectingRoom = northConnectingRoom;
    }

    public int getSouthConnectingRoom() {
        return southConnectingRoom;
    }

    public void setSouthConnectingRoom(int southConnectingRoom) {
        this.southConnectingRoom = southConnectingRoom;
    }

    public int getEastConnectingRoom() {
        return eastConnectingRoom;
    }

    public void setEastConnectingRoom(int eastConnectingRoom) {
        this.eastConnectingRoom = eastConnectingRoom;
    }

    public int getWestConnectingRoom() {
        return westConnectingRoom;
    }

    public void setWestConnectingRoom(int westConnectingRoom) {
        this.westConnectingRoom = westConnectingRoom;
    }

    public int getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(int currentRoom) {
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



//        switch (getRoomNumber()) {
//            case 1:
//                System.out.println("You cannot move north or west.");
//                setRoomNumber(1);
//            case 2:
//                System.out.println("You cannot move north or south");
//                setRoomNumber(2);
//            case 3:
//                System.out.println("You cannot move north or east");
//                setRoomNumber(3);
//            case 4:
//                System.out.println("You cannot move east or west");
//                setRoomNumber(4);
//            case 5:
//                System.out.println("You cannot move north, east or west");
//                setRoomNumber(5);
//            case 6:
//                System.out.println("You cannot move east or west");
//                setRoomNumber(6);
//            case 7:
//                System.out.println("You cannot move west or south");
//                setRoomNumber(7);
//            case 8:
//                System.out.println("You cannot move south");
//                setRoomNumber(8);
//            case 9:
//                System.out.println("You cannot move east or south");
//                setRoomNumber(9);

}
