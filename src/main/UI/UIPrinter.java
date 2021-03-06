package main.UI;

// TODO maybe should be empty or just make a package named Printer\Output under UI
public abstract class UIPrinter implements UIVisitor {
    public void print(UIObject object) {
        object.accept(this);
    }

//    abstract void printMessage(String msg);
}