package pl.sudoku.game.controllers;

//import com.google.common.collect.Range;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import pl.sudoku.game.boardGui.BoardTile;
import pl.sudoku.game.boardGui.DefaultBoardTileFactory;
import pl.sudoku.game.boardGui.ValuesInBoardTile;
import pl.sudoku.game.processing.BoardGenerator;

public class MainController {

    @FXML
    GridPane gridMap;
    @FXML
    Button passButton;

    public MainController() {

    }

    @FXML
    private void initialize() {



        refreshGui();
    }

    private void refreshGui() {
        int N = 9, K = 20;
        BoardGenerator sudoku = new BoardGenerator(N, K);
        sudoku.fillValues();
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y <9; y++) {


                DefaultBoardTileFactory tileFactory = new DefaultBoardTileFactory();
                tileFactory = new ValuesInBoardTile(tileFactory,sudoku,x,y);
                BoardTile boardTile = tileFactory.prepareTile(x, y);

                gridMap.add(boardTile, x, y);

            }
        }
    }

}