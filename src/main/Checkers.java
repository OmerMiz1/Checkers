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
            printer.print(board);
            moves = new Moves(getPossibleMoves(curTurn));
            AbstractPlayer curPlayer = players.get(curTurn.ordinal());
            printer.print(curPlayer);
            Message chooseMessage = new Message("choose a move:\n");
            printer.print(chooseMessage);
            printer.print(moves);

            // select Move fixme: scanner.scan(curPlayer)
//            scanner.scan(curPlayer);
            Move selectedMove = curPlayer.getMove(board, moves, scanner);

            printer.print(curPlayer);
            Message performedMessage = new Message("performed move:\n");
            printer.print(performedMessage);
            printer.print(selectedMove);

            logic.performMove(board, selectedMove);
            moves.clearMoves();
            changeTurn();
        }

        announceWinner(printer);
        return new MainMenu();
    }

    private void announceWinner(UIPrinter printer) {
        Message msg;

        PlayerColor winnerColor = logic.getWinner(board);
        if (winnerColor == PlayerColor.TIE)
            msg = new Message("Match ended in tie\n");
        else {
            AbstractPlayer winner = players.get(winnerColor.ordinal());
            msg = new Message("is The Winner\n");
            printer.print(winner);
        }
        printer.print(msg);
    }

    private ArrayList<Move> getPossibleMoves(PlayerColor color) {
        ArrayList<Move> moves;
        moves = board.getAllMoves(color);
        return logic.filterMoves(board, moves);
    }

}
