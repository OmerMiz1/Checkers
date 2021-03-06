package main.menus;

import main.Checkers;
import main.CheckersDirector;
import main.MyRunnable;
import main.UI.UIVisitor;
import main.consts.GameType;
import main.consts.PlayerType;
import main.logic.BuilderFactory;
import main.logic.LogicBuilder;

import java.util.ArrayList;

public class NewGameMenu implements IMenu {
    private String[] playerNames;
    private PlayerType[] playerTypes;
    private GameType gameType;
    private ArrayList<String> playerTypeOptions;
    private ArrayList<String> gameTypeOptions;

    public NewGameMenu() {
        playerNames = new String[2];
        playerTypes = new PlayerType[2];

        playerTypeOptions = new ArrayList<>();
        playerTypeOptions.add("Human");
        playerTypeOptions.add("Computer Easy");
        playerTypeOptions.add("Computer Hard");

        gameTypeOptions = new ArrayList<>();
        gameTypeOptions.add("Classic");
        gameTypeOptions.add("Turkish");
        gameTypeOptions.add("Burns");
    }

    @Override
    public MyRunnable apply() {
        // Creating a factory that prepares builders
        BuilderFactory checkersBuilderFactory = new BuilderFactory();
        LogicBuilder logicBuilder = checkersBuilderFactory.createLogicBuilder(gameType);

        // Creating a main.CheckersDirector and than create game (checkers)
        CheckersDirector checkersDirector = new CheckersDirector(logicBuilder);
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
        return "Checkers - New Game";
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

    public ArrayList<String> getPlayerTypeOptions() {
        return playerTypeOptions;
    }

    public ArrayList<String> getGameTypeOptions() {
        return gameTypeOptions;
    }
}
