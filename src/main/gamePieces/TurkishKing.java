package main.gamePieces;

import main.UI.UIVisitor;
import main.consts.PlayerColor;

import java.awt.*;
import java.util.ArrayList;

// TODO consider Overriding "accept"
public class TurkishKing extends King {
    public TurkishKing(PlayerColor color) {
        super(color);
    }

    @Override
    public ArrayList<Point> getMoves(Point location, int limit) {
        ArrayList<Point> moves = new ArrayList<>();

        // TOP-LEFT
        for(Point p = topLeft(location); inFrame(p, limit); p = topLeft(p)) {
            moves.add(p);
        }

        // TOP-RIGHT
        for(Point p = topRight(location); inFrame(p, limit); p = topRight(p)) {
            moves.add(p);
        }

        // BOTTOM-RIGHT
        for(Point p = bottomRight(location); inFrame(p, limit); p = bottomRight(p)) {
            moves.add(p);
        }

        // BOTTOM-LEFT
        for(Point p = bottomLeft(location); inFrame(p, limit); p = bottomLeft(p)) {
            moves.add(p);
        }

        return moves;
    }

    @Override
    public void accept(UIVisitor visitor) {
        visitor.visit(this);
    }
}
