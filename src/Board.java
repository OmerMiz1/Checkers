import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

public class Board implements IPrintable{

    private int rows;
    private int cols;

    private int blackPieces;
    private int whitePieces;

    GamePiece[][] board;
    IPrinter printer;


    public Board(int rowsSize, int colsSize) {
        this.rows = rowsSize;
        this.cols = colsSize;
        board = new GamePiece[this.rows][this.cols];
    }

    public int getCols() {
        return this.cols;
    }

    public int getRows() {
        return this.rows;
    }

    public void setBlackPieces(int blackPieces) {
        this.blackPieces = blackPieces;
    }

    public void setWhitePieces(int whitePieces) {
        this.whitePieces = whitePieces;
    }

    public int getWhitePieces() {
        return whitePieces;
    }

    public int getBlackPieces() {
        return blackPieces;
    }

    public void getAllMoves(IPlayer player) {
        ArrayList<Move> moves = new ArrayList<>();
        GamePiece piece;
        for (int row = 0; row < board.length; ++row) {
            for (int col = 0; col < board[row].length; ++col) {
                piece = board[row][col];
                if (piece != null && piece.color == player.color) {

                }
            }
        }
    }

    @Override
    public void accept(IPrinter printer) {
        throw new NotImplementedException();
    }
}