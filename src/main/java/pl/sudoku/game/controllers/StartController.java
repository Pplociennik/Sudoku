package pl.sudoku.game.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import pl.sudoku.game.entities.enums.Difficulties;


public class StartController {

    @FXML
    private Button EasyGame;
    @FXML
    private Button MediumGame;
    @FXML
    private Button HardGame;

    BoardController boardController = new BoardController();

    private void switchSceneToBoard(ActionEvent event, Difficulties diff) {
        new SceneSwitcher().switchScene(event, SceneSwitcher.BOARD_SCENE, diff);

    }


    @FXML
    void EasyGame(ActionEvent event) {
        switchSceneToBoard(event, Difficulties.EASY);
    }

    @FXML
    void MediumGame(ActionEvent event) {
        switchSceneToBoard(event, Difficulties.MEDIUM);
    }

    @FXML
    void HardGame(ActionEvent event) {
        switchSceneToBoard(event, Difficulties.HARD);
    }


}
