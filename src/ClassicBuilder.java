public class ClassicBuilder extends CheckersBuilder{

    @Override
    public void buildBoard() {
        //Preparation of a empty board (8 by 8)
        Board gameBoard = new Board(8, 8);

        // Adding white pawn (lines 0 to 2) [in 0,0 first white pawn]
        boolean lastColor = true;
        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < gameBoard.getCols(); col++) {
                if (lastColor)
                    gameBoard.board[row][col] = new Pawn(Color.white);
                //Toggle lastColor
                lastColor = !lastColor;
            }
            //Switch starting color for next row
            lastColor = !lastColor;
        }

        // Adding black pawn (lines 5 to 7) [in 5,1 first white pawn]
        lastColor = false;
        for(int row = 5; row < gameBoard.getRows(); row++) {
            for(int col = 0; col < gameBoard.getCols(); col++) {
                if (lastColor)
                    gameBoard.board[row][col] = new Pawn(Color.black);
                //Toggle lastColor
                lastColor = !lastColor;
            }
            //Switch starting color for next row
            lastColor = !lastColor;
        }

        gameBoard.setBlackPieces(12);
        gameBoard.setWhitePieces(12);
        super.board = gameBoard;
    }

    @Override
    public void buildLogic() {
        super.logic = new Classic();
    }
}
