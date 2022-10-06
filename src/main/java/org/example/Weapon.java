package org.example;

public class Weapon extends Item{
    int damage;
    public Weapon(String itemName, String itemDescription, Edible edible, int damage){
        super(itemName,itemDescription,edible);
        this.damage = damage;
    }

    public void attack(){

    }

    public void equip(){

    }

}
