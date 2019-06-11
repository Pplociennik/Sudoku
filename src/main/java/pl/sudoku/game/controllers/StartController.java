package pl.sudoku.game.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class StartController {

    @FXML
    private Button EasyGame;
    @FXML
    private Button MediumGame;
    @FXML
    private Button HardGame;

    BoardController boardController = new BoardController();

    private void switchSceneToBoard(ActionEvent event) {
        try {

            Parent gamePane = FXMLLoader.load(getClass().getResource("/sudoku.fxml"));
            Scene gameScene = new Scene(gamePane);

            Stage window = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            window.setScene(gameScene);

            window.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
