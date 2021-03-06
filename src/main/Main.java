package main;

import main.UI.*;
import main.consts.PlayerType;
import main.logic.BuilderFactory;
import main.logic.LogicBuilder;
import main.menus.MainMenu;

import java.awt.*;

public class Main {
    public static void main(String[] args) {

        Point p1 = new Point(0,0);
        Point p2 = new Point(1,1);

        // TODO create menu
        // TODO print menus
        // TODO read input from user

        // MOCKS:
        String[] names = {"Shon", "Omer"};
        PlayerType[] types = {PlayerType.COMPUTER_EASY, PlayerType.COMPUTER_EASY};

        UIPrinter printer = new ConsolePrinter();
        UIScanner scanner = new ConsoleScanner();
        MyRunnable runnable = new MainMenu();

        while(runnable != null) {
            runnable = runnable.run(printer, scanner);
        }



//        // Creating a factory that prepares builders
//        BuilderFactory checkersBuilderFactory = new BuilderFactory();
//
//        LogicBuilder checkersBuilder = checkersBuilderFactory.checkersBuilder("classic_builder");
//
//        // Creating a main.CheckersDirector and than create game (checkers)
//        CheckersDirector checkersDirector = new CheckersDirector();
//        checkersDirector.setBuilder(checkersBuilder);
//        checkersDirector.constructGame(names, types);
//        Checkers checkers = checkersDirector.getGame();
//        checkers.run(printer, scanner);


//        IPrinter printer = new ConsolePrinter();
//        IMenu menu = new MainMenu();
//        menu.start(printer);
    }

    // TODO remove
    private static String pointToString(Point p) {
        return String.format("(%d, %d)", p.x, p.y);
    }
}