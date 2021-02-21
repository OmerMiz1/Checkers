import java.awt.*;

public abstract class GamePiece implements IPrintable {
    Color color;
    IPrinter printer;

    public abstract Move[] getMoves(Point location, int limit);
    public void print() {} // TODO: param IPrinter printer, printer.accept(this)
    protected boolean inFrame(Point location, int limit) {
        if(location.x < 0 || location.x > limit || location.y < 0 || location.y > limit) {
            return false;
        }
        return true;
    }

}
