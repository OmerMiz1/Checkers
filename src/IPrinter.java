public interface IPrinter {
    void print(IPrintable printable);
    void print(Board board);
    void print(Pawn pawn);
    void print(King king);
    void print(TurkishKing turkishKing);
    void print(MainMenu mainMenu);
    void print(ModeSelectMenu modeSelectMenu);
    void print(Move[] moves);
    void print(Player player);
}
