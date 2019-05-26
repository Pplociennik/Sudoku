package pl.sudoku.game.board-gui;

import javafx.scene.paint.Color;

public class DefaultBoardTileFactory {

    private BoardTile boardTile;

    public BoardTile prepareTile(int aX, int aY){

        boardTile = new BoardTile(aX, aY);
        boardTile.getRect().setFill(Color.WHITE);
        boardTile.getRect().setStroke(Color.BLACK);
        return boardTile;

    }

}