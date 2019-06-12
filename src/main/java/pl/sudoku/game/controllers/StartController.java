package pl.sudoku.game.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class StartController {

    @FXML
    private Button EasyGame;
    @FXML
    private Button MediumGame;
    @FXML
    private Button HardGame;

    BoardController boardController = new BoardController();

    private void switchSceneToBoard(ActionEvent event) {
        new SceneSwitcher().switchScene(event, SceneSwitcher.BOARD_SCENE);

    }


    @FXML
    void EasyGame(ActionEvent event) {
        switchSceneToBoard(event);
    }

    @FXML
    void MediumGame(ActionEvent event) {
        switchSceneToBoard(event);
    }

    @FXML
    void HardGame(ActionEvent event) {
        switchSceneToBoard(event);
    }


}
