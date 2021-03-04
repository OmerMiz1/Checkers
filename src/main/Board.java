package main;// https://github.com/AshishPrasad/Checkers/blob/master/checkers/Board.java

import main.IO.IPrintable;
import main.IO.IPrinter;
import main.consts.PlayerColor;
import main.gamePieces.GamePiece;

import java.awt.Point;
import java.util.ArrayList;

public class Board implements IPrintable {

    private int size;

    private int redPiecesCount;
    private int whitePiecesCount;

    private GamePiece[][] board;

    public Board(int size) {
        this.size = size;
        board = new GamePiece[size][size];
    }

    public ArrayList<Move> getAllMoves(PlayerColor color) {
        ArrayList<Move> moves = new ArrayList<>();
        GamePiece piece;
        Point src;

        for (int row = 0; row < size; ++row) {
            for (int col = 0; col < size; ++col) {
                piece = board[row][col];
                src = new Point(row, col);
                if (piece != null && piece.getColor() == color) {
                    ArrayList<Point> curMoves = piece.getMoves(new Point(row, col), size);
                    for(Point dst : curMoves) {
                        moves.add(new Move(src, dst, false));
                    }
                }
            }
        }

        return moves;
    }

    public void remove(Point p) {
        board[p.x][p.y] = null;
    }

    public void set(Point p, GamePiece piece) {
        board[p.x][p.y] = piece;
    }

    public void set(int x, int y, GamePiece piece) {
        board[x][y] = piece;
    }

    public void move(Point src, Point dst) {
        board[dst.x][dst.y] = at(src);
        remove(src);
    }

    public GamePiece at(Point p) {
        return board[p.x][p.y];
    }

    public GamePiece at(int x, int y) {
        return board[x][y];
    }

    public int getSize() {
        return size;
    }

    public void setRedPiecesCount(int redPiecesCount) {
        this.redPiecesCount = redPiecesCount;
    }

    public void setWhitePiecesCount(int whitePiecesCount) {
        this.whitePiecesCount = whitePiecesCount;
    }

    public int getRedPiecesCount() {
        return redPiecesCount;
    }

    public int getWhitePiecesCount() {
        return whitePiecesCount;
    }


}