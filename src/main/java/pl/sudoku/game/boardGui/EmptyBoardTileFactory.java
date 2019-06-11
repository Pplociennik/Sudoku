package pl.sudoku.game.boardGui;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import pl.sudoku.game.controllers.BoardController;
import pl.sudoku.game.entities.Board;
import pl.sudoku.game.processing.BoardEngine;

import java.awt.event.KeyListener;

public class EmptyBoardTileFactory extends DefaultBoardTileFactory  {

    private DefaultBoardTileFactory decorated;
    private Board aGameBoard;
    private final BoardEngine engine;
    private Label boardValues;
    private final BoardController controller;
    private Paint color;
    private  final TextField textField = null;
    public EmptyBoardTileFactory(DefaultBoardTileFactory aTileFactory, Board aGameBoard, int xPosition, int yPosition, BoardEngine engine, BoardController controller) {
        super();
        decorated = aTileFactory;
        this.aGameBoard = aGameBoard;
        boardValues = new Label(String.valueOf(aGameBoard.getSpecificValue(xPosition, yPosition)));
        this.engine = engine;
        this.controller = controller;
    }

    @Override
    public BoardTile prepareTile(int aX, int aY) {

        BoardTile boardTile = decorated.prepareTile(aX, aY);
        color = Color.GRAY;
        BorderPane valuesPane = new BorderPane();
        if (Integer.parseInt(boardValues.getText()) != 0) {
            boardValues.setFont(Font.font("Comic Sans", 30));
            boardValues.setStyle("-fx-font-weight: bold");
            valuesPane.setCenter(boardValues);
            color = Color.ORCHID;
        }
        else{

            boardTile.getTextField();

        }

        setEvents(boardTile, aX, aY);
        return boardTile;
    }

    private void setEvents(BoardTile boardTile, int aX, int aY) {
//        boardTile.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, (e) -> {
//            boardTile.getTextField().setStyle("-fx-background-color: yellow");
//        });
//        boardTile.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, (e) -> {
//            boardTile.getTextField().setStyle("-fx-background-color: green");
//        });
        boardTile.getTextField().addEventHandler(KeyEvent.KEY_TYPED, (e) -> {
                  System.out.println(e.getCharacter());
                  /** TODO
                   *  CHECKING IF e exist in 3x3 row or column
                   *
                   *
                   * **/
                });
//        boardTile.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
//            boardTile.getRect().setFill(Color.YELLOW);
//            color = Color.YELLOW;
//
////            boardTile.addEventHandler(KeyEvent.KEY_TYPED, (k) -> {
////                if (Integer.parseInt(k.getText()) > 0 && Integer.parseInt(k.getText()) < 10)
////                    aGameBoard.setSpecificValue(aX, aY, Integer.parseInt(k.getText()));
////            });
//
//
//            boardTile.getRect().setFill(Color.ORCHID);
//            color = Color.ORCHID;
//        });
//    }

    }
}
