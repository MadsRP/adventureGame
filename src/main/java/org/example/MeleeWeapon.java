package org.example;

public class MeleeWeapon extends Weapon{
    public MeleeWeapon(String itemName, String itemDescription, Edible edible, int damage, WeaponType weaponType) {
        super(itemName, itemDescription, edible, damage, weaponType);
    }

    @Override
    public void setAmmo(int ammo) {

    }

    @Override
    public int getAmmo() {

        return 0;
    }

}
