package main.gamePieces;

import main.UI.UIObject;
import main.UI.UIVisitor;
import main.consts.PlayerColor;
import java.awt.Point;
import java.util.ArrayList;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

// NOTES:
// Red starts
// Red = UP, White = DOWN
public class Pawn extends GamePiece {
    // Not intuitive therefore used finals
    protected static final int DOWN = 1;
    protected static final int UP = -1;

    public Pawn(PlayerColor color) {
        super(color);
    }

    @Override
    public ArrayList<Point> getMoves(Point location, int limit) {
        ArrayList<Point> moves = new ArrayList<>();
        Point p1, p2; // Left, Right

        if(color == PlayerColor.RED) { // UP
            p1 = topLeft(location);
            p2 = topRight(location);
        } else { // DOWN
            p1 = bottomLeft(location);
            p2 = bottomRight(location);
        }

        if(inFrame(p1, limit)) {
                moves.add(p1);
        }
        if(inFrame(p2, limit)) { // RIGHT
                moves.add(p2);
        }

        return moves;
    }

    protected Point topLeft(Point p) {
        return new Point(p.x - 1, p.y + UP);
    }

    protected Point topRight(Point p) {
        return new Point(p.x + 1, p.y + UP);
    }

    protected Point bottomLeft(Point p) {
        return new Point(p.x -1, p.y + DOWN);
    }

    protected Point bottomRight(Point p) {
        return new Point(p.x + 1, p.y + DOWN);
    }

    @Override
    public void accept(UIVisitor visitor) {
        visitor.visit(this);
    }
//
//    @Override
//    public void accept(UIVisitor visitor) {
//        visitor.visit(this);
//    }
}
