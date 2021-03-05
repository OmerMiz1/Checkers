package main;

import main.UI.UIVisitor;
import main.consts.PlayerColor;
import main.logic.ILogic;
import main.players.AbstractPlayer;

import java.util.ArrayList;

public class Checkers {
    public Board board;
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

    public void run(UIVisitor visitor) {
        ArrayList<Move> moves;

        while(logic.isRunning(board)) {
            board.accept(visitor);
            moves = getPossibleMoves(curTurn);
            AbstractPlayer curPlayer = players.get(curTurn.ordinal());
            curPlayer.accept(visitor);
            Massage chooseMassage = new Massage("you must choose one of the following moves:\n");
            chooseMassage.accept(visitor);


            // TODO need add group of moves for get index too..
            for (Move move : moves) {
                move.accept(visitor);
            }


            // select Move
            Move selectMove =  curPlayer.getMove(board, moves, visitor);

            curPlayer.accept(visitor);
            Massage performedMassage = new Massage("performed the move:\n");
            performedMassage.accept(visitor);
            selectMove.accept(visitor);

            logic.performMove(board, selectMove);
            moves.clear();
            changeTurn();
        }

        announceWinner(visitor);
    }

    public void announceWinner(UIVisitor visitor) {
        // TODO The UIPrinter should do the printing to user,
        //  checkers should only generate the message (?!)
        //  Maybe just add "Game Over" menu that does that?
        PlayerColor winner = logic.getWinner(board);
        Massage winnerMassage;
        if (winner == PlayerColor.TIE)
            winnerMassage = new Massage("The result of this mach is Tie\n");
        else {
            AbstractPlayer winnerPlayer = players.get(winner.ordinal());
            winnerMassage = new Massage("Is The WInner\n");
            winnerPlayer.accept(visitor);

        }
        winnerMassage.accept(visitor);

    }

    public ArrayList<Move> getPossibleMoves(PlayerColor color) {
        ArrayList<Move> moves;
        moves = board.getAllMoves(color);
        return logic.filterMoves(board, moves);
    }

}
