package main.logic;
import main.Board;
import main.Move;
import main.gamePieces.GamePiece;
import main.consts.PlayerColor;
import main.gamePieces.King;
import main.gamePieces.Pawn;

import java.awt.Point;
import java.util.ArrayList;

public class Classic implements ILogic {
    private final int MAX_MOVES_NO_JUMP = 20;

    private int movesNoJumpCount = 0;

    // Todo add multiJump
    @Override
    public ArrayList<Move> filterMoves(Board board, ArrayList<Move> moves) {
        ArrayList<Move> filteredMoves = new ArrayList<>();
        boolean hasJumps = false;

        for(Move move : moves) {
            PlayerColor c1, c2 = null;
            Point newDst;
            c1 = board.at(move.getSrc()).getColor();
            GamePiece tmp = board.at(move.getDst());

            if(tmp != null) {
                c2 = tmp.getColor();
            }

            if(c2 == null) { // Empty cell
                filteredMoves.add(move);
            } else if (c1 != c2) { // Enemy
                newDst = destAfterJump(move.getSrc(), move.getDst());
                if (newDst == null)
                    continue;

                if(board.at(newDst) == null || board.at(newDst).getColor() == null) { // Jump loc is empty
                    move.jumps.add(move.dst);
                    move.dst = newDst;
                    hasJumps = true;
                    filteredMoves.add(move);
                }

            }
        }

        if(hasJumps) { // Remove non-jumps options
            filteredMoves.removeIf(move -> move.jumps.isEmpty());
        }

        return filteredMoves;
    }

    @Override
    public void performMove(Board board, Move move) {
        GamePiece piece = board.at(move.getSrc());

        if(!move.jumps.isEmpty()) {
            for(Point point: move.jumps)
                board.remove(point);
            movesNoJumpCount = 0;
        } else {
            ++movesNoJumpCount;
        }

        board.move(move.getSrc(), move.dst);

        // Pawn & Last Row --> Promote
        if(piece instanceof Pawn && isLastRow(piece, move.dst.x, board.getSize())) {
            promote(board, move.dst);
        }
    }

    @Override
    public PlayerColor getWinner(Board board) {
        if(board.getRedPiecesCount() > 0 && board.getWhitePiecesCount() > 0) { // NONE
            return PlayerColor.TIE ;
        } else if (board.getRedPiecesCount() > 0) {
            return PlayerColor.RED;
        } else {
            return PlayerColor.WHITE;
        }
    }

    @Override
    public boolean isRunning(Board board) {
        return board.getWhitePiecesCount() > 0
                && board.getRedPiecesCount() > 0
                && movesNoJumpCount < MAX_MOVES_NO_JUMP;
    }

    private Point destAfterJump(Point src, Point dst) {
        int xDir = (src.x < dst.x) ? 1 : -1;
        int yDir = (src.y < dst.y) ? 1 : -1;
        if (dst.x + xDir > 7 || dst.x + xDir < 0 || dst.y + yDir > 7 || dst.y + yDir < 0)
            return null;
        return new Point(dst.x + xDir, dst.y + yDir);
    }

    private boolean isLastRow(GamePiece piece, int row, int boardSize) {
        int lastRow = (piece.getColor() == PlayerColor.RED) ? 0 : boardSize-1;
        return row == lastRow;
    }

    protected void promote(Board board, Point p) {
        board.set(p, new King(board.at(p).getColor()));
    }
}
