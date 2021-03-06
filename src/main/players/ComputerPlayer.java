package main.players;

import main.Board;
import main.Move;
import main.Moves;
import main.UI.UIVisitor;
import main.consts.PlayerType;

import java.util.ArrayList;

public class ComputerPlayer extends AbstractPlayer {
    @Override
    public Move getMove(Board board, Moves possibleMoves, UIVisitor visitor) {
        int max = possibleMoves.getSize();
        int indexMove = (int)(Math.random() * max);
        return possibleMoves.getMove(indexMove + 1);
    }

}
