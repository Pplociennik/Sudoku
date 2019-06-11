package pl.sudoku.game.boardGui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import pl.sudoku.game.entities.Board;



public class NotEmptyBoardTileFactory extends DefaultBoardTileFactory {

    private DefaultBoardTileFactory decorated;
    private Board aGameBoard;
    private final Label boardValues;

    public NotEmptyBoardTileFactory(DefaultBoardTileFactory aTileFactory, Board aGameBoard, int xPosition, int yPosition) {
        super();
        decorated = aTileFactory;
        this.aGameBoard = aGameBoard;
        boardValues = new Label(String.valueOf(aGameBoard.getSpecificValue(xPosition, yPosition)));
    }

    @Override
    public BoardTile prepareTile(int aX, int aY) {
        BoardTile boardTile = decorated.prepareTile(aX, aY);
        boardTile.getTextField().setStyle("-fx-background-color: gray");
        BorderPane valuesPane = new BorderPane();
        boardValues.setFont(Font.font("Comic Sans", 30));
        boardValues.setStyle("-fx-font-weight: bold");
        valuesPane.setCenter(boardValues);
        valuesPane.setAlignment(boardValues, Pos.CENTER);
        boardTile.getChildren().add(valuesPane);
        boardTile.getTextField().setEditable(false);

        return boardTile;
    }
}
