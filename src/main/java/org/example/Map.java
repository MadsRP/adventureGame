package org.example;

import java.util.ArrayList;

public class Map {
    //private ArrayList<Integer> alreadyVisited = new ArrayList<>();


    public Room getFirstRoom() {
        return firstRoom;
    }

    public void setFirstRoom(Room firstRoom) {
        this.firstRoom = firstRoom;
    }

    Room room1 = new Room(1, "The Forest clearing with two gates south and east.", "the forest clearing.");
    Room room2 = new Room(2, "A Small courtyard with a well.", "the well.");
    Room room3 = new Room(3, "A courtyard with a moonlit sculpture.", "the courtyard with a sculpture.");
    Room room4 = new Room(4, "A small shack with random shit.", "the shack.");
    Room room5 = new Room(5, "the patio of the house.", "the patio.");
    Room room6 = new Room(6, "A small garden full of dangerous looking plants.", "the garden.");
    Room room7 = new Room(7, "A small field with a scarecrow.", "the field.");
    Room room8 = new Room(8, "A courtyard with set of stairs leading to house.", "the stairs.");
    Room room9 = new Room(9, "A small shrine.", "the shrine.");
    Room firstRoom = room1;

    public void map(){

        room1.setEastConnectingRoom(room2);
        room1.setSouthConnectingRoom(room4);

        room2.setEastConnectingRoom(room3);
        room2.setWestConnectingRoom(room1);

        room3.setWestConnectingRoom(room2);
        room3.setSouthConnectingRoom(room6);

        room4.setNorthConnectingRoom(room1);
        room4.setSouthConnectingRoom(room7);

        room5.setSouthConnectingRoom(room8);

        room6.setNorthConnectingRoom(room3);
        room6.setSouthConnectingRoom(room9);

        room7.setNorthConnectingRoom(room4);
        room7.setEastConnectingRoom(room8);

        room8.setNorthConnectingRoom(room5);
        room8.setWestConnectingRoom(room7);
        room8.setEastConnectingRoom(room9);

        room9.setWestConnectingRoom(room8);
        room9.setNorthConnectingRoom(room6);

    }

    public void itemList(){
        Item item1 = new Item("Dagger", "A small dagger with a golden hilt");
    }

}
