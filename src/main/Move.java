package main;

import java.awt.*;

public class Move {
    private Point src;
    public Point dst;
    public boolean isJump;

    public Move(Point src, Point dst, boolean isJump) {
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
}
