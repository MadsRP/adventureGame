package org.example;

public class Food extends Item{
    int health;

    public Food(){
    }
    public Food(String itemName, String itemDescription, int health){
        super(itemName, itemDescription);
        this.health = health;
    }
    public Food(String itemName){
    }

}
