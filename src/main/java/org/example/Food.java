package org.example;

public class Food extends Item{

    int healing;

    public Food(){
    }
    public Food(String itemName, String itemDescription, Edible edible, int health){
        super(itemName, itemDescription, edible);
        this.healing = health;
    }
    public Food(String itemName){
    }
    public int getHealing() {
        return healing;
    }

    public void setHealing(int healing) {
        this.healing = healing;
    }

}
