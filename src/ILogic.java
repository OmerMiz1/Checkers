public interface ILogic {
    Move[] getPossibleMoves(Move[] moves);
    void performMove(Board board, Move move);
    Enum<Color> getWinner(Board board);
}
