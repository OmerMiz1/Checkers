package main.logic;

import main.Board;
import main.Move;
import main.consts.PlayerColor;

import java.util.ArrayList;

public interface ILogic {
    ArrayList<Move> filterMoves(Board board, ArrayList<Move> moves);
    void performMove(Board board, Move move);
    PlayerColor getWinner(Board board);
    boolean isRunning(Board board);
}
