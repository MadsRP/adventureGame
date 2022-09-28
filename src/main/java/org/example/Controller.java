package org.example;

import org.example.UserInterface;

public class Controller {

    public Controller(){
        run();
    }

    public void run() {
        UserInterface ui = new UserInterface();
        ui.menuText();
        ui.start();
    }
}
