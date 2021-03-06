package main;

import main.UI.UIObject;
import main.UI.UIVisitor;

import java.awt.*;
import java.util.ArrayList;

public class Message implements UIObject {
    private String text;

    public Message(String text) {
        this.text = text;
    }

    @Override
    public void accept(UIVisitor visitor) {
        visitor.visit(this);
    }

    public String getText() {
        return this.text;
    }
}
