package main.logic;

import main.consts.GameType;

public class BuilderFactory {

    // TODO: cond for each builder type
    public LogicBuilder createLogicBuilder(GameType gameType) {
        switch (gameType) {
            case CLASSIC:
                return new ClassicBuilder();
            case TURKISH:
                return new TurkishBuilder();
            case BURNS:
                return new BurnsBuilder();
            default:
                return null;
        }
    }
}

