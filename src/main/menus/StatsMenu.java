package main.menus;

import main.MyRunnable;
import main.UI.UIPrinter;
import main.UI.UIScanner;
import main.UI.UIVisitor;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class StatsMenu implements IMenu {
    @Override
    public void showMenu(UIPrinter printer) {
        throw new NotImplementedException();
    }

    @Override
    public void readInput(UIScanner scanner) {
        throw new NotImplementedException();
    }

    @Override
    public MyRunnable execute() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isValidInput() {
        throw new NotImplementedException();
    }

    @Override
    public void accept(UIVisitor visitor) {
        throw new NotImplementedException();
    }
}
