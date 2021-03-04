package main.menus;


import main.UI.UIVisitor;

public class ModeSelectMenu implements IMenu {
    @Override
    public void showMenu() {

    }

    @Override
    public void readInput() {

    }

    @Override
    public void execute() {

    }

    @Override
    public boolean validInput() {
        return true;
    }

    @Override
    public boolean isRunning() {
        return true;
    }

    @Override
    public void accept(UIVisitor visitor) {
        visitor.visit(this);
    }
}
