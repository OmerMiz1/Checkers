package main.menus;

import main.MyRunnable;
import main.UI.UIPrinter;
import main.UI.UIScanner;
import main.UI.UIVisitor;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class StatsMenu implements IMenu {
    @Override
    public MyRunnable apply() {
        throw new NotImplementedException();
    }

    @Override
    public String getHeader() {
        return "Checkers - Statistics";
    }

    @Override
    public boolean isValidInput() {
        throw new NotImplementedException();
    }

    @Override
    public void accept(UIVisitor visitor) {
        visitor.visit(this);
    }
}
