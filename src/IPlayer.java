import java.awt.*;

abstract class IPlayer {
    private String name;
    private Color color = null;
    private int moveTime = 0;

    public IPlayer(String name){
        this.name = name;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setMoveTime(int moveTime) {
        this.moveTime = moveTime;
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public int getMoveTime() {
        return moveTime;
    }

    public abstract  Move getMove(Board board, Move[] possibleMoves);
}
