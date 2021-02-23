import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;
import java.util.ArrayList;

public class Checkers {
    private Board board;
    private ILogic logic;
    private ArrayList<IPlayer> players;
    private Enum<Color> currentTurn;


    public Checkers(Board board, ILogic logic, ArrayList<IPlayer> players) {
        this.board = board;
        this.logic = logic;
        this.players = players;
        this.currentTurn = Color.white;
    }

    public void changeTurn() {
        if (this.currentTurn.equals(Color.white))
            this.currentTurn = Color.black;
        else
            this.currentTurn = Color.white;
    }

    public void run() {
        throw new NotImplementedException();
    }

    public void announceWinner() {
        throw new NotImplementedException();
    }

    public Move[] getMoves(Point location) {
        throw new NotImplementedException();
    }
}
