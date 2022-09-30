package org.example;

import java.util.ArrayList;
import java.util.Random;

public class ItemList {
    private ArrayList <Item> numberOfRemovedItems = new ArrayList<>();
    private Item item1 = new Item("1");
    private Item item2 = new Item("2");
    private Item item3 = new Item("3");
    private Item item4 = new Item("4");
    private Item item5 = new Item("5");
    private Item item6 = new Item("6");
    private Item item7 = new Item("7");
    private Item item8 = new Item("8");
    private Item item9 = new Item("9");
    private Item item10 = new Item("10");
    private Item item11 = new Item("11");
    private Item item12 = new Item("12");
    private Item item13 = new Item("13");
    private Item item14 = new Item("14");
    private Item item15 = new Item("15");
    private Item item16 = new Item("16");
    private Item item17 = new Item("17");

    public ItemList(){
        itemList();
    }

    public void itemList() {
        listOfItems.add(item1);
        listOfItems.add(item2);
        listOfItems.add(item3);
        listOfItems.add(item4);
        listOfItems.add(item5);
        listOfItems.add(item6);
        listOfItems.add(item7);
        listOfItems.add(item8);
        listOfItems.add(item9);
        listOfItems.add(item10);
        listOfItems.add(item11);
        listOfItems.add(item12);
        listOfItems.add(item13);
        listOfItems.add(item14);
        listOfItems.add(item15);
        listOfItems.add(item16);
        listOfItems.add(item17);
    }

    public void setListOfItems(ArrayList<Item> listOfItems) {
        this.listOfItems = listOfItems;
    }

    private ArrayList <Item> listOfItems = new ArrayList<>();


    public Item randomItem(){
                    Item randomItem = null;
            Random random = new Random();
            Item removeItem = null;
            int i = numberOfRemovedItems.size();
            int randomNumber = random.nextInt(12 - i);
            for (Item randomItems : listOfItems) {
                randomItems = listOfItems.get(randomNumber);
                removeItem = randomItems;
                randomItem = randomItems;
            }
            numberOfRemovedItems.add(removeItem);
            listOfItems.remove(randomNumber);
            return randomItem;

    }



}
