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
    private String header;
    private ArrayList<String> options;
    private Option selectedOption = Option.None;

    public MainMenu() {
        header = "Checkers - Main Menu";

        options = new ArrayList<>();
        options.add("Start Game");
        options.add("Statistics");
        options.add("Exit");
    }

    @Override
    public void showMenu(UIPrinter printer) {
        accept(printer);
    }

    @Override
    public void readInput(UIScanner scanner) {
        accept(scanner);
    }

    @Override
    public MyRunnable execute() {
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
        return 0 <= selectedOption.ordinal() && selectedOption.ordinal() < Option.values().length;
    }

    @Override
    public void accept(UIVisitor visitor) {
        visitor.visit(this);
    }

    public void setSelectedOption(int option) {
        this.selectedOption = Option.values()[option];
    }

    public String getHeader() {
        return header;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

//    @Override
//    public IMenu runOption(Integer option) {
//        Option opt = Option.values()[option];
//        switch (opt) {
//            case StartGame:
//                return new NewGameMenu();
//            case Stats:
//                return null; // TODO should be "stats menu"
//            case Exit:
//                return null;
//        }
//    }
}
