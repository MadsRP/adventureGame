package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Map {


    private ArrayList<Item> itemListRoom1 = new ArrayList<>();
    private ArrayList<Item> itemListRoom2 = new ArrayList<>();
    private ArrayList<Item> itemListRoom3 = new ArrayList<>();
    private ArrayList<Item> itemListRoom4 = new ArrayList<>();
    private ArrayList<Item> itemListRoom5 = new ArrayList<>();
    private ArrayList<Item> itemListRoom6 = new ArrayList<>();
    private ArrayList<Item> itemListRoom7 = new ArrayList<>();
    private ArrayList<Item> itemListRoom8 = new ArrayList<>();
    private ArrayList<Item> itemListRoom9 = new ArrayList<>();
    private ItemList itemList = new ItemList();
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

    public Map(){
    }

    public void map() {

        room1.setEastConnectingRoom(room2);
        room1.setSouthConnectingRoom(room4);
        room1.setItemList(itemListRoom1);

        room2.setEastConnectingRoom(room3);
        room2.setWestConnectingRoom(room1);
        room2.setItemList(itemListRoom2);


        room3.setWestConnectingRoom(room2);
        room3.setSouthConnectingRoom(room6);
        room3.setItemList(itemListRoom3);

        room4.setNorthConnectingRoom(room1);
        room4.setSouthConnectingRoom(room7);
        room4.setItemList(itemListRoom4);

        room5.setSouthConnectingRoom(room8);
        room5.setItemList(itemListRoom5);

        room6.setNorthConnectingRoom(room3);
        room6.setSouthConnectingRoom(room9);
        room6.setItemList(itemListRoom6);

        room7.setNorthConnectingRoom(room4);
        room7.setEastConnectingRoom(room8);
        room7.setItemList(itemListRoom7);

        room8.setNorthConnectingRoom(room5);
        room8.setWestConnectingRoom(room7);
        room8.setEastConnectingRoom(room9);
        room8.setItemList(itemListRoom8);

        room9.setWestConnectingRoom(room8);
        room9.setNorthConnectingRoom(room6);
        room9.setItemList(itemListRoom9);

        for(int randomNumber = new Random().nextInt(2); randomNumber>0;randomNumber--) {
            itemListRoom1.add(itemList.randomItem());
        }

        for(int randomNumber = new Random().nextInt(4); randomNumber>0;randomNumber--) {
            itemListRoom2.add(itemList.randomItem());
        }

        for(int randomNumber = new Random().nextInt(2); randomNumber>0;randomNumber--) {
            itemListRoom3.add(itemList.randomItem());
        }
        for(int randomNumber = new Random().nextInt(3); randomNumber>0;randomNumber--) {
            itemListRoom4.add(itemList.randomItem());
        }
        for(int randomNumber = new Random().nextInt(3); randomNumber>0;randomNumber--) {
            itemListRoom5.add(itemList.randomItem());
        }
        for(int randomNumber = new Random().nextInt(2); randomNumber>0;randomNumber--) {
            itemListRoom6.add(itemList.randomItem());
        }
        for(int randomNumber = new Random().nextInt(3); randomNumber>0;randomNumber--) {
            itemListRoom7.add(itemList.randomItem());
        }
        for(int randomNumber = new Random().nextInt(4); randomNumber>0;randomNumber--) {
            itemListRoom8.add(itemList.randomItem());
        }
        for(int randomNumber = new Random().nextInt(2); randomNumber>0;randomNumber--) {
            itemListRoom9.add(itemList.randomItem());
        }



    }




    private ArrayList<Integer> alreadyVisited = new ArrayList<>();

    public ArrayList<Integer> getAlreadyVisited() {
        return alreadyVisited;
    }

    public void setAlreadyVisited(ArrayList<Integer> alreadyVisited) {
        this.alreadyVisited = alreadyVisited;
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
