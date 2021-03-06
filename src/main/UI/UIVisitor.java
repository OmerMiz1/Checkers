package main.UI;

import main.Board;
import main.Massage;
import main.Move;
import main.Moves;
import main.gamePieces.King;
import main.gamePieces.Pawn;
import main.gamePieces.TurkishKing;
import main.menus.MainMenu;
import main.menus.ModeSelectMenu;
import main.players.AbstractPlayer;

public interface UIVisitor {
    default void visit(UIObject object) {
        object.accept(this);
    }
    void visit(Board board);
    void visit(Pawn pawn);
    void visit(King king);
    void visit(TurkishKing turkishKing);
    void visit(MainMenu mainMenu);
    void visit(ModeSelectMenu modeSelectMenu);
    void visit(Move move);
    void visit(Moves moves);
    void visit(AbstractPlayer player);
    void visit(Massage massage);
}
