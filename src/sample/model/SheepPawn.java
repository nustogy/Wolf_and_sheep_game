package sample.model;

public class SheepPawn extends Pawn{

    public static final int numberOfSheep = 4;

    SheepPawn(int col, int row) {
        super(col, row);
    }

    @Override
    public boolean isMoveValid(BoardSquare square) {
        return super.isMoveValid(square);

    }
}
