package pl.sudoku.game.boardGui;

import javafx.scene.paint.Color;

public class DefaultBoardTileFactory {

    private BoardTile boardTile;

    public BoardTile prepareTile(int aX, int aY) {

        boardTile = new BoardTile(aX, aY);
        boardTile.getTextField().setStyle("-fx-fill: white");
        boardTile.getTextField().setStyle("-fx-stroke: white");

        return boardTile;

    }

}