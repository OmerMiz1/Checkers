package main.IO;

public interface IPrintable {
    default void accept(IPrinter printer) {
        printer.print(this);
    }
}
