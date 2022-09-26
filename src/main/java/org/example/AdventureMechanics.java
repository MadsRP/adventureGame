package org.example;

import java.util.ArrayList;

public class AdventureMechanics {
    String direction = "";
    private ArrayList<Room> map;
    int newRoom = 0;
    Boolean keepGoing = true;
    Room room = new Room();

    public AdventureMechanics() {
        this.map = new ArrayList<>();
        map.add(new Room(0, "Forest clearing with two gates south and east", -1, 3, 1, -1));
        map.add(new Room(1, "Small courtyard with a well", -1, -1, 2, 0));
        map.add(new Room(2, "A moonlit sculpture", -1, 1, -1, 1));
        map.add(new Room(3, "A small shack with random shit", 0, 6, -1, -1));
        map.add(new Room(4, "House of the owner", -1, 7, -1, -1));
        map.add(new Room(5, "A small garden full of dangerous looking plants", 2, 8, -1, -1));
        map.add(new Room(6, "A small field with a scarecrow", 3, -1, 7, -1));
        map.add(new Room(7, "A courtyard with set of stairs leading to house", 4, -1, 6, 8));
        map.add(new Room(8, "A small shrine", 5, -1, -1, 7));

    }

    public String lookAround() {

        for (Room rooms : map) {
            rooms.getRoomNumber();

        }
        return room.getDescription();
    }

    public void movement() {

        for (Room rooms : map) {
            switch (direction) {
                case "n":
                    if (rooms.getNorthConnectingRoom() >= 0) {
                        System.out.println("You go north");
                        newRoom = rooms.getNorthConnectingRoom();
                    } else if (rooms.getNorthConnectingRoom() == -1) {
                        System.out.println("You cannot go this way");
                    }
                    break;
                case "w":
                    if (rooms.getWestConnectingRoom() >= 0) {
                        System.out.println("You go west");
                        newRoom = rooms.getWestConnectingRoom();
                    } else if (rooms.getWestConnectingRoom() == -1) {
                        System.out.println("You cannot go this way");
                    }
                    break;
                case "e":
                    if (rooms.getEastConnectingRoom() >= 0) {
                        System.out.println("You go east");
                        newRoom = rooms.getEastConnectingRoom();
                    } else if (map.get(0).getEastConnectingRoom() == -1) {
                        System.out.println("You cannot go this way");
                    }
                    break;
                case "s":
                    if (map.get(0).getSouthConnectingRoom() >= 0) {
                        newRoom = rooms.getSouthConnectingRoom();
                        System.out.println("You go south");
                    } else if (map.get(0).getSouthConnectingRoom() == -1) {
                        System.out.println("You cannot go this way");
                    }
                    break;

            }
            rooms.setCurrentRoom(newRoom);
            System.out.println("You are in room: " + rooms.getRoomNumber());
        }

    }
}



