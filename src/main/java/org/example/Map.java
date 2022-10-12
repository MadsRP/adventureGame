package org.example;

import java.util.ArrayList;

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
    private ArrayList<Monster> monsterListRoom1 = new ArrayList<>();
    private ArrayList<Monster> monsterListRoom2 = new ArrayList<>();
    private ArrayList<Monster> monsterListRoom3 = new ArrayList<>();
    private ArrayList<Monster> monsterListRoom4 = new ArrayList<>();
    private ArrayList<Monster> monsterListRoom5 = new ArrayList<>();
    private ArrayList<Monster> monsterListRoom6 = new ArrayList<>();
    private ArrayList<Monster> monsterListRoom7 = new ArrayList<>();
    private ArrayList<Monster> monsterListRoom8 = new ArrayList<>();
    private ArrayList<Monster> monsterListRoom9 = new ArrayList<>();
    private org.example.itemList itemList = new itemList();
    private Monster monster = new Monster();

    public ArrayList<Monster> getMonsterList() {
        return monsterList;
    }

    private ArrayList<Monster> monsterList = new ArrayList<>();
    private Room currentRoom = new Room();
    private Room room1 = new Room(1, "A Forest clearing with two gates south and east.", "the forest clearing.");
    private Room room2 = new Room(2, "A Small courtyard with a well.", "the well.");
    private Room room3 = new Room(3, "A courtyard with a moonlit sculpture.", "the courtyard with a sculpture.");
    private Room room4 = new Room(4, "A small shack with random shit.", "the shack.");
    private Room room5 = new Room(5, "the patio of the house.", "the patio.");
    private Room room6 = new Room(6, "A small garden full of dangerous looking plants.", "the garden.");
    private Room room7 = new Room(7, "A small field with a scarecrow.", "the field.");
    private Room room8 = new Room(8, "A courtyard with set of stairs leading to house.", "the stairs.");
    private Room room9 = new Room(9, "A small shrine.", "the shrine.");
    private Room firstRoom = room1;
    private Monster skeleton = new Monster("Skeleton", "a spooky, scary skeleton", 50);
    private Monster gargoyle = new Monster("Gargoyle", "a gargoyle with thick gray skin and pointy horns", 90);
    private Monster zombie = new Monster("Zombie", "an undead human being", 30);


    public Map(){
    }


    public void map() {
        zombie.setWeapon(itemList.getDagger());
        gargoyle.setWeapon(itemList.getClaws());
        skeleton.setWeapon(itemList.getScimitar());

        monsterListRoom1.add(zombie);
        monsterListRoom2.add(zombie);
        monsterListRoom3.add(zombie);
        monsterListRoom5.add(gargoyle);
        monsterListRoom4.add(skeleton);
        monsterListRoom6.add(skeleton);
        monsterListRoom9.add(skeleton);

        room1.setEastConnectingRoom(room2);
        room1.setSouthConnectingRoom(room4);
        room1.setItemList(itemListRoom1);
        itemListRoom1.add(itemList.getLeatherScrap());
        itemListRoom1.add(itemList.getPaper());
        itemListRoom1.add(itemList.getCandle());
        itemListRoom1.add(itemList.getRedApple());
        room1.setMonsterList(monsterListRoom1);


        room2.setEastConnectingRoom(room3);
        room2.setWestConnectingRoom(room1);
        room2.setItemList(itemListRoom2);
        itemListRoom2.add(itemList.getRedApple());
        itemListRoom2.add(itemList.getRedApple());
        itemListRoom2.add(itemList.getPaper());
        itemListRoom2.add(itemList.getPaper());
        room2.setMonsterList(monsterListRoom2);

        room3.setWestConnectingRoom(room2);
        room3.setSouthConnectingRoom(room6);
        room3.setItemList(itemListRoom3);
        itemListRoom3.add(itemList.getPaper());
        room3.setMonsterList(monsterListRoom3);


        room4.setNorthConnectingRoom(room1);
        room4.setSouthConnectingRoom(room7);
        room4.setItemList(itemListRoom4);
        itemListRoom4.add(itemList.getRedApple());
        room4.setMonsterList(monsterListRoom4);

        room5.setSouthConnectingRoom(room8);
        room5.setItemList(itemListRoom5);
        itemListRoom5.add(itemList.getStarFruit());
        itemListRoom5.add(itemList.getStarFruit());
        itemListRoom5.add(itemList.getStarFruit());
        room5.setMonsterList(monsterListRoom5);


        room6.setNorthConnectingRoom(room3);
        room6.setSouthConnectingRoom(room9);
        room6.setItemList(itemListRoom6);
        itemListRoom6.add(itemList.getLeatherScrap());
        itemListRoom6.add(itemList.getCandle());
        room6.setMonsterList(monsterListRoom6);

        room7.setNorthConnectingRoom(room4);
        room7.setEastConnectingRoom(room8);
        room7.setItemList(itemListRoom7);
        itemListRoom7.add(itemList.getPaper());
        itemListRoom7.add(itemList.getPaper());
        room7.setMonsterList(monsterListRoom7);

        room8.setNorthConnectingRoom(room5);
        room8.setWestConnectingRoom(room7);
        room8.setEastConnectingRoom(room9);
        room8.setItemList(itemListRoom8);
        itemListRoom8.add(itemList.getPaper());
        itemListRoom8.add(itemList.getCandle());
        room8.setMonsterList(monsterListRoom8);

        room9.setWestConnectingRoom(room8);
        room9.setNorthConnectingRoom(room6);
        room9.setItemList(itemListRoom9);
        itemListRoom9.add(itemList.getPaper());
        room9.setMonsterList(monsterListRoom9);
    }

    private ArrayList<Integer> alreadyVisited = new ArrayList<>();

    public ArrayList<Integer> getAlreadyVisited() {
        return alreadyVisited;
    }

    public Room getFirstRoom() {
        return firstRoom;
    }


}
