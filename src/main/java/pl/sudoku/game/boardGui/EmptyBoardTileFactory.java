package pl.sudoku.game.boardGui;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import pl.sudoku.game.controllers.BoardController;
import pl.sudoku.game.entities.Board;
import pl.sudoku.game.processing.BoardEngine;

public class EmptyBoardTileFactory extends DefaultBoardTileFactory {

    private DefaultBoardTileFactory decorated;
    private Board aBaseBoard;
    private Board aGameBoard;
    private final BoardEngine engine;
    private Label boardValues;
    private final BoardController controller;

    public EmptyBoardTileFactory(DefaultBoardTileFactory aTileFactory, Board aBaseBoard, Board aGameBoard, int xPosition, int yPosition, BoardEngine engine, BoardController controller) {
        super();
        decorated = aTileFactory;
        this.aGameBoard = aGameBoard;
        this.aBaseBoard = aBaseBoard;
        boardValues = new Label(String.valueOf(aBaseBoard.getSpecificValue(xPosition, yPosition)));
        this.engine = engine;
        this.controller = controller;
    }

    @Override
    public BoardTile prepareTile(int aX, int aY) {

        BoardTile boardTile = decorated.prepareTile(aX, aY);
        boardTile.getTextField().setStyle("-fx-border-color: black");
        BorderPane valuesPane = new BorderPane();
        if (aGameBoard.getSpecificValue(aX, aY) != 0) {
            boardTile.getTextField().setFont(Font.font("Comic Sans", 30));
            boardTile.getTextField().setStyle("-fx-font-weight: bold");
            boardTile.getTextField().setStyle("-fx-background-color: orchid");
            boardTile.getTextField().setText(String.valueOf(aGameBoard.getSpecificValue(aX, aY)));
            valuesPane.setCenter(boardTile.getTextField());
        } else {

            boardTile.getTextField();

        }

        setEvents(boardTile, aX, aY);
        return boardTile;
    }

    private void setEvents(BoardTile boardTile, int aX, int aY) {
        boardTile.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, (e) -> {
            boardTile.getTextField().setStyle("-fx-background-color: yellow");
        });
        boardTile.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, (e) -> {
            boardTile.getTextField().setStyle("-fx-background-color: white");
            boardTile.getTextField().setStyle("-fx-border-color: black");
            controller.throwInputError("");
        });
        boardTile.getTextField().addEventHandler(KeyEvent.KEY_TYPED, (e) -> {
            String character = e.getCharacter();
            try {
                int value = Integer.parseInt(character);

                if (value <= 0 || value > 9) {
                    controller.throwInputError("Podaj 1 < liczbę < 10 !");
                    boardTile.getTextField().setText("");
                    return;
                }
                aGameBoard.setSpecificValue(aX, aY, value);
                controller.refreshGui();
                System.out.println(character);
            } catch (NumberFormatException ex) {
                controller.throwInputError("Zły format!");
            }
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
