package pl.sudoku.game;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
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
        primaryStage.setTitle("Sudoku v.0.0.1-SNAPSHOT");

        Pane root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("start.fxml")));


        Scene myScene = new Scene(root,600,600);
        primaryStage.setScene(myScene);
        primaryStage.show();

    }

}

