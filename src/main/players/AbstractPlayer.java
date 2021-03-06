package main.players;

import main.Board;
import main.Move;
import main.Moves;
import main.UI.UIObject;
import main.UI.UIPrinter;
import main.UI.UIScanner;
import main.UI.UIVisitor;
import main.consts.PlayerColor;

import java.util.ArrayList;

public abstract class AbstractPlayer implements UIObject {
    protected String name;
    protected PlayerColor color = null;
    protected int moveTime = 0;
    protected int selectedOption;

    public abstract Move getMove(Board board, Moves possibleMoves, UIScanner scanner);

    @Override
    public void accept(UIVisitor visitor) {
        visitor.visit(this);
    }

    public String getName() {
        return name;
    }

    public PlayerColor getColor() {
        return color;
    }

    public int getMoveTime() {
        return moveTime;
    }

    public int getSelectedOption() {
        return selectedOption;
    }
}
