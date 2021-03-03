package main;

import main.consts.PlayerColor;
import main.logic.ILogic;
import main.players.AbstractPlayer;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

public class Checkers {
    private Board board;
    private ILogic logic;
    private ArrayList<AbstractPlayer> players;
    private PlayerColor curTurn;


    public Checkers(Board board, ILogic logic, ArrayList<AbstractPlayer> players) {
        this.board = board;
        this.logic = logic;
        this.players = players;
        this.curTurn = PlayerColor.RED; // Red starts
    }

    public void changeTurn() {
        curTurn = (curTurn == PlayerColor.WHITE) ? PlayerColor.RED : PlayerColor.WHITE;
    }

    public void run() {
        ArrayList<Move> moves;

        while(logic.isRunning(board)) {
            moves = getPossibleMoves(curTurn);
            // TODO print moves
            // TODO scan move
            // TODO performMove
            moves.clear();
        }

        announceWinner();
    }

    public void announceWinner() {
        // TODO The Printer should do the printing to user,
        //  checkers should only generate the message (?!)
        //  Maybe just add "Game Over" menu that does that?
        throw new NotImplementedException();
    }



    public ArrayList<Move> getPossibleMoves(PlayerColor color) {
        ArrayList<Move> moves;
        moves = board.getAllMoves(color);
        return logic.filterMoves(board, moves);
    }
}
