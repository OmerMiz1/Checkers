package main.players;

import main.Board;
import main.Move;
import main.UI.UIVisitor;
import main.consts.PlayerType;

import java.util.ArrayList;

public class ComputerPlayer extends AbstractPlayer {
    @Override
    public Move getMove(Board board, ArrayList<Move> possibleMoves) {
        int max = possibleMoves.size();
        int indexMove = (int)(Math.random() * max);
        return possibleMoves.get(indexMove);
    }

}
