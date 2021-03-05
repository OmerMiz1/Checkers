package main.players;

import main.Board;
import main.Move;
import main.UI.UIObject;
import main.UI.UIVisitor;
import main.consts.PlayerColor;

import java.util.ArrayList;

public abstract class AbstractPlayer implements UIObject {
    public String name;
    public PlayerColor color = null;
    int moveTime = 0;

    public abstract Move getMove(Board board, ArrayList<Move> possibleMoves);

    @Override
    public void accept(UIVisitor visitor) {
        visitor.visit(this);
    }
}
