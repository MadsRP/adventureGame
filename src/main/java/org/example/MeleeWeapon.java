package org.example;

public class MeleeWeapon extends Weapon{
    private int ammo = -1;

    public MeleeWeapon(String itemName, String itemDescription, Edible edible, int damage) {
        super(itemName, itemDescription, edible, damage);
    }

    @Override
    public int getAmmo() {
        return -1;
    }

    public void setAmmo(int ammo){
        this.ammo = ammo;
    }
}
