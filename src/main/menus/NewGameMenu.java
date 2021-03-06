package main.menus;

import main.Checkers;
import main.CheckersDirector;
import main.MyRunnable;
import main.UI.UIPrinter;
import main.UI.UIScanner;
import main.UI.UIVisitor;
import main.consts.GameType;
import main.consts.PlayerType;
import main.logic.BuilderFactory;
import main.logic.LogicBuilder;

import java.util.ArrayList;

public class NewGameMenu implements IMenu {
    private String header;
    private String[] playerNames;
    private PlayerType[] playerTypes;
    private GameType gameType;

    public NewGameMenu() {
        header = "Checkers - New Game";
        playerNames = new String[2];
        playerTypes = new PlayerType[2];
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
        // Creating a factory that prepares builders
        BuilderFactory checkersBuilderFactory = new BuilderFactory();
        LogicBuilder checkersBuilder = checkersBuilderFactory.checkersBuilder(gameType);

        // Creating a main.CheckersDirector and than create game (checkers)
        CheckersDirector checkersDirector = new CheckersDirector();
        checkersDirector.setBuilder(checkersBuilder);
        checkersDirector.constructGame(playerNames, playerTypes);
        Checkers checkers = checkersDirector.getGame();

        return checkers;
    }

    @Override
    public boolean isValidInput() {
        return true;
    }

    @Override
    public void accept(UIVisitor visitor) {
        visitor.visit(this);
    }

    public String getHeader() {
        return header;
    }


    public void setPlayerName(String name, int playerNum) {
        if(0 <= playerNum && playerNum < playerNames.length) {
            playerNames[playerNum] = name;
        }
    }

    public void setPlayerType(PlayerType type, int playerNum) {
        if(0 <= playerNum && playerNum < playerTypes.length) {
            playerTypes[playerNum] = type;
        }
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }
}
