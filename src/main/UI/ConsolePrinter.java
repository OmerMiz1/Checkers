package main.UI;

import main.Board;
import main.Message;
import main.Move;
import main.Moves;
import main.consts.PlayerColor;
import main.gamePieces.King;
import main.gamePieces.Pawn;
import main.gamePieces.TurkishKing;
import main.menus.MainMenu;
import main.menus.NewGameMenu;
import main.players.ComputerPlayer;
import main.players.HumanPlayer;

import java.awt.*;
import java.util.ArrayList;

public class ConsolePrinter extends UIPrinter {
    private static final String ENDC = "\u001B[0m";
    private static final String RED = "\u001B[31m";

    private static String ROW_SEPARATOR = null;

    @Override
    public void visit(Board board) {
        // Taken from:
        // https://stackoverflow.com/questions/36076999/print-2d-array-to-console-in-board-format
        if(ROW_SEPARATOR == null) {
            initRowSeparator(board.getSize());
        }
        System.out.println();
        printColNumbers(board.getSize());
        for(int row = 0; row < board.getSize(); ++row){
            System.out.println(ROW_SEPARATOR);
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
        System.out.println(ROW_SEPARATOR);
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
        printPiece(turkishKing.getColor(), "K");
    }

    @Override
    public void visit(MainMenu mainMenu) {
        Message msg = new Message(String.format("\n%s\n", mainMenu.getHeader()));
        ArrayList<String> options = mainMenu.getOptions();

        msg.accept(this);
        for (int i = 0; i < options.size() ; ++i) {
            System.out.printf("%d) %s\n", i+1, options.get(i));
        }
    }

    @Override
    public void visit(NewGameMenu newGameMenu) {
        Message msg = new Message(String.format("\n%s\n", newGameMenu.getHeader()));
        msg.accept(this);
    }

    @Override
    public void visit(Move move) {
        System.out.printf("\tMove from %s to %s\n", pointToString(move.getSrc()), pointToString(move.dst));
    }

    @Override
    public void visit(Moves moves) {
        int i=1;
        ArrayList<Move> allMoves = moves.getMoves();
        for(Move move: allMoves) {
            System.out.printf("%s)", i);
            visit(move);
            i++;
        }
    }

    @Override
    public void visit(HumanPlayer player) {
        System.out.printf("%s (%s) ", player.getName(), player.getColor());
    }

    @Override
    public void visit(ComputerPlayer player) {
        System.out.printf("%s (%s) ",player.getName(), player.getColor());
    }

    @Override
    public void visit(Message massage) {
        System.out.print(massage.getText());
    }

    /* Helper Functions */
    private String pointToString(Point p) {
        return String.format("(%s, %d)", String.valueOf((char)(p.x + 65)), p.y+1);
    }
    private void printPiece(PlayerColor color, String pieceStr) {
        if(color == PlayerColor.RED) {
            pieceStr = RED + pieceStr + ENDC;
        }
        System.out.print(pieceStr);
    }
    private void initRowSeparator(int size) {
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
        ROW_SEPARATOR = sb.toString();
    }
    private void printColNumbers(int cols) {
        System.out.print(" ");
        for (int i = 1; i <= cols; ++i) {
            System.out.printf("   %d", i);
        }
        System.out.println(" ");
    }
}
