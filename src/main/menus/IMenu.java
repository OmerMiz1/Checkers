package main.menus;

import main.UI.UIObject;

public interface IMenu extends UIObject {
    void showMenu();
    void readInput();
    void execute();
    boolean validInput();
    boolean isRunning();

    default void start() {
        while(isRunning()) {
            showMenu();
            readInput();
            if(validInput())
                execute();
        }
    }
}
