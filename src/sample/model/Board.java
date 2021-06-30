package sample.model;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class Board extends GridPane {

    public final static int boardHeight = 8;
    public final static int boardWidth = 8;
    public StackPane selectedFieldWithPawn;


    public Board() {
    }

    public static Board createBoard(Move move) {
        Board board = new Board();
        BoardSquare square;


      Pawn[] pawns = Pawn.getStartingPawns();
        for (int column = 0; column < boardHeight; ++column) {

            for (int row = 0; row < boardWidth; ++row) {
                Color color;
                if((column+row)%2 ==0)
                     color = Color.BEIGE;
                else
                    color = Color.BLACK;


                square = new BoardSquare(column, row, color);
             Pawn.placePawnsInTheBoard(pawns, square, board, move);


            }
        }

        for (int i = 0; i < boardWidth; i++) {
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setPercentWidth(90/boardWidth);
            board.getColumnConstraints().add(columnConstraints);
                    }

        for (int i = 0; i < boardHeight; i++) {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setPercentHeight(90/boardHeight);
            board.getRowConstraints().add(rowConstraints);
        }
        return board;
    }


}
