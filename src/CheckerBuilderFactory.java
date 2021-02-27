import java.util.ArrayList;

public class CheckerBuilderFactory {
    // todo -> change builderName to enum or hash map!
    public CheckersBuilder checkersBuilder(String builderName) {
        // todo add ifs...
        if (builderName.equals("classic_builder")) {
            return new ClassicBuilder();
        } else
            return new ClassicBuilder();

    }
}

