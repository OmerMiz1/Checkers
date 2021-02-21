import java.awt.*;

public interface ILogic {
    Move[] getPossibleMoves(Move[] moves);
    void performMove(Board board, Move move);
    Color getWinner(Board board);
}
