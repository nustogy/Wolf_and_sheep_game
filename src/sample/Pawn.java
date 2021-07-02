package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Pawn extends Circle {

    protected int column;
    protected int row;


    Pawn(int col, int row) {
        this.column = col;
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public static Pawn[] getStartingPawns() {
        Pawn[] pawns = {
                new WolfPawn(7, 0),
                new SheepPawn(0, 7),
                new SheepPawn(2, 7),
                new SheepPawn(4, 7),
                new SheepPawn(6, 7)
        };

        for (int i = 0; i < pawns.length; i++) {
            if (i != 0) {
                pawns[i].setFill(Color.BLUEVIOLET);
            } else
                pawns[i].setFill(Color.YELLOW);
        }
        return pawns;
    }

    static boolean isPawnPlaced(Pawn pawn, BoardSquare square) {
        return (square.getColumn() == pawn.getColumn() && square.getRow() == pawn.getRow());
    }

    public boolean isMoveValid(BoardSquare square) {
        return square.getRow() == row - 1 && square.getColumn() == column + 1
                || square.getRow() == row - 1 && square.getColumn() == column - 1;

    }
}

