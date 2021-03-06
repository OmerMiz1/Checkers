package main.UI;

import main.Board;
import main.Message;
import main.Move;
import main.Moves;
import main.consts.GameType;
import main.consts.PlayerType;
import main.gamePieces.King;
import main.gamePieces.Pawn;
import main.gamePieces.TurkishKing;
import main.menus.MainMenu;
import main.menus.NewGameMenu;
import main.players.AbstractPlayer;
import main.players.ComputerPlayer;
import main.players.HumanPlayer;

import java.util.Scanner;

public class ConsoleScanner extends UIScanner {
    @Override
    public void visit(Board board) {

    }

    @Override
    public void visit(Pawn pawn) {

    }

    @Override
    public void visit(King king) {

    }

    @Override
    public void visit(TurkishKing turkishKing) {

    }

    @Override
    public void visit(MainMenu mainMenu) {
        int input = readInt();
        mainMenu.setSelectedOption(input);
    }

    @Override
    public void visit(NewGameMenu newGameMenu) {
        UIPrinter printer = new ConsolePrinter();
        Message msg;

        msg = new Message("Enter game type:\n1) Classic\n2) Turkish\n3) Burns\n");
        msg.accept(printer);
        newGameMenu.setGameType(GameType.values()[readInt()]);

        String nameMsg = "Enter player %d name:\n";
        String typeMsg = "Enter player %d type:\n1) Human\n2) Computer Easy\n";

        for (int i = 0; i < 2; i++) {
            msg = new Message(String.format(nameMsg, i+1));
            msg.accept(printer);
            newGameMenu.setPlayerName(readStr(), i);

            msg = new Message(String.format(typeMsg, i+1));
            msg.accept(printer);
            newGameMenu.setPlayerType(PlayerType.values()[readInt()], i);
        }
    }

    @Override
    public void visit(Move move) {
        System.out.println();
    }

    @Override
    public void visit(Moves moves) {

    }

    @Override
    public void visit(AbstractPlayer player) {

    }

    @Override
    public void visit(HumanPlayer player) {
        int input = readInt();
        player.setSelectedMove(input);
    }

    @Override
    public void visit(ComputerPlayer player) {

    }

    @Override
    public void visit(Message massage) {

    }

    public int readInt() {
        int result;
        Scanner scanner = new Scanner(System.in);

        while(true) {
            try {
                result = scanner.nextInt();
            } catch(Exception e) {
                scanner.next();
                continue;
            }
            break;
        }
        return result;
    }

    public String readStr() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
