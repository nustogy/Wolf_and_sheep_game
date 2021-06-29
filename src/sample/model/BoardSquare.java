package sample.model;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

public class BoardSquare extends Region {
    private Color color;
    private int column;
    private int row;
    private Pawn pawn;

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public void setColor(Color color) {
        this.color = color;
        BackgroundFill fill = new BackgroundFill(color, CornerRadii.EMPTY, new Insets(1));
        Background background = new Background(fill);
        setBackground(background);
    }

    public Color getColor() {
        return color;
    }

    public BoardSquare(int column, int row, Color color) {
        this.column = column;
        this.row = row;
        setColor(color);
        pawn = null;
    }

    public void highlight() {
        setColor(Color.ORANGE);
    }

    public void blacken() {
        if ((column + row) % 2 == 0)
            setColor(Color.BEIGE);
        else
            setColor(Color.BLACK);
    }


    public void setPawn(Pawn pawn) {
        this.pawn = pawn;
    }

    public boolean hasPawn() {
        return this.pawn != null;
    }
}
