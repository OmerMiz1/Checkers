package main;

import main.UI.UIPrinter;
import main.UI.UIScanner;
import main.UI.UIVisitor;
import main.consts.PlayerColor;
import main.logic.ILogic;
import main.menus.MainMenu;
import main.players.AbstractPlayer;
import java.util.ArrayList;

public class Checkers implements MyRunnable {
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

    @Override
    public MyRunnable run(UIPrinter printer, UIScanner scanner) {
        Moves moves;

        while(logic.isRunning(board)) {
            board.accept(printer);
            moves = new Moves(getPossibleMoves(curTurn));
            AbstractPlayer curPlayer = players.get(curTurn.ordinal());
            curPlayer.accept(printer);
            Message chooseMessage = new Message("choose a move:\n");
            chooseMessage.accept(printer);

            moves.accept(printer);

            // select Move
            Move selectedMove = curPlayer.getMove(board, moves, scanner);

            curPlayer.accept(printer);
            Message performedMassage = new Message("performed move:\n");
            performedMassage.accept(printer);
            selectedMove.accept(printer);

            logic.performMove(board, selectedMove);
            moves.clearMoves();
            changeTurn();
        }

        announceWinner(printer);
        return new MainMenu();
    }

    public void announceWinner(UIVisitor visitor) {
        // TODO The UIPrinter should do the printing to user,
        //  checkers should only generate the message (?!)
        //  Maybe just add "Game Over" menu that does that?
        PlayerColor winner = logic.getWinner(board);
        Message winnerMassage;
        if (winner == PlayerColor.TIE)
            winnerMassage = new Message("The result of this mach is Tie\n");
        else {
            AbstractPlayer winnerPlayer = players.get(winner.ordinal());
            winnerMassage = new Message("Is The WInner\n");
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
