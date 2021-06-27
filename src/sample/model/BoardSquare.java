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

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public BoardSquare(int column, int row, Color color) {
        this.column = column;
        this.row = row;
        this.color = color;
        BackgroundFill fill = new BackgroundFill(color, CornerRadii.EMPTY, new Insets(1));
        Background background = new Background(fill);
        setBackground(background);
    }

}
