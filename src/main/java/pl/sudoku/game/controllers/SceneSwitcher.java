package pl.sudoku.game.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.sudoku.game.entities.enums.Difficulties;

public class SceneSwitcher {

    public static final String BOARD_SCENE = "/sudoku.fxml";
    public static final String MAIN_MENU_SCENE = "/start.fxml";
    public static final String TUTORIAL_SCENE = "/tutorial.fxml";
    public static final String DIFFICULTIES_SCENE = "/levels.fxml";
    public static final String TOP_LIST_SCENE = "/toplist.fxml";

    public void switchScene(ActionEvent event, String source, Difficulties diff) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource(source));

            if (source == BOARD_SCENE) {
                BoardController controller = new BoardController();
                controller.setDifficulty(diff);
                loader.setController(controller);
            }

            Parent gamePane = loader.load();

            Scene gameScene = new Scene(gamePane);

            Stage window = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            window.setScene(gameScene);

            window.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
