package org.example;

import java.util.ArrayList;
import java.util.Random;

public class ItemList {

    private ArrayList <Item> numberOfRemovedItems = new ArrayList<>();
    private ArrayList <Item> listOfItems = new ArrayList<>();
    private Food food = new Food();
    private Item item = new Item();
    private Item leatherScrap = new Item("Leather", "a piece of leather", Edible.NON_EDIBLE);
    private Item paper = new Item("Paper", "a piece of paper", Edible.NON_EDIBLE);
    private Item candle = new Item("Candle", "a slightly used candle", Edible.NON_EDIBLE);
    private Food redApple = new Food("Apple", "a red apple that heals 30 health",Edible.EDIBLE ,30);
    private Food rottenApple = new Food("Poison", "a rotten red apple",Edible.EDIBLE ,-30);
    private Food starFruit = new Food("Starfruit", "a beautiful golden apple", Edible.EDIBLE,100);
    private MeleeWeapon dagger = new MeleeWeapon("Dagger", "a small dagger that deals 10 damage", Edible.NON_EDIBLE, 10, WeaponType.MELEE_WEAPON);
    private MeleeWeapon scimitar = new MeleeWeapon("Scimitar", "a scimitar, that deals 35 damage", Edible.NON_EDIBLE, 40, WeaponType.MELEE_WEAPON);
    private RangedWeapon bow = new RangedWeapon("Bow", "a small bow, that deals 10 damage", Edible.NON_EDIBLE, 10, WeaponType.RANGED_WEAPON, 5);
    private RangedWeapon crossbow = new RangedWeapon("Crossbow", "a crossbow, that deals 15 damage", Edible.NON_EDIBLE, 15, WeaponType.RANGED_WEAPON, 5);



    public ItemList(){
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getSword() {
        return leatherScrap;
    }

    public void setSword(Item sword) {
        this.leatherScrap = sword;
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

    public MeleeWeapon getDagger() {
        return dagger;
    }

    public void setDagger(MeleeWeapon dagger) {
        this.dagger = dagger;
    }

    public MeleeWeapon getScimitar() {
        return scimitar;
    }

    public void setScimitar(MeleeWeapon scimitar) {
        this.scimitar = scimitar;
    }

    public RangedWeapon getBow() {
        return bow;
    }

    public void setBow(RangedWeapon bow) {
        this.bow = bow;
    }

    public RangedWeapon getCrossbow() {
        return crossbow;
    }

    public void setCrossbow(RangedWeapon crossbow) {
        this.crossbow = crossbow;
    }


}
