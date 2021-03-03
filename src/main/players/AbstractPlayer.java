package main.players;

import main.Board;
import main.Move;
import main.consts.PlayerColor;

public abstract class AbstractPlayer {
    public String name;
    public PlayerColor color = null;
    public int moveTime = 0;

    public abstract Move getMove(Board board, Move[] possibleMoves);
}
