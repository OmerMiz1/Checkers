package main;

import main.consts.PlayerType;
import main.logic.BuilderFactory;
import main.logic.LogicBuilder;

public class Main {

    public static void main(String[] args) {
        // TODO create menu
        // TODO print menus
        // TODO read input from user

        // MOCKS:
        String[] names = {"shon", "omer"};
        PlayerType[] types = {PlayerType.HUMAN, PlayerType.HUMAN};

        // Creating a factory that prepares builders
        BuilderFactory checkersBuilderFactory = new BuilderFactory();

        LogicBuilder checkersBuilder = checkersBuilderFactory.checkersBuilder("classic_builder");

        // Creating a main.CheckersDirector and than create game (checkers)
        CheckersDirector checkersDirector = new CheckersDirector();
        checkersDirector.setBuilder(checkersBuilder);
        checkersDirector.constructGame(names, types);
        Checkers checkers = checkersDirector.getGame();

        checkers.run();
    }

}