package main;

import main.consts.PlayerType;
import main.logic.LogicBuilder;
import main.players.PlayersFactory;

/** Director **/
public class CheckersDirector{
    private LogicBuilder builder;

    public CheckersDirector(LogicBuilder builder) {
        this.builder = builder;
    }

    public void setBuilder(LogicBuilder builder) {
        this.builder = builder;
    }

    public Checkers getGame() {
        return builder.getGame();
    }

    public void constructGame(String[] names, PlayerType[] types) {
        PlayersFactory playersFactory = new PlayersFactory();
        builder.setPlayers(playersFactory.generatePlayers(names, types));
        builder.buildBoard();
        builder.buildLogic();
        builder.createNewGame();
    }
}
