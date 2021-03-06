package main.menus;

import main.MyRunnable;
import main.UI.UIObject;
import main.UI.UIPrinter;
import main.UI.UIScanner;

import java.util.Map;
import java.util.function.Function;

public interface IMenu extends UIObject, MyRunnable {
//    String header();
//    Map<Integer, String> options();
//    Function select(Enum option);
    void showMenu(UIPrinter printer);
    void readInput(UIScanner scanner);
    MyRunnable execute();
    boolean isValidInput();

    @Override
    default MyRunnable run(UIPrinter printer, UIScanner scanner) {
        showMenu(printer);
        readInput(scanner);
        if(isValidInput())
            return execute();
        return this;
    }
}
