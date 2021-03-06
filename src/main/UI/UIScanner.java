package main.UI;

import main.Board;
import main.Message;
import main.Move;
import main.Moves;
import main.gamePieces.King;
import main.gamePieces.Pawn;
import main.gamePieces.TurkishKing;

public abstract class UIScanner implements UIVisitor {
    public void scan(UIObject object) {
        object.accept(this);
    }

    @Override
    public void visit(Message message) {

    }

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
    public void visit(Move move) {

    }

    @Override
    public void visit(Moves moves) {

    }
//    abstract Integer scanInt();
//
//    abstract String scanStr();
}
