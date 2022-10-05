package org.example;

import java.util.ArrayList;
import java.util.Random;

public class ItemList {

    private ArrayList <Item> numberOfRemovedItems = new ArrayList<>();
    private ArrayList <Item> listOfItems = new ArrayList<>();
    private Food food = new Food();
    private Item item = new Item();
    private Item sword = new Item("Sword");
    private Item paper = new Item("Paper");
    private Item candle = new Item("Candle");
    private Food redApple = new Food("Apple", "a red apple",Edible.EDIBLE ,30);
    private Food rottenApple = new Food("Poison", "a rotten red apple",Edible.EDIBLE ,-30);
    private Food starFruit = new Food("Starfruit", "a beautiful golden apple", Edible.EDIBLE,100);



    public ItemList(){
        itemList();
    }
    public void itemList() {
        listOfItems.add(sword);
        listOfItems.add(paper);
        listOfItems.add(candle);
        sword.setEdible(Edible.NON_EDIBLE);
        paper.setEdible(Edible.NON_EDIBLE);
        candle.setEdible(Edible.NON_EDIBLE);
    }
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getSword() {
        return sword;
    }

    public void setSword(Item sword) {
        this.sword = sword;
    }

    public Item getPaper() {
        return paper;
    }

    public void setPaper(Item paper) {
        this.paper = paper;
    }

    public Item getCandle() {
        return candle;
    }

    public void setCandle(Item candle) {
        this.candle = candle;
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

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
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

    public Food getStarFruit() {
        return starFruit;
    }

    public void setStarFruit(Food starFruit) {
        this.starFruit = starFruit;
    }


}
