package pl.sudoku.game.boardGui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import pl.sudoku.game.processing.BoardGenerator;

public class ValuesInBoardTile  extends DefaultBoardTileFactory {

    private  DefaultBoardTileFactory decorated;
    private  BoardGenerator boardGenerator ;
    private  Label boardValues;

    public ValuesInBoardTile(DefaultBoardTileFactory aTileFactory, BoardGenerator aboardGenerator,Integer xPosition,Integer yPosition) {
        super();
        decorated = aTileFactory;
        boardGenerator = aboardGenerator;
        boardValues = new Label(String.valueOf(boardGenerator.getMat()[xPosition][yPosition]));
    }
    @Override
    public BoardTile prepareTile(int aX, int aY) {
        BoardTile boardTile = decorated.prepareTile(aX, aY);
        BorderPane valuesPane = new BorderPane();
        boardValues.setFont(Font.font("Arial", 14));
        valuesPane.setCenter(boardValues);
        valuesPane.setAlignment(boardValues, Pos.CENTER);
        boardTile.getChildren().add(valuesPane);
        return boardTile;
    }
}
