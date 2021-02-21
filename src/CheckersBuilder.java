import java.util.ArrayList;

public abstract class CheckersBuilder {
    private Checkers game;
    private Board board;
    private ILogic logic;
    private ArrayList<IPlayer> players;

    public Checkers getGame(){
        return this.game;
    }

    public void createNewCheckers() {
        game = new Checkers(this.board , this.logic, this.players);
    }

    public void setPlayer(ArrayList<IPlayer> players)
    {
        this.players = players;
    }

    public abstract void buildBoard();

    public abstract void buildLogic();

}
