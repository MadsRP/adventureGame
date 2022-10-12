package org.example;

public class Item {

    private String itemName;
    private String itemDescription;
    private Room room = new Room();
    private Room currentRoom = new Room();
    private Edible edible;

    public Item(String itemName, String itemDescription, Edible edible){
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.edible = edible;
    }
    public Item(String itemName, String itemDescription){
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }
    public Item(String itemName){
        this.itemName = itemName;
    }
    public Item(Edible edible){
        this.edible = edible;
    }
    public Item(){

    }
    public Item(Room currentRoom){
        this.currentRoom = currentRoom;
    }

    public String getItemName() {
        return itemName;
    }
    public String getItemDescription() {
        return itemDescription;
    }
    public Edible getEdible() {
        return edible;
    }

}
