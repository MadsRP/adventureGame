package org.example;

enum Edible {
    EDIBLE("EDIBLE"),
    NON_EDIBLE("NOT EDIBLE"),
    NOT_FOUND("NOT FOUND");

    private final String edible;

    private Edible(String edible){
        this.edible = edible;
    }

    public String getEdible(){
        return edible;
    }
}
