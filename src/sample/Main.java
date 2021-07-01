package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.model.Board;
import sample.model.Move;
import java.util.function.Consumer;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox menu = new VBox(30);
        VBox gameView = new VBox(5);
        Label startLabel = new Label("Welcome to Wolf and sheep game");
        Button startButton = new Button("Start game");
        // TODO: 30.06.2021 save and upload saved game from the file
        RadioButton sheepMove = new RadioButton("SHEEP");
        RadioButton wolfMove = new RadioButton("WOLF");
        Move move = new Move(sheepMove, wolfMove);
        Button uploadButton = new Button("Continue saved game");
        Label gameOverlabel= new Label();


        VBox gameOverMenu = new VBox(10);
        Button restartButton = new Button("Play again");

        gameOverMenu.setAlignment(Pos.CENTER);
        gameOverMenu.getChildren().addAll(gameOverlabel, restartButton);
        Scene gameOverScene = new Scene(gameOverMenu, 600, 800);


        Consumer<String> onGameEnd = winner -> {

            if (winner.equals("wolf")){
                gameOverlabel.setText("The winner is wolf");
                primaryStage.setScene(gameOverScene);
            } else if (winner.equals("sheep")){
                gameOverlabel.setText("The winner is sheep");
                primaryStage.setScene(gameOverScene);
            }

        };
        Board board = Board.createBoard(move, onGameEnd);
        board.setAlignment(Pos.BOTTOM_CENTER);

        Label moveLabel = new Label("Who's move?");
        sheepMove.setDisable(true);
        wolfMove.setDisable(true);


        gameView.getChildren().addAll(moveLabel, sheepMove, wolfMove, board);
        Scene startScene = new Scene(menu, 600, 800);
        Scene gameScene = new Scene(gameView, 600, 800);
        menu.setAlignment(Pos.CENTER);
        menu.getChildren().addAll(startLabel, startButton, uploadButton);
        startButton.setOnAction(e -> {
            primaryStage.setScene(gameScene);
        });
        // TODO: 01.07.2021 restart button 
        restartButton.setOnAction(e -> {
            
        });
        primaryStage.setTitle("Wolf and sheep game");
        primaryStage.setScene(startScene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
