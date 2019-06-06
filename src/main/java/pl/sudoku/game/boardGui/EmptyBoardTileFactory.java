package pl.sudoku.game.boardGui;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import pl.sudoku.game.controllers.MainController;
import pl.sudoku.game.entities.Board;
import pl.sudoku.game.processing.BoardEngine;

public class EmptyBoardTileFactory extends DefaultBoardTileFactory {

    private DefaultBoardTileFactory decorated;
    private Board aGameBoard;
    private final BoardEngine engine;
//    private Label boardValues;
    private final MainController controller;

    public EmptyBoardTileFactory(DefaultBoardTileFactory aTileFactory, Board aGameBoard, int xPosition, int yPosition, BoardEngine engine, MainController controller) {
        super();
        decorated = aTileFactory;
        this.aGameBoard = aGameBoard;
//        boardValues = new Label(String.valueOf(aGameBoard.getSpecificValue(xPosition, yPosition)));
        this.engine = engine;
        this.controller = controller;
    }

    @Override
    public BoardTile prepareTile(int aX, int aY) {
        BoardTile boardTile = decorated.prepareTile(aX, aY);
        boardTile.getRect().setFill(Color.GRAY);
        BorderPane valuesPane = new BorderPane();
        boardTile.getChildren().add(valuesPane);
        boardTile.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, (e) -> {
            Stage inputStage = new Stage();
            inputStage.setTitle("Wprowadż wartość");
            Scene inputScene = new InputScene(200, 100, aGameBoard, aX, aY, controller);
            inputStage.setScene(inputScene);
            inputStage.show();
        });
        return boardTile;
    }

}
