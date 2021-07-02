package sample;

public class SheepPawn extends Pawn{

    public static final int numberOfSheep = 4;

    SheepPawn(int column, int row) {
        super(column, row);
    }

    @Override
    public boolean isMoveValid(BoardSquare square) {
        return super.isMoveValid(square);

    }
}
