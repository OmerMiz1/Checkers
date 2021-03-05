package main.players;

import main.Board;
import main.Move;
import main.UI.UIVisitor;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

public class HumanPlayer extends AbstractPlayer {
    @Override
    public Move getMove(Board board, ArrayList<Move> possibleMoves) {
        int max = possibleMoves.size();
        int indexMove = (int)(Math.random() * 0);

        return possibleMoves.get(indexMove);
    }

}
