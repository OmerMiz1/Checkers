import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;

public class Checkers {
    private Board board;
    private ILogic logic;
    private IPlayer[] players;
    private Color currentTurn;

    public void run() {
        throw new NotImplementedException();
    }

    public void announceWinner() {
        throw new NotImplementedException();
    }

    public Move[] getMoves(Point location) {
        throw new NotImplementedException();
    }
}
