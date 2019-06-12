package pl.sudoku.game.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class TutorialController {

    @FXML
    private void backToMenu(ActionEvent event) {
        new SceneSwitcher().switchScene(event, SceneSwitcher.MAIN_MENU_SCENE);

    }
}
