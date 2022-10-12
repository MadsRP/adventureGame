package org.example;

public class ItemList {
    private Item leatherScrap = new Item("Leather", "A piece of leather", Edible.NON_EDIBLE);
    private Item paper = new Item("Paper", "A piece of paper", Edible.NON_EDIBLE);
    private Item candle = new Item("Candle", "A slightly used candle", Edible.NON_EDIBLE);
    private Food redApple = new Food("Apple", "A red apple that heals 30 health",Edible.EDIBLE ,30);
    private Food rottenApple = new Food("Poison", "A rotten red apple",Edible.EDIBLE ,-30);
    private Food starFruit = new Food("Starfruit", "A beautiful golden apple", Edible.EDIBLE,100);
    private MeleeWeapon dagger = new MeleeWeapon("Dagger", "A small dagger that deals 10 damage", Edible.NON_EDIBLE, 5, WeaponType.MELEE_WEAPON);
    private MeleeWeapon scimitar = new MeleeWeapon("Scimitar", "A scimitar, that deals 35 damage", Edible.NON_EDIBLE, 40, WeaponType.MELEE_WEAPON);
    private MeleeWeapon claws = new MeleeWeapon("Claws", "Sharp claws of the gargoyle, that deal 40 damage", Edible.NON_EDIBLE, 40, WeaponType.MELEE_WEAPON);
    private RangedWeapon bow = new RangedWeapon("Bow", "A small bow, that deals 10 damage", Edible.NON_EDIBLE, 10, WeaponType.RANGED_WEAPON, 5);
    private RangedWeapon crossbow = new RangedWeapon("Crossbow", "A crossbow, that deals 15 damage", Edible.NON_EDIBLE, 15, WeaponType.RANGED_WEAPON, 5);

    public ItemList(){
    }
    public Item getLeatherScrap() {
        return leatherScrap;
    }

    public Item getPaper() {
        return paper;
    }
    public Item getCandle() {
        return candle;
    }
    public Food getRedApple() {
        return redApple;
    }

    public Food getRottenApple() {
        return rottenApple;
    }

    public Food getStarFruit() {
        return starFruit;
    }

    public MeleeWeapon getDagger() {
        return dagger;
    }

    public MeleeWeapon getScimitar() {
        return scimitar;
    }

    public RangedWeapon getBow() {
        return bow;
    }

    public RangedWeapon getCrossbow() {
        return crossbow;
    }

    public MeleeWeapon getClaws() {
        return claws;
    }


}
