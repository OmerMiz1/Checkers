package main;

public interface IVisitor {
    default void action(IVisitable visitable) {
        visitable.accept(this);
    }
}
