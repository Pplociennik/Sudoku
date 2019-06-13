package pl.sudoku.game.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import pl.sudoku.game.boardGui.BoardTile;
import pl.sudoku.game.boardGui.DefaultBoardTileFactory;
import pl.sudoku.game.boardGui.EmptyBoardTileFactory;
import pl.sudoku.game.boardGui.NotEmptyBoardTileFactory;
import pl.sudoku.game.database.controllers.DatabaseController;
import pl.sudoku.game.database.entities.Result;
import pl.sudoku.game.entities.Board;
import pl.sudoku.game.entities.enums.Difficulties;
import pl.sudoku.game.processing.BoardEngine;
import pl.sudoku.game.processing.PointsCalculator;

import java.util.Date;
import java.util.Random;


public class BoardController {

    @FXML
    GridPane gridMap;
    @FXML
    private Button checkButton;
    @FXML
    private Label checkErrorLabel;
    @FXML
    private TextField nameTextField;
    @FXML
    private Label nameLabel;
    @FXML
    private Button submitNameButton;

    private SceneSwitcher sceneSwitcher = new SceneSwitcher();
    private int tipsCounter;

    private BoardEngine boardEngine = new BoardEngine();
    private Board aBaseBoard = new Board(9);
    private Board aGameBoard = new Board(9);
    private Board aSolutionBoard = new Board(9);

    PointsCalculator calculator = new PointsCalculator();
    DatabaseController databaseController = new DatabaseController();

    private Difficulties diff;

    public BoardController() {

    }

    @FXML
    private void checkSolution() {
        if (boardEngine.checkIfSolutionCorrect(aGameBoard, aSolutionBoard)) {
            checkErrorLabel.setTextFill(Color.GREEN);
            checkErrorLabel.setStyle("-fx-font-weight: bold");
            checkErrorLabel.setText("SUCCESS!");

            calculator.setEndTime(System.currentTimeMillis());

            nameLabel.setVisible(true);
            nameTextField.setVisible(true);
            submitNameButton.setVisible(true);
        } else {
            checkErrorLabel.setStyle("-fx-font-weight: bold");
            throwError("WRONG!");
        }
    }

    @FXML
    private void initialize() {
        startNewGame();
    }

    @FXML
    private void GiveUp(ActionEvent event) {
        new SceneSwitcher().switchScene(event, SceneSwitcher.MAIN_MENU_SCENE, Difficulties.MEDIUM);
    }

    @FXML
    private void giveMeATip() {

        int i, j;
        do {
            Random r = new Random();
            i = r.nextInt(9 * 9) / 9;
            j = r.nextInt(9 * 9) % 9;
            System.out.println(i + " " + j);
        } while (hasEmpty() && aBaseBoard.getSpecificValue(i, j) != 0);
        aGameBoard.setSpecificValue(i, j, aSolutionBoard.getSpecificValue(i, j));
        aBaseBoard.setSpecificValue(i, j, aSolutionBoard.getSpecificValue(i, j));
        tipsCounter++;
        refreshGui();
    }

    @FXML
    private void savePlayerResult(ActionEvent event) {
        Result result = new Result();
        result.setName(nameTextField.getText());
        result.setDate(new Date().toString());
        result.setPoints(calculator.countPlayerPoints(tipsCounter));

        databaseController.sendResult(result);
        sceneSwitcher.switchScene(event, SceneSwitcher.TOP_LIST_SCENE, Difficulties.MEDIUM);
    }

    private boolean hasEmpty() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (aGameBoard.getSpecificValue(i, j) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public void setDifficulty(Difficulties diff) {
        this.diff = diff;
    }

    public void throwError(String text) {
        checkErrorLabel.setText(text);
        checkErrorLabel.setTextFill(Color.RED);
    }

    public void startNewGame() {
        tipsCounter = 0;
        boardEngine.generateNewBoard(aGameBoard, aSolutionBoard, diff);
        int[][] gameValues = aGameBoard.getValues();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                aBaseBoard.setSpecificValue(i, j, gameValues[i][j]);
            }
        }
        refreshGui();
        calculator.setStartTime(System.currentTimeMillis());
        calculator.setDiff(diff);
    }

    public void refreshGui() {
        gridMap.getChildren().removeAll();
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {


                DefaultBoardTileFactory tileFactory = new DefaultBoardTileFactory();
                if (aBaseBoard.getSpecificValue(x, y) != 0) {
                    tileFactory = new NotEmptyBoardTileFactory(tileFactory, aGameBoard, x, y);
                } else {
                    tileFactory = new EmptyBoardTileFactory(tileFactory, aBaseBoard, aGameBoard, x, y, boardEngine, this);
                }
                BoardTile boardTile = tileFactory.prepareTile(x, y);

                gridMap.add(boardTile, x, y);
            }
        }
    }

}