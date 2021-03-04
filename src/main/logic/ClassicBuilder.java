package main.logic;

import main.Board;
import main.consts.PlayerColor;
import main.gamePieces.Pawn;

public class ClassicBuilder extends LogicBuilder {

    @Override
    public void buildBoard() {
        Board gameBoard = new Board(8); // Init board (8x8)
        boolean isDarkCell = true; // Pawns placed on dark cells

        // White pawns (rows 0-2, (0, 0) is first pawn)
        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < gameBoard.getSize(); col++) {
                if (isDarkCell){
                    gameBoard.set(row, col, new Pawn(PlayerColor.WHITE));
                }
                // Toggle last cell color
                isDarkCell = !isDarkCell;
            }

            //Switch starting color for next row
             isDarkCell = !isDarkCell;
        }

        // Black Pawns (rows 5-7, (5, 1) is first pawn)
        isDarkCell = false;
        for(int row = 5; row < gameBoard.getSize(); row++) {
            for(int col = 0; col < gameBoard.getSize(); col++) {
                if (isDarkCell)
                    gameBoard.set(row, col, new Pawn(PlayerColor.RED));
                //Toggle lastColor
                isDarkCell = !isDarkCell;
            }

            //Switch starting color for next row
             isDarkCell = !isDarkCell;
        }

        gameBoard.setRedPiecesCount(12);
        gameBoard.setWhitePiecesCount(12);
        super.board = gameBoard;
    }

    @Override
    public void buildLogic() {
        super.logic = new Classic();
    }
}
