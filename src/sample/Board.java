package sample;

import javafx.beans.binding.Bindings;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.function.Consumer;

public class Board extends GridPane {

    public final static int boardHeight = 8;
    public final static int boardWidth = 8;
    public StackPane selectedFieldWithPawn;
    private Pawn[] pawns = Pawn.getStartingPawns();

    public void createBoard(Move move, Consumer<String> onGameEnd) {
        BoardSquare boardSquare;
        for (int column = 0; column < boardHeight; ++column) {
            for (int row = 0; row < boardWidth; ++row) {
                Color color;
                if ((column + row) % 2 == 0)
                    color = Color.BEIGE;
                else
                    color = Color.BLACK;

                boardSquare = new BoardSquare(column, row, color);
                placePawnsInTheBoard(boardSquare, move, onGameEnd);
            }
        }

        for (int i = 0; i < boardWidth; i++) {
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setPercentWidth(95 / boardWidth);
            this.getColumnConstraints().add(columnConstraints);
        }

        for (int i = 0; i < boardHeight; i++) {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setPercentHeight(95 / boardHeight);
            this.getRowConstraints().add(rowConstraints);
        }
    }

    private void placePawnsInTheBoard(BoardSquare boardSquare, Move move, Consumer<String> onGameEnd) {
        StackPane field = new StackPane();

        field.getChildren().add(boardSquare);
        this.add(field, boardSquare.getColumn(), boardSquare.getRow());

        for (int i = 0; i < pawns.length; i++) {
            if (Pawn.isPawnPlaced(pawns[i], boardSquare)) {
                boardSquare.setPawn(pawns[i]);
                field.getChildren().add(pawns[i]);
                pawns[i].radiusProperty().bind(Bindings.when(field.heightProperty().lessThan(field.widthProperty()))
                        .then(field.widthProperty().subtract(10).divide(2))
                        .otherwise(field.heightProperty().subtract(10).divide(2)));
                break;
            }
        }

        if (boardSquare.getColor() == Color.BLACK) {

            field.setOnMouseClicked(e -> {
                Class currentPawnClassTurn = move.isSheepMove() ? SheepPawn.class : WolfPawn.class;

                if (boardSquare.hasPawn(currentPawnClassTurn) && selectedFieldWithPawn == null) {
                    //first click
                    boardSquare.highlight();
                    selectedFieldWithPawn = field;
                } else if (!boardSquare.hasPawn() && selectedFieldWithPawn != null) {
                    //second click
                    Pawn movingPawn = (Pawn) selectedFieldWithPawn.getChildren().get(1);
                    if (movingPawn.isMoveValid((BoardSquare) field.getChildren().get(0))) {

                        //leaving boardSquare methods
                        selectedFieldWithPawn.getChildren().remove(1);
                        BoardSquare leavingSquare = (BoardSquare) selectedFieldWithPawn.getChildren().get(0);
                        leavingSquare.blacken();
                        leavingSquare.setPawn(null);

                        //arriving boardSquare methods
                        field.getChildren().add(movingPawn);
                        boardSquare.setPawn(movingPawn);
                        movingPawn.setColumn(boardSquare.getColumn());
                        movingPawn.setRow(boardSquare.getRow());

                        //board management
                        selectedFieldWithPawn = null;
                        move.changeMove();

                        //checking winner
                        WolfPawn wolfPawn = (WolfPawn) pawns[0];
                        if (wolfPawn.isWolfWinner()) {
                            onGameEnd.accept("wolf");
                        } else if (wolfPawn.isWolfBlocked(pawns)) {
                            onGameEnd.accept("sheep");
                        }
                    }

                } else if (boardSquare.hasPawn() && selectedFieldWithPawn != null &&
                        selectedFieldWithPawn.getChildren().get(0).equals(boardSquare)) {
                    // pawn change
                    boardSquare.blacken();
                    selectedFieldWithPawn = null;
                }

            });
        }
    }
}
