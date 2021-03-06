package main.gamePieces;

import main.UI.UIObject;
import main.consts.PlayerColor;

import java.awt.Point;
import java.util.ArrayList;

public abstract class GamePiece implements UIObject {
    protected PlayerColor color;

    public abstract ArrayList<Point> getMoves(Point location, int limit);

    protected GamePiece(PlayerColor color) {
        this.color = color;
    }
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
