package sample.model;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

public class BoardSquare extends Region {
    private Color color;

    public BoardSquare(Color color) {
        this.color = color;
        BackgroundFill fill = new BackgroundFill(color, CornerRadii.EMPTY, new Insets(1));
        Background background = new Background(fill);
        setBackground(background);
    }

}
