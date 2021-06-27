package sample.model;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;

public class Board extends GridPane {

    public final static int boardHeight = 8;
    public final static int boardWidth = 8;


    public Board() {
    }

    public static void createBoard(Board board) {
        Color color;
        for (int column = 0; column < boardHeight; ++column) {

            for (int row = 0; row < boardWidth; ++row) {
                if((column+row)%2 ==0)
                    color = Color.BEIGE;
                else
                    color = Color.BLACK;


                BoardSquare square = new BoardSquare(color);
                board.add(square, column, row);
            }
        }

        for (int i = 0; i < boardWidth; i++) {
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setPercentWidth(100/boardWidth);
            board.getColumnConstraints().add(columnConstraints);
                    }

        for (int i = 0; i < boardHeight; i++) {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setPercentHeight(100/boardHeight);
            board.getRowConstraints().add(rowConstraints);
        }
    }


}
