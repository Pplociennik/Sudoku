package pl.sudoku.game.controllers;

//import com.google.common.collect.Range;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import pl.sudoku.game.boardGui.BoardTile;
import pl.sudoku.game.boardGui.DefaultBoardTileFactory;

public class MainController {

    @FXML
    GridPane gridMap;
    @FXML
    Button passButton;

    public MainController() {

    }

    @FXML
    private void initialize() {

    }

    private void refreshGui() {

        for (int x = 0; x <= 5; x++) {
            for (int y = 0; y <= 5; y++) {

                DefaultBoardTileFactory tileFactory = new DefaultBoardTileFactory();
                BoardTile boardTile = tileFactory.prepareTile(x, y);
                gridMap.add(boardTile, x, y);

            }
        }
    }

}