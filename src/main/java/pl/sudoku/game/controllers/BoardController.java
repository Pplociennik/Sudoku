package pl.sudoku.game.controllers;

//import com.google.common.collect.Range;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import pl.sudoku.game.boardGui.BoardTile;
import pl.sudoku.game.boardGui.DefaultBoardTileFactory;
import pl.sudoku.game.boardGui.EmptyBoardTileFactory;
import pl.sudoku.game.boardGui.NotEmptyBoardTileFactory;
import pl.sudoku.game.entities.Board;
import pl.sudoku.game.processing.BoardEngine;

public class BoardController {

    @FXML
    GridPane gridMap;
    @FXML
    Button passButton;

    private BoardEngine boardEngine = new BoardEngine();
    private Board aBaseBoard = new Board(9);
    private Board aGameBoard = new Board(9);
    private Board aSolutionBoard = new Board(9);

    public BoardController() {

    }

    @FXML
    private void initialize() {
        boardEngine.generateNewMediumBoard(aGameBoard, aSolutionBoard);
        int[][] gameValues = aGameBoard.getValues();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                aBaseBoard.setSpecificValue(i, j, gameValues[i][j]);
            }
        }
        refreshGui();
    }

    public void refreshGui() {
        gridMap.getChildren().removeAll();
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {


                DefaultBoardTileFactory tileFactory = new DefaultBoardTileFactory();
                if (aBaseBoard.getSpecificValue(x, y) != 0) {
                    tileFactory = new NotEmptyBoardTileFactory(tileFactory, aGameBoard, x, y);
                } else {
                    tileFactory = new EmptyBoardTileFactory(tileFactory, aGameBoard, x, y, boardEngine, this);
                }
                BoardTile boardTile = tileFactory.prepareTile(x, y);

                gridMap.add(boardTile, x, y);

            }
        }
    }

}