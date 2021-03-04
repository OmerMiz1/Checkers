package main.UI;

import main.Board;
import main.Move;
import main.gamePieces.King;
import main.gamePieces.Pawn;
import main.gamePieces.TurkishKing;
import main.menus.MainMenu;
import main.menus.ModeSelectMenu;
import main.players.AbstractPlayer;

public class ConsoleScanner extends UIScanner {
    @Override
    public void visit(Board board) {

    }

    @Override
    public void visit(Pawn pawn) {

    }

    @Override
    public void visit(King king) {

    }

    @Override
    public void visit(TurkishKing turkishKing) {

    }

    @Override
    public void visit(MainMenu mainMenu) {

    }

    @Override
    public void visit(ModeSelectMenu modeSelectMenu) {

    }

    @Override
    public void visit(Move move) {
        System.out.println();
    }


    @Override
    public void visit(AbstractPlayer player) {

    }
}
