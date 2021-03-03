package main.menus;

import main.IPrinter;

import java.util.HashMap;
import java.util.function.Function;

public interface IMenu {
    String[] options = null;
    HashMap<String, Function> operations = null;
    IPrinter printer = null;

    void print();
}
