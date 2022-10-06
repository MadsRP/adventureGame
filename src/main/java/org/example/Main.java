package org.example;

public class Main {


    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.getAm().getMap().map();
        ui.getAm().getPlayer().player();
        ui.menuText();
        ui.start();

    }
}