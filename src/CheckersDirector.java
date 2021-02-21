import java.util.ArrayList;

/** Director **/
public class CheckersDirector{
    private CheckersBuilder builder;

    // Set builder
    public void setBuilder(CheckersBuilder builder) {
        this.builder = builder;
    }

    public Checkers getCheckers() {
        return builder.getGame();
    }

    public void constructGame(String name1, String name2) {
        // Prepares checkerModeFactory to create the players who play
        // todo Maybe take out so he does not contain the checkerModeFactory
        CheckerModeFactory checkerModeFactory = new CheckerModeFactory();
        builder.setPlayer(checkerModeFactory.getPlayers(name1, name2));
        builder.buildBoard();
        builder.buildLogic();
    }

}
