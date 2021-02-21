import java.util.ArrayList;

public abstract class CheckersBuilder {
    private Board board;
    private ICheckersLogic logic;
    private ArrayList<IPlayer> players;

    public Checkers getGame(){
        return null; // TODO: 21/02/2021
    }

    public void setPlayer(String name, IPlayer player) {
        this.players.add(player); // TODO: 21/02/2021 name??
    }
}
