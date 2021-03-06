package main;

import main.UI.*;
import main.menus.MainMenu;

public class Main {
    public static void main(String[] args) {
        UIPrinter printer = new ConsolePrinter();
        UIScanner scanner = new ConsoleScanner();

        MyRunnable runnable = new MainMenu();

        while(runnable != null) {
            runnable = runnable.run(printer, scanner);
        }
    }
}