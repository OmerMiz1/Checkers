package main;

import main.UI.UIPrinter;
import main.UI.UIScanner;

public interface MyRunnable {
    MyRunnable run(UIPrinter printer, UIScanner scanner);
}
