public class Main {

    public static void main(String[] args) {
        System.out.println("hello world"); // TODO: delete
        //** need to add menu and delete all of this **//

        // Creating a factory that prepares builders
        CheckerBuilderFactory checkersBuilderFactory = new CheckerBuilderFactory();
        // TODO print menu + read input from user.
        CheckersBuilder checkersBuilder = checkersBuilderFactory.checkersBuilder("classic_builder");

        // Creating a CheckersDirector and than create game (checkers)
        CheckersDirector checkersDirector = new CheckersDirector();
        checkersDirector.setBuilder(checkersBuilder);
        checkersDirector.constructGame("shon", "omer");
        Checkers checkers = checkersDirector.getCheckers();

        checkers.run();
    }

}