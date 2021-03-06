package main.UI;

import main.Board;
import main.Message;
import main.Move;
import main.Moves;
import main.gamePieces.King;
import main.gamePieces.Pawn;
import main.gamePieces.TurkishKing;
import main.menus.MainMenu;
import main.menus.NewGameMenu;
import main.players.AbstractPlayer;
import main.players.ComputerPlayer;
import main.players.HumanPlayer;

public interface UIVisitor {
    default void visit(UIObject object) {
        object.accept(this);
    }
    void visit(Board board);
    void visit(Pawn pawn);
    void visit(King king);
    void visit(TurkishKing turkishKing);
    void visit(MainMenu mainMenu);
    void visit(NewGameMenu newGameMenu);
    void visit(Move move);
    void visit(Moves moves);
    void visit(AbstractPlayer player);
    void visit(HumanPlayer player);
    void visit(ComputerPlayer player);
    void visit(Message massage);
}
