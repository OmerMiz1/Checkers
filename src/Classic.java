import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;

public class Classic implements ILogic{

    @Override
    public Move[] getPossibleMoves(Move[] moves) {
        throw new NotImplementedException();
    }

    @Override
    public void performMove(Board board, Move move) {
        throw new NotImplementedException();
    }

    @Override
    public Enum<Color> getWinner(Board board) {
        throw new NotImplementedException();
    }
}
