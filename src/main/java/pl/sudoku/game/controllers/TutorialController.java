package pl.sudoku.game.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import pl.sudoku.game.entities.enums.Difficulties;

public class TutorialController {

    @FXML
    private void backToMenu(ActionEvent event) {
        new SceneSwitcher().switchScene(event, SceneSwitcher.MAIN_MENU_SCENE, Difficulties.MEDIUM);

    }
}
