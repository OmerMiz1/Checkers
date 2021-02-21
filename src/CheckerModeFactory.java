import java.util.ArrayList;

public class CheckerModeFactory {

    public ArrayList<IPlayer> getPlayers(String name1, String name2) {
        ArrayList<IPlayer> players = new ArrayList<>();
        IPlayer player1 = new HumanPlayer(name1);
        Color playerOneColor = new Color("black");
        Color playerTowColor = new Color("white");
        player1.setColor(playerOneColor);
        IPlayer player2 = new HumanPlayer(name2);
        player2.setColor(playerTowColor);
        if (name2.equals("computer_easy")) {
            player2.setMoveTime(2);
        } else if (name2.equals("computer_hard")) {
            player2.setMoveTime(5);
        } else {
            player2.setMoveTime(Integer.MAX_VALUE);
        }
        players.add(player1);
        players.add(player2);
        return players;
    }
}

