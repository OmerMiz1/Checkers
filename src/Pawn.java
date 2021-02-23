import java.awt.*;

public class Pawn extends GamePiece {

    public Pawn(Enum<Color> color) {
        super(color);
    }

    @Override
    public Move[] getMoves(Point location, int limit) {
        return new Move[0]; //Todo
    }

    @Override
    public void accept(IPrinter printer) {
        //Todo
    }
}
