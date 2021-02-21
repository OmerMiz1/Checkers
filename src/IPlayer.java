import java.awt.*;

public interface IPlayer {
    String name=null;
    Color color=null;
    int moveTime = 0;

    Move getMove(Board board, Move[] possibleMoves);
}
