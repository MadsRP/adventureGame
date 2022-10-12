package org.example;

public class Monster {

    private String type;
    private Weapon weapon;
    private String description;
    private int health;

    public Monster(){
    }

    public void attack(Monster monster, Player player){
        player.setHealth(player.getHealth()-weapon.getDamage());
    }



    public Monster (Weapon weapon){
        this.weapon = weapon;
    }
    public Monster (String type, String description, int health){
        this.type = type;
        this.description = description;
        this.health = health;
    }

    public Monster (String type, String description, int health, Weapon weapon){
        this.type = type;
        this.description = description;
        this.health = health;
        this.weapon = weapon;
    }


    public String getDescription() {
        return description;
    }
    public String getType() {
        return type;
    }

    public int getHealth() {
        return health;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setHealth(int health) {
        this.health = health;
    }

}
