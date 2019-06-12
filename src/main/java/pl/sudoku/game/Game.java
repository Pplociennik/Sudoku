package pl.sudoku.game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.Objects;

public class Game extends Application {

    public Game() {

    }

    public static void main(String[] args) {
        launch(args);


    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Sudoku v.0.4.5-SNAPSHOT");

        Pane root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("start.fxml")));

        Scene myScene = new Scene(root, 600, 600);
        primaryStage.setScene(myScene);
        primaryStage.show();

    }

}

