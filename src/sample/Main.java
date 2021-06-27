package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.model.Board;
import sample.model.BoardSquare;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {

        Scene scene = new Scene(Board.createBoard(), 600, 600);
        primaryStage.setTitle("Wolf and sheep game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
}
