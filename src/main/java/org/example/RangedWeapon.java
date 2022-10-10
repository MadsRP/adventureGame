package org.example;

public class RangedWeapon extends Weapon{

    private int ammo;

    public RangedWeapon(String itemName, String itemDescription, Edible edible, int damage, WeaponType weaponType, int ammo) {
        super(itemName, itemDescription, edible, damage, weaponType);
        this.ammo = ammo;
    }
    @Override
    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }


}
