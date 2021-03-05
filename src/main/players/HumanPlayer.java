package main.players;

import main.Board;
import main.Massage;
import main.Move;
import main.UI.UIVisitor;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Scanner;

public class HumanPlayer extends AbstractPlayer {
    @Override
    public Move getMove(Board board, ArrayList<Move> possibleMoves, UIVisitor visitor) {

        //todo change Scanner to visitor
        Scanner myObj = new Scanner(System.in);
        Move selectedMove;
        while (true) {
            try {
                int chooseNumber = myObj.nextInt();
                selectedMove = possibleMoves.get(chooseNumber - 1);
            } catch (Exception e) {
                Massage chooseMassage = new Massage("Invalid selection, please try again\n");
                chooseMassage.accept(visitor);
                continue;
            }
            return selectedMove;
        }

    }
}
