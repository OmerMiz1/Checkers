import java.awt.*;

public interface ICheckersLogic {
    Move[] getPossibleMoves(Board board);
    void performMove(Board board, Move move);
    Color getWinner(Board board);
}
