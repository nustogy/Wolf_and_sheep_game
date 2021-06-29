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
        StackPane field = new StackPane();


        field.getChildren().add(square);
        board.add(field, square.getColumn(), square.getRow());

        for (int i = 0; i < pawns.length; i++) {
            if (isPawnPlaced(pawns[i], square)) {
                Pawn pawn = pawns[i];
                square.setPawn(pawns[i]);
                field.getChildren().add(pawns[i]);
                break;
            }
        }

        if(square.getColor() == Color.BLACK) {

            field.setOnMouseClicked(e -> {
                // TODO: 29.06.2021 pawn change during move
                if (square.hasPawn() && board.selectedFieldWithPawn == null) {
                    square.highlight();
                    board.selectedFieldWithPawn = field;
                }

                if (!square.hasPawn() && board.selectedFieldWithPawn != null) {
                    Pawn movingPawn = (Pawn) board.selectedFieldWithPawn.getChildren().get(1);
                    board.selectedFieldWithPawn.getChildren().remove(1);
                   BoardSquare leavingSquare = (BoardSquare) board.selectedFieldWithPawn.getChildren().get(0);
                   leavingSquare.blacken();
                   field.getChildren().add(movingPawn);
                   square.setPawn(movingPawn);
                   leavingSquare.setPawn(null);
                   board.selectedFieldWithPawn = null;

                }
            });
        }
    }

//    public void movePawn( BoardSquare destinationSquare)

}

