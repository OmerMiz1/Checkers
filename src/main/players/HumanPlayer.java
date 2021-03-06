package main.players;

import main.Board;
import main.Message;
import main.Move;
import main.Moves;
import main.UI.UIPrinter;
import main.UI.UIScanner;
import main.UI.UIVisitor;

import java.util.Scanner;

public class HumanPlayer extends AbstractPlayer {
    @Override
    public Move getMove(Board board, Moves possibleMoves, UIScanner scanner) {
        do {
            accept(scanner);
        } while(!(1 <= selectedOption && selectedOption <= possibleMoves.getSize()));

        return possibleMoves.getMove(selectedOption);
    }

    @Override
    public void accept(UIVisitor visitor) {
        visitor.visit(this);
    }

    public int getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedMove(int selectedOption) {
        this.selectedOption = selectedOption;
    }
}
