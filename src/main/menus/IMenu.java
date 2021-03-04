package main.menus;

import main.IO.IPrintable;
import main.IO.IPrinter;

public interface IMenu extends IPrintable {
    void showMenu(IPrinter printer);
    void readInput(IPrinter printer);
    void execute();
    boolean validInput();
    boolean isRunning();

    default void start(IPrinter printer) {
        while(isRunning()) {
            showMenu(printer);
            readInput(printer);
            if(validInput())
                execute();
        }
    }
}
