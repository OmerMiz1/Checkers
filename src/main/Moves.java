package main;

import main.UI.UIObject;
import main.UI.UIVisitor;

import java.awt.*;
import java.util.ArrayList;

public class Moves implements UIObject {
    public ArrayList<Move> moves;

    public Moves(ArrayList<Move> moves) {
        this.moves = moves;
    }

    public void addMove(Move move){
        this.moves.add(move);
    }

    public void removeMoveNumber(int number){
        this.moves.remove(number-1);
    }

    public void clearMoves() {
        this.moves.clear();
    }

    public Move getMove(int index) {
        return this.moves.get(index-1);
    }

    public ArrayList<Move> getMoves() {
        return this.moves;
    }

    public int getSize(){
        return this.moves.size();
    }

    @Override
    public void accept(UIVisitor visitor) {
        visitor.visit(this);
    }
}
