package org.example;

public class RangedWeapon extends Weapon{

    private int ammo;
    public RangedWeapon(String itemName, String itemDescription, Edible edible, int damage, int ammo) {
        super(itemName, itemDescription, edible, damage);
        this.ammo= ammo;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }


}
