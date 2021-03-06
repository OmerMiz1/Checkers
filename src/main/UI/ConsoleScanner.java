package main.UI;

import main.Message;
import main.consts.GameType;
import main.consts.PlayerType;
import main.menus.MainMenu;
import main.menus.NewGameMenu;
import main.players.ComputerPlayer;
import main.players.HumanPlayer;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleScanner extends UIScanner {
    @Override
    public void visit(MainMenu mainMenu) {
        int input = scanInt();
        mainMenu.setSelectedOption(input);
    }

    @Override
    public void visit(NewGameMenu newGameMenu) {
        UIPrinter printer = new ConsolePrinter();

        String gameTypeStr = "Enter game type:\n" + generateOptionsMsg(newGameMenu.getGameTypeOptions());
        printer.print(new Message(gameTypeStr));
        newGameMenu.setGameType(GameType.values()[scanInt()]);

        for (int i = 0; i < 2; i++) {
            String nameStr = String.format("Enter player %d name:\n", i+1);
            printer.print(new Message(nameStr));
            newGameMenu.setPlayerName(scanStr(), i);

            String typeStr = String.format("Enter player %d type:\n%s", i+1, generateOptionsMsg(newGameMenu.getPlayerTypeOptions()));
            printer.print(new Message(typeStr));
            newGameMenu.setPlayerType(PlayerType.values()[scanInt()], i);
        }
    }

    @Override
    public void visit(HumanPlayer player) {
        int input = scanInt();
        player.setSelectedOption(input);
    }

    @Override
    public void visit(ComputerPlayer player) {

    }

    private Integer scanInt() {
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

    private  String scanStr() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private String generateOptionsMsg(ArrayList<String> options) {
        StringBuilder msgBuilder = new StringBuilder();

        for (int i = 0; i < options.size(); i++) {
            msgBuilder.append(String.format("%d %s\n", i+1, options.get(i)));
        }

        return msgBuilder.toString();
    }
}
