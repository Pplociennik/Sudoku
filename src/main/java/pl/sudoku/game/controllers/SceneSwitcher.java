package pl.sudoku.game.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneSwitcher {

    public static final String BOARD_SCENE = "/sudoku.fxml";
    public static final String MAIN_MENU_SCENE = "/start.fxml";
    public static final String TUTORIAL_SCENE = "/tutorial.fxml";
    public static final String DIFFICULTIES_SCENE = "/levels.fxml";

    public void switchScene(ActionEvent event, String source) {
        try {

            Parent gamePane = FXMLLoader.load(getClass().getResource(source));
            Scene gameScene = new Scene(gamePane);

            Stage window = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            window.setScene(gameScene);

            window.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
