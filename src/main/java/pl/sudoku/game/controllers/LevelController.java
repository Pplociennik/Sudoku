package pl.sudoku.game.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import pl.sudoku.game.entities.enums.Difficulties;

public class LevelController {

    private BoardController boardController;

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

    @FXML
    private void showTutorial(ActionEvent event) {
        new SceneSwitcher().switchScene(event, SceneSwitcher.TUTORIAL_SCENE, Difficulties.MEDIUM);

    }

    @FXML
    private void showHighScores(ActionEvent event) {
        new SceneSwitcher().switchScene(event, SceneSwitcher.TOP_LIST_SCENE, Difficulties.MEDIUM);
    }


    @FXML
    private void exitGame() {
        System.exit(0);
    }
}
