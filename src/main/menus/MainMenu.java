package main.menus;

import main.MyRunnable;
import main.UI.UIPrinter;
import main.UI.UIScanner;
import main.UI.UIVisitor;

import java.util.ArrayList;

public class MainMenu implements IMenu {
    private enum Option {
        None,
        StartGame,
        Stats,
        Exit
    }
    private ArrayList<String> options;
    private Option selectedOption = Option.None;

    public MainMenu() {
        options = new ArrayList<>();
        options.add("Start Game");
        options.add("Statistics");
        options.add("Exit");
    }

    @Override
    public MyRunnable apply() {
        switch (selectedOption) {
            case StartGame:
                return new NewGameMenu();
            case Stats:
                return new StatsMenu();
            case Exit:
                return null;
            default:
                return this;
        }
    }

    @Override
    public boolean isValidInput() {
        return 0 < selectedOption.ordinal() && selectedOption.ordinal() < Option.values().length;
    }

    @Override
    public void accept(UIVisitor visitor) {
        visitor.visit(this);
    }

    public void setSelectedOption(int option) {
        this.selectedOption = Option.values()[option];
    }

    public String getHeader() {
        return "Checkers - Main Menu";
    }

    public ArrayList<String> getOptions() {
        return options;
    }
}
