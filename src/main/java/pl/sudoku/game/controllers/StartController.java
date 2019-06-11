package pl.sudoku.game.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class StartController {

    @FXML
    private Button StartNewGame;

    @FXML
    void StartNewGame(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sudoku.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Sudoku v.0.0.1-SNAPSHOT");
            stage.setScene(new Scene(root1, 600, 600));
            stage.show();
            stage.setOnCloseRequest(e -> Platform.exit());

            stage.setScene(new Scene(root1, 600, 600));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
