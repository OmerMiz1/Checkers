import java.util.ArrayList;

public class CheckerBuilderFactory {

    // TODO: cond for each builder type
    public CheckersBuilder checkersBuilder(String builderName) {
        // todo add ifs...
        if (builderName.equals("classic_builder")) {
            return new ClassicBuilder();
        } else
            return new ClassicBuilder();

    }
}

