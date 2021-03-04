package main.menus;


import main.IO.IPrinter;

import java.util.HashMap;
import java.util.Map;

public class MainMenu implements IMenu {
    private enum Option {StartGame, Stats, Exit}
    private static String header;
    private static String footer;
    private Map<Option, String> options;

    public MainMenu() {
        options = new HashMap<>();
        options.put(Option.StartGame, "Start Game");
        options.put(Option.Stats, "Statistics");
        options.put(Option.Exit, "Exit");

        header = "Checkers - Main Menu";
        footer = "Enter Option..";
    }


    // Exactly like 'accept', but more understood.
    @Override
    public void showMenu(IPrinter printer) {
        printer.visit(this);
    }

    @Override
    public void readInput(IPrinter printer) {

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

//    @Override
//    public IMenu runOption(Integer option) {
//        Option opt = Option.values()[option];
//        switch (opt) {
//            case StartGame:
//                return new ModeSelectMenu();
//            case Stats:
//                return null; // TODO should be "stats menu"
//            case Exit:
//                return null;
//        }
//    }
}
