package org.example;

import java.util.ArrayList;

public class AdventureMechanics {


    private Map map = new Map();
    private ItemList itemList = new ItemList();
    private Player player = new Player(map.getFirstRoom());

    public void playerMovement(String direction){
        player.movement(direction);
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

    public void setInventory(){
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ItemList getItemList() {
        return itemList;
    }

    public void setItemList(ItemList itemList) {
        this.itemList = itemList;
    }

}



