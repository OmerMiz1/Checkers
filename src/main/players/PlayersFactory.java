package main.players;

import java.util.ArrayList;
import main.consts.PlayerColor;
import main.consts.PlayerType;

public class PlayersFactory {
    public ArrayList<AbstractPlayer> generatePlayers(String[] names, PlayerType[] types) {
        ArrayList<AbstractPlayer> players = new ArrayList<>();
        AbstractPlayer player1, player2;

        player1 = generatePlayerByType(types[0]);
        player1.name = names[0];
        player1.color = PlayerColor.RED;

        player2 = generatePlayerByType(types[1]);
        player2.name = names[1];
        player2.color = PlayerColor.WHITE;

        players.add(player1);
        players.add(player2);
        return players;
    }

    private AbstractPlayer generatePlayerByType(PlayerType type) {
        AbstractPlayer player;

        switch (type) {
            case HUMAN:
                player = new HumanPlayer();
                break;
            case COMPUTER_EASY:
                player = new ComputerPlayer();
                player.moveTime = 2;
                break;
            case COMPUTER_HARD:
                player = new ComputerPlayer();
                player.moveTime = 5;
                break;
            default:
                player = null;
        }

        return player;
    }
}

