package main.gamePieces;

import main.UI.UIVisitor;
import main.consts.PlayerColor;

import java.util.ArrayList;
import java.awt.Point;

public class King extends Pawn {

    public King(PlayerColor color) {
        super(color);
    }

    @Override
    public ArrayList<Point> getMoves(Point location, int limit) {
        ArrayList<Point> moves = new ArrayList<>();
        Point p1, p2, p3, p4;

        p1 = topLeft(location);
        p2 = topRight(location);
        p3 = bottomLeft(location);
        p4 = bottomRight(location);

        if(inFrame(p1, limit)) {
            moves.add(p1);
        }
        if(inFrame(p2, limit)) { // RIGHT
            moves.add(p2);
        }
        if(inFrame(p3, limit)) {
            moves.add(p3);
        }
        if(inFrame(p4, limit)) { // RIGHT
            moves.add(p4);
        }

        return moves;
    }

    @Override
    public void accept(UIVisitor visitor) {
        visitor.visit(this);
    }
}
