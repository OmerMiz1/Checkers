package main.gamePieces;

import main.consts.PlayerColor;
import main.IPrinter;
import main.IPrintable;

import java.awt.Point;
import java.util.ArrayList;

public abstract class GamePiece implements IPrintable {
    PlayerColor color;

    protected GamePiece(PlayerColor color) {
        this.color = color;
    }

    @Override
    public void accept(IPrinter printer) {
        printer.print(this);
    }

    public abstract ArrayList<Point> getMoves(Point location, int limit);
    protected boolean inFrame(int x, int y, int limit) {
        if(0 <= x && x < limit && 0 <= y && y < limit) {
            return true;
        }
        return false;
    }
    protected boolean inFrame(Point p, int limit) {
        return inFrame(p.x, p.y, limit);
    }

    public PlayerColor getColor() {
        return color;
    }

}
