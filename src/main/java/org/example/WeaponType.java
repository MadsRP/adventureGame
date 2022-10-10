package org.example;

enum WeaponType {
    MELEE_WEAPON("MELEE_WEAPON"),
    RANGED_WEAPON("RANGED_WEAPON");

    private final String weaponType;

    private WeaponType(String weaponType){
        this.weaponType = weaponType;
    }

    public String getWeaponType(){
        return weaponType;
    }
}
