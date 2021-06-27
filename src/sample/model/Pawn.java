package sample.model;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Pawn extends Circle {

    private int col;
    private int row;

    Pawn(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public static Pawn[] getStartingPawns() {
        Pawn[] pawns = {
                new WolfPawn(4, 1),
                new SheepPawn(0, 7),
                new SheepPawn(2, 7),
                new SheepPawn(4, 7),
                new SheepPawn(6, 7)
        };

        for (int i = 0; i < pawns.length; i++) {
            pawns[i].setRadius(30);
            if (i != 0) {
                pawns[i].setFill(Color.BLUEVIOLET);
            } else
                pawns[i].setFill(Color.YELLOW);
        }
        return pawns;
    }

    private static boolean isPawnPlaced(Pawn pawn, BoardSquare square) {
        return (square.getColumn() == pawn.getCol() && square.getRow() == pawn.getRow());
    }


    static void placePawnsInTheBoard(Pawn[] pawns, BoardSquare square, Board board) {
        StackPane field;

        board.add(square, square.getColumn(), square.getRow());

        for (int i = 0; i < pawns.length; i++) {
            if (isPawnPlaced(pawns[i], square)) {
                field = new StackPane();
                field.getChildren().addAll(square, pawns[i]);
                board.add(field, square.getColumn(), square.getRow());
                break;
            }

        }


    }

}

