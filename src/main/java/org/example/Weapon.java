package org.example;

public abstract class Weapon extends Item{

    private int damage;
    private WeaponType weaponType;
    public Weapon(String itemName, String itemDescription, Edible edible, int damage, WeaponType weaponType){
        super(itemName,itemDescription,edible);
        this.damage = damage;
        this.weaponType = weaponType;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public WeaponType getWeaponType(){
        return weaponType;
    }
    public abstract void setAmmo(int ammo);
    public abstract int getAmmo();

}
