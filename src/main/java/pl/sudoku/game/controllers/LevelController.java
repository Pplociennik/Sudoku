package pl.sudoku.game.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LevelController {

    private BoardController boardController = new BoardController();

    @FXML
    private Button StartNewGame;

    private void switchSceneToLevels(ActionEvent event) {
        try {

            Parent gamePane = FXMLLoader.load(getClass().getResource("/levels.fxml"));
            Scene gameScene = new Scene(gamePane);

            Stage window = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            window.setScene(gameScene);

            window.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void StartNewGame(ActionEvent event) {
        switchSceneToLevels(event);
    }
}
