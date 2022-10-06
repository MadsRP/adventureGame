package org.example;

public class Weapon extends Item{

    private int damage;
    public Weapon(String itemName, String itemDescription, Edible edible, int damage){
        super(itemName,itemDescription,edible);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

}
