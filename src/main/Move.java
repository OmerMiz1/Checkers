package main;

import main.UI.UIObject;
import main.UI.UIVisitor;

import java.awt.*;
import java.util.ArrayList;

public class Move implements UIObject {
    private Point src;
    public Point dst;
    public ArrayList<Point> isJump;

    public Move(Point src, Point dst, ArrayList<Point> isJump) {
        this.src = src;
        this.dst = dst;
        this.isJump = isJump;
    }

    public Point getSrc() {
        return src;
    }

    public Point getDst() {
        return dst;
    }

    public void setSrc(Point src){
        this.src = src;
    }

    public void setDst(Point dst) {
        this.dst = dst;
    }

    @Override
    public void accept(UIVisitor visitor) {
        visitor.visit(this);
    }
}
