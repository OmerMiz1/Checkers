package main.logic;

import main.Board;
import main.Checkers;
import main.players.AbstractPlayer;
import java.util.ArrayList;

public abstract class LogicBuilder {
    private Checkers game;
    protected Board board;
    protected ILogic logic;
    protected ArrayList<AbstractPlayer> players;

    public Checkers getGame(){
        return this.game;
    }

    public void createNewGame() {
        game = new Checkers(this.board , this.logic, this.players);
    }

    public void setPlayers(ArrayList<AbstractPlayer> players)
    {
        this.players = players;
    }

    public abstract void buildBoard();

    public abstract void buildLogic();

}
