import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;
import java.util.ArrayList;

public class Board implements IPrintable{
    GamePiece[][] board;
    IPrinter printer;

    public Move[] getAllMoves(IPlayer player) {
        ArrayList<Move> moves = new ArrayList<>();
        GamePiece piece;
        for(int row=0; row<board.length; ++row) {
            for(int col=0; col<board[row].length; ++col) {
                piece = board[row][col];
                if(piece != null && piece.color == player.color) {

                }
            }
        }

    }

    @Override
    public void accept(IPrinter printer) {
        throw new NotImplementedException();
    }
}
