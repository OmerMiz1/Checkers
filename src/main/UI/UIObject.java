package main.UI;

public interface UIObject {
    void accept(UIVisitor visitor);
}
