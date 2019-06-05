package pl.sudoku.game.controllers;

//import com.google.common.collect.Range;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import pl.sudoku.game.boardGui.BoardTile;
import pl.sudoku.game.boardGui.DefaultBoardTileFactory;
import pl.sudoku.game.boardGui.ValuesInBoardTile;
import pl.sudoku.game.entities.Board;
import pl.sudoku.game.processing.BoardEngine;

public class MainController {

    @FXML
    GridPane gridMap;
    @FXML
    Button passButton;

    private BoardEngine boardEngine = new BoardEngine();
    private Board aGameBoard = new Board(9);
    private Board aSolutionBoard = new Board(9);

    public MainController() {

    }

    @FXML
    private void initialize() {
        boardEngine.generateNewMediumBoard(aGameBoard, aSolutionBoard);
        refreshGui();
    }

    private void refreshGui() {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {


                DefaultBoardTileFactory tileFactory = new DefaultBoardTileFactory();
                if (aGameBoard.getSpecificValue(x, y) != 0) {
                    tileFactory = new ValuesInBoardTile(tileFactory, aGameBoard, x, y);
                }
                BoardTile boardTile = tileFactory.prepareTile(x, y);

                gridMap.add(boardTile, x, y);

            }
        }
    }

}