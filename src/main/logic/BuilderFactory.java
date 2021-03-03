package main.logic;

public class BuilderFactory {

    // TODO: cond for each builder type
    public LogicBuilder checkersBuilder(String builderName) {
        // todo add ifs...
        if (builderName.equals("classic_builder")) {
            return new ClassicBuilder();
        } else if (builderName.equals("burns_builder")) {
            return new BurnsBuilder();
        } else if (builderName.equals("turkish_builder")) {
            return new TurkishBuilder();
        } else {
            return null;
        }
    }
}

