package main.UI;

import main.Board;
import main.Move;
import main.consts.PlayerColor;
import main.gamePieces.King;
import main.gamePieces.Pawn;
import main.gamePieces.TurkishKing;
import main.menus.MainMenu;
import main.menus.ModeSelectMenu;
import main.players.AbstractPlayer;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;

public class ConsolePrinter extends UIPrinter {
    private static final String ENDC = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String WHITE_BG = "\u001B[47m";

    private static String ROW_SEPERATOR = null;

    @Override
    public void visit(Board board) {
        if(ROW_SEPERATOR == null) {
            initRowSeperator(board.getSize());
        }
        System.out.println();
        printColNumbers(board.getSize());
        for(int row = 0; row < board.getSize(); ++row){
            System.out.println(ROW_SEPERATOR);
            for(int col = 0 ; col < board.getSize() ; ++col) {
                if(col == 0) {
                    System.out.printf("%c", row + 'a');
                }
                System.out.print(" | ");

                if(board.at(row, col) != null) {
                    board.at(row, col).accept(this);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println(" |");
        }
        System.out.println(ROW_SEPERATOR);
    }

    @Override
    public void visit(Pawn pawn) {
        printPiece(pawn.getColor(), "P");
    }

    @Override
    public void visit(King king) {
        printPiece(king.getColor(), "K");
    }

    @Override
    public void visit(TurkishKing turkishKing) {
        printPiece(turkishKing.getColor(), "TK");
    }

    @Override
    public void visit(MainMenu mainMenu) {
        throw new NotImplementedException();
    }

    @Override
    public void visit(ModeSelectMenu modeSelectMenu) {
        throw new NotImplementedException();
    }

    @Override
    public void visit(Move move) {
        System.out.printf("Move from %s to %s", pointToString(move.getSrc()), pointToString(move.dst));
    }

    @Override
    public void visit(AbstractPlayer player) {
        throw new NotImplementedException();
    }

    /* Helper Functions */
    private String pointToString(Point p) {
        return String.format("(%d, %d)", p.x, p.y);
    }
    private void printPiece(PlayerColor color, String pieceStr) {
        if(color == PlayerColor.RED) {
            pieceStr = RED + pieceStr + ENDC;
        }
        System.out.print(pieceStr);
    }
    private void initRowSeperator(int size) {
        StringBuilder sb = new StringBuilder();
        sb.append("  ");
        for (int i = 0; i < size*4 + 1; i++) {
            if(i % 2 == 0) {
                sb.append('+');
            } else {
                sb.append('-');
            }
        }
        sb.append(" ");
        ROW_SEPERATOR = sb.toString();
    }
    private void printColNumbers(int cols) {
        System.out.print(" ");
        for (int i = 1; i <= cols; ++i) {
            System.out.printf("   %d", i);
        }
        System.out.println(" ");
    }
}
