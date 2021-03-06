package main.logic;

import main.Board;
import main.Move;
import main.consts.PlayerColor;
import main.gamePieces.King;
import main.gamePieces.TurkishKing;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;
import java.util.ArrayList;

public class Turkish extends Classic {
    @Override
    protected void promote(Board board, Point p) {
        board.set(p, new TurkishKing( board.at(p).getColor()));
    }
}
