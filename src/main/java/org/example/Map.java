package org.example;

import java.util.ArrayList;

public class Map {

    private ArrayList<Room> itemList = new ArrayList<>();
    Room currentRoom = new Room();
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


    public void map() {

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


    Item item1 = new Item("i1","id1");
    Item item2 = new Item("i2","id2");
    Item item3 = new Item("i3","id3");
    Item item4 = new Item("i4","id4");
    Item item5 = new Item("i5","id5");
    Item item6 = new Item("i6","id6");
    Item item7 = new Item("i7","id7");
    Item item8 = new Item("i8","id8");





    public ArrayList<Room> itemsInRooms() {
        item1.setRoom(room1);
        item2.setRoom(room1);
        item3.setRoom(room1);
        item4.setRoom(room4);
        item5.setRoom(room5);
        itemList.add(item1.getRoom());
        itemList.add(item2.getRoom());
        itemList.add(item3.getRoom());
        room2.setItem(item2);
        room3.setItem(item3);
        room4.setItem(item4);
        return itemList;
    }

    public String itemListForRooms(){
        String itemListForRooms = null;
        for (Room items: itemsInRooms()){
            itemListForRooms = "\n" +items.getItem().getItemName(currentRoom);
        }
        return itemListForRooms;
    }

    private ArrayList<Integer> alreadyVisited = new ArrayList<>();

    public ArrayList<Integer> getAlreadyVisited() {
        return alreadyVisited;
    }

    public void setAlreadyVisited(ArrayList<Integer> alreadyVisited) {
        this.alreadyVisited = alreadyVisited;
    }
    public Map() {
        map();
    }

    public Room getFirstRoom() {
        return firstRoom;
    }

    public void setFirstRoom(Room firstRoom) {
        this.firstRoom = firstRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

}
