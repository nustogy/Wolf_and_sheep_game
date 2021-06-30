package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.model.Board;
import sample.model.BoardSquare;
import sample.model.Pawn;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox menu = new VBox(30);
        Label startLabel = new Label("Welcome to Wolf and sheep game");
        Button startButton = new Button("Start game");
        // TODO: 30.06.2021 save and upload saved game from the file
        Button uploadButton = new Button("Continue saved game");
        Board board = Board.createBoard();
        Scene scene1 = new Scene(menu, 600, 600);
        Scene scene = new Scene(board, 600, 600);
        menu.setAlignment(Pos.CENTER);
        menu.getChildren().addAll(startLabel, startButton, uploadButton);
        startButton.setOnAction(e->{
            primaryStage.setScene(scene);
        });
        primaryStage.setTitle("Wolf and sheep game");
        primaryStage.setScene(scene1);
        primaryStage.show();

    }




    public static void main(String[] args) {
        launch(args);
    }
}
