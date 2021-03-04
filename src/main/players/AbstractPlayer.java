package main.players;

import main.Board;
import main.Move;
import main.UI.UIObject;
import main.UI.UIVisitor;
import main.consts.PlayerColor;

public abstract class AbstractPlayer implements UIObject {
    public String name;
    public PlayerColor color = null;
    public int moveTime = 0;

    public abstract Move getMove(Board board, Move[] possibleMoves);

    @Override
    public void accept(UIVisitor visitor) {
        visitor.visit(this);
    }
}
