package main.UI;

public abstract class UIScanner implements UIVisitor {
    public void scan(UIObject object) {
        object.accept(this);
    }
}
