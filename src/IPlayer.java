abstract class IPlayer {
    private String name;
    public Enum<Color> color = null;
    private int moveTime = 0;

    public IPlayer(String name){
        this.name = name;
    }

    public void setColor(Enum<Color> color) {
        this.color = color;
    }

    public void setMoveTime(int moveTime) {
        this.moveTime = moveTime;
    }

    public Enum<Color> getColor() {
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
