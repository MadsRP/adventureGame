package org.example;

public class AdventureMechanics {


    private Map map = new Map();
    private Player player = new Player(map.getFirstRoom());

    public void playerMovement(String direction){
        player.movement(direction);
    }

    public void attackMonster(Monster monster){
        player.attack(monster);
    }
    public void attackPlayer(Monster monster, Player player){
        monster.attack(monster, player);
    }


    public boolean isMonsterDead(Monster currentMonster){
        Boolean isMonsterDead = false;
        if (currentMonster.getHealth()<=0){
            player.getCurrentRoom().getMonsterList().remove(currentMonster);
            player.getCurrentRoom().getItemList().add(currentMonster.getWeapon());
            isMonsterDead = true;
        }
        return isMonsterDead;
    }

    public boolean isPlayerDead(Player player){
        Boolean isPlayerDead = false;
        if (player.getHealth()<=0){
            isPlayerDead = true;
        }
        return isPlayerDead;
    }

    public boolean alreadyVisited() {
        boolean alreadyVisited;
        if (!map.getAlreadyVisited().contains(player.getCurrentRoom().getRoomNumber())) {
            alreadyVisited = false;
            map.getAlreadyVisited().add(player.getCurrentRoom().getRoomNumber());
        } else
        {
            alreadyVisited = true;
        }
        return alreadyVisited;
    }


    public int getCurrentHealth(){
        return player.getHealth();
    }

    public Map getMap() {
        return map;
    }

    public Player getPlayer() {
        return player;
    }

}



