package main.gamePieces;

import main.consts.PlayerColor;
import main.IPrinter;
import main.IPrintable;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.Point;
import java.util.ArrayList;

public abstract class GamePiece implements IPrintable {
    PlayerColor color;
    IPrinter printer;

    protected GamePiece(PlayerColor color) {
        this.color = color;
    }

    public abstract ArrayList<Point> getMoves(Point location, int limit);
    public void print() {
        throw new NotImplementedException();
    } // TODO: param main.IPrinter printer, printer.accept(this)
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
