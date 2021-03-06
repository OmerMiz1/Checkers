package main.logic;

import main.logic.Burns;
import main.logic.ClassicBuilder;

public class BurnsBuilder extends ClassicBuilder {
    @Override
    public void buildBoard() {
        super.buildBoard();
    }

    @Override
    public void buildLogic() {
        super.logic = new Burns();
    }
}
