package pl.sudoku.game.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;


public class StartController {

    @FXML
    private Button EasyGame;
    @FXML
    private Button MediumGame;
    @FXML
    private Button HardGame;


    @FXML
    void EasyGame(ActionEvent event) {

        try {
            Stage stage = new Stage();
            stage.setTitle("Sudoku v.0.0.1-SNAPSHOT");
            AnchorPane myPane = null;
            myPane = FXMLLoader.load(getClass().getResource("/sudoku.fxml"));
            Scene scene = new Scene(myPane,750,600);
            stage.setScene(scene);

//            prevStage.close();

            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void MediumGame (ActionEvent event) {

        try {
            Stage stage = new Stage();
            stage.setTitle("Sudoku v.0.0.1-SNAPSHOT");
            AnchorPane myPane = null;
            myPane = FXMLLoader.load(getClass().getResource("/sudoku.fxml"));
            Scene scene = new Scene(myPane,750,600);
            stage.setScene(scene);

//            prevStage.close();

            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void HardGame (ActionEvent event) {

        try {
            Stage stage = new Stage();
            stage.setTitle("Sudoku v.0.0.1-SNAPSHOT");
            AnchorPane myPane = null;
            myPane = FXMLLoader.load(getClass().getResource("/sudoku.fxml"));
            Scene scene = new Scene(myPane,750,600);
            stage.setScene(scene);

//            prevStage.close();

            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
