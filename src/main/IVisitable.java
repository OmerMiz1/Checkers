package main;

public interface IVisitable {
    default void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
