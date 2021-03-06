package main.menus;

import main.MyRunnable;
import main.UI.UIObject;
import main.UI.UIPrinter;
import main.UI.UIScanner;

public interface IMenu extends UIObject, MyRunnable {
    String getHeader();
    boolean isValidInput();
    MyRunnable apply();

    @Override
    default MyRunnable run(UIPrinter printer, UIScanner scanner) {
        printer.print(this);
        scanner.scan(this);

        if(isValidInput())
            return apply();

        return this;
    }
}
