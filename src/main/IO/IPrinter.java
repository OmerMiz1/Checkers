package main.IO;

import main.Board;
import main.Move;
import main.menus.MainMenu;
import main.menus.ModeSelectMenu;
import main.players.AbstractPlayer;

public interface IPrinter {
    default void print(IPrintable printable) {
        System.out.println(this.getClass().getSimpleName()); // TODO remove
        printable.accept(this);
    }
    void visit(Board board);
//    void visit(main.gamePieces.Pawn pawn);
//    void visit(main.gamePieces.King king);
//    void visit(TurkishKing turkishKing);
    void visit(MainMenu mainMenu);
    void visit(ModeSelectMenu modeSelectMenu);
    void visit(Move[] moves);
    void visit(AbstractPlayer player);
}