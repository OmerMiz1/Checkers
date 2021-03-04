package main;

import main.UI.ConsolePrinter;
import main.UI.UIVisitor;
import main.consts.PlayerType;
import main.logic.BuilderFactory;
import main.logic.LogicBuilder;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(0,0);
        Point p2 = new Point(1,1);

        // TODO create menu
        // TODO print menus
        // TODO read input from user

        // MOCKS:
        String[] names = {"shon", "omer"};
        PlayerType[] types = {PlayerType.HUMAN, PlayerType.HUMAN};

        UIVisitor printer = new ConsolePrinter();


        // Creating a factory that prepares builders
        BuilderFactory checkersBuilderFactory = new BuilderFactory();

        LogicBuilder checkersBuilder = checkersBuilderFactory.checkersBuilder("classic_builder");

        // Creating a main.CheckersDirector and than create game (checkers)
        CheckersDirector checkersDirector = new CheckersDirector();
        checkersDirector.setBuilder(checkersBuilder);
        checkersDirector.constructGame(names, types);
        Checkers checkers = checkersDirector.getGame();
        checkers.board.accept(printer);
        checkers.run();


//        IPrinter printer = new ConsolePrinter();
//        IMenu menu = new MainMenu();
//        menu.start(printer);
    }

    // TODO remove
    private static String pointToString(Point p) {
        return String.format("(%d, %d)", p.x, p.y);
    }
}