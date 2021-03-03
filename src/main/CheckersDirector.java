package main;

import main.consts.PlayerType;
import main.logic.LogicBuilder;
import main.players.PlayersFactory;

/** Director **/
public class CheckersDirector{
    private LogicBuilder builder;

    public void setBuilder(LogicBuilder builder) {
        this.builder = builder;
    }

    public Checkers getGame() {
        return builder.getGame();
    }

    public void constructGame(String[] names, PlayerType[] types) {
        // todo Maybe take out so he does not contain the checkerModeFactory
        PlayersFactory playersFactory = new PlayersFactory();
        builder.setPlayers(playersFactory.generatePlayers(names, types)); // TODO add parameters <type1, type2>
        builder.buildBoard();
        builder.buildLogic();
        builder.createNewGame();
    }
}
