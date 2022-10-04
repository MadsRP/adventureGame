package org.example;

import java.util.ArrayList;
import java.util.Random;

public class ItemList {

    private ArrayList <Item> numberOfRemovedItems = new ArrayList<>();
    private ArrayList <Item> listOfItems = new ArrayList<>();
    private Item item = new Item();
    private Item item1 = new Item("Sword");
    private Item item2 = new Item("Paper");
    private Item item3 = new Item("Candle");

    public Food getRedApple() {
        return redApple;
    }

    public void setRedApple(Food redApple) {
        this.redApple = redApple;
    }

    public Food getRottenApple() {
        return rottenApple;
    }

    public void setRottenApple(Food rottenApple) {
        this.rottenApple = rottenApple;
    }

    public Food getGoldenApple() {
        return goldenApple;
    }

    public void setGoldenApple(Food goldenApple) {
        this.goldenApple = goldenApple;
    }

    private Food redApple = new Food("Apple", "a red apple", 30);
    private Food rottenApple = new Food("Rotten Apple", "a rotten red apple", -30);
    private Food goldenApple = new Food("Golden Apple", "a beautiful golden apple", 100);



    public ItemList(){
        itemList();
    }
    public void itemList() {
        listOfItems.add(item1);
        listOfItems.add(item2);
        listOfItems.add(item3);

    }
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem1() {
        return item1;
    }

    public void setItem1(Item item1) {
        this.item1 = item1;
    }

    public Item getItem2() {
        return item2;
    }

    public void setItem2(Item item2) {
        this.item2 = item2;
    }

    public Item getItem3() {
        return item3;
    }

    public void setItem3(Item item3) {
        this.item3 = item3;
    }



    public ArrayList<Item> getNumberOfRemovedItems() {
        return numberOfRemovedItems;
    }

    public void setNumberOfRemovedItems(ArrayList<Item> numberOfRemovedItems) {
        this.numberOfRemovedItems = numberOfRemovedItems;
    }



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

    public void setListOfItems(ArrayList<Item> listOfItems) {
        this.listOfItems = listOfItems;
    }


}
