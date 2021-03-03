package main;

import main.menus.MainMenu;
import main.menus.ModeSelectMenu;
import main.players.AbstractPlayer;

public interface IPrinter {
    void print(IPrintable printable);
    void print(Board board);
//    void print(main.gamePieces.Pawn pawn);
//    void print(main.gamePieces.King king);
//    void print(TurkishKing turkishKing);
    void print(MainMenu mainMenu);
    void print(ModeSelectMenu modeSelectMenu);
    void print(Move[] moves);
    void print(AbstractPlayer player);
}