package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.function.Consumer;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox menu = new VBox(30);
        Label startLabel = new Label("Welcome to Wolf and sheep game");
        Button startButton = new Button("Start game");
        Label gameOverlabel = new Label();


        VBox gameOverMenu = new VBox(10);
        Button restartButton = new Button("Play again");

        gameOverMenu.setAlignment(Pos.CENTER);
        gameOverMenu.getChildren().addAll(gameOverlabel, restartButton);
        Scene gameOverScene = new Scene(gameOverMenu, 600, 800);


        Consumer<String> onGameEnd = winner -> {
            if (winner.equals("wolf")) {
                gameOverlabel.setText("The winner is wolf");
                primaryStage.setScene(gameOverScene);
            } else if (winner.equals("sheep")) {
                gameOverlabel.setText("The winner is sheep");
                primaryStage.setScene(gameOverScene);
            }
        };
        VBox gameView = prepareGameView(onGameEnd);

        Scene startScene = new Scene(menu, 800, 800);
        Scene gameScene = new Scene(gameView, 800, 800);
        menu.setAlignment(Pos.CENTER);
        menu.getChildren().addAll(startLabel, startButton);
        startButton.setOnAction(e -> {
            primaryStage.setScene(gameScene);
        });
        restartButton.setOnAction(e -> {
            VBox newGameView = prepareGameView(onGameEnd);
            Scene newGameScene = new Scene(newGameView, 800, 800);
            primaryStage.setScene(newGameScene);
        });
        primaryStage.setTitle("Wolf and sheep game");
        primaryStage.setScene(startScene);
        primaryStage.show();

    }

    VBox prepareGameView(Consumer<String> onGameEnd) {
        VBox gameView = new VBox(5);
        RadioButton sheepMove = new RadioButton("SHEEP");
        RadioButton wolfMove = new RadioButton("WOLF");
        Move move = new Move(sheepMove, wolfMove);

        Board board = new Board();
        board.createBoard(move, onGameEnd);
        board.setAlignment(Pos.CENTER);

        Label moveLabel = new Label("Who's move?");
        sheepMove.setDisable(true);
        wolfMove.setDisable(true);
        VBox whoIsMoveMenu = new VBox(5);
        whoIsMoveMenu.getChildren().addAll(moveLabel, sheepMove, wolfMove);
        whoIsMoveMenu.setAlignment(Pos.BASELINE_CENTER);
        gameView.getChildren().addAll(whoIsMoveMenu, board);

        return gameView;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
