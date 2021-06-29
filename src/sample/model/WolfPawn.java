package sample.model;

import javafx.scene.shape.Circle;

public class WolfPawn extends Pawn{

    WolfPawn(int col, int row) {
        super(col, row);
    }

    @Override
    public boolean isMoveValid(BoardSquare square) {
        return super.isMoveValid(square)
                || square.getRow() == row + 1 && square.getColumn() == col + 1
                || square.getRow() == row + 1 && square.getColumn() == col - 1;
    }
}
