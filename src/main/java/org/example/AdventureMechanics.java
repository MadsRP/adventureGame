package org.example;

import java.util.ArrayList;

public class AdventureMechanics {


    private Map map = new Map();
    private Player player = new Player(map.getFirstRoom());

    public String lookAround() {
        String lookAround = player.getCurrentRoom().getDescription();
        return lookAround;
    }
    public void playerMovement(String direction){
        player.movement(direction);
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

}



