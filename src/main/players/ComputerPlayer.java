package main.players;

import main.Board;
import main.Move;
import main.Moves;
import main.UI.UIScanner;
import main.UI.UIVisitor;
import main.consts.PlayerType;

import java.util.ArrayList;

public class ComputerPlayer extends AbstractPlayer {
    @Override
    public void accept(UIVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public Move getMove(Board board, Moves possibleMoves, UIScanner scanner) {
        int max = possibleMoves.getSize();
        int indexMove = (int)(Math.random() * max);
        return possibleMoves.getMove(indexMove + 1);
    }
}
