package pl.sudoku.game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.sudoku.game.processing.BoardGenerator;

import java.io.IOException;

public class Game extends Application {

    public Game() {

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {



        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sudoku.fxml"));
        primaryStage.setTitle("Sudoku v.0.0.1-SNAPSHOT");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

}

