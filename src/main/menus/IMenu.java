package main.menus;

import main.IPrintable;
import main.IPrinter;

import java.util.HashMap;
import java.util.function.Function;

public interface IMenu extends IPrintable {
    String[] options = null;
    HashMap<String, Function> operations = null;

    default void accept(IPrinter printer) {
        printer.print(this);
    }
}
