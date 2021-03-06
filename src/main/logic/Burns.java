package main.logic;

import main.Board;
import main.Move;
import main.consts.PlayerColor;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

public class Burns implements ILogic {
    @Override
    public ArrayList<Move> filterMoves(Board board, ArrayList<Move> moves) {
        throw new NotImplementedException();
    }

    @Override
    public void performMove(Board board, Move move) {
        throw new NotImplementedException();
    }

    @Override
    public PlayerColor getWinner(Board board) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isRunning(Board board) {
        throw new NotImplementedException();
    }
}
