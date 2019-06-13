package pl.sudoku.game.boardGui;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
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
    private String color = "white";

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
            boardTile.setStyle("-fx-background-color: orchid");
            boardTile.getTextField().setStyle("-fx-border-color: black");
            color = "orchid";
            boardTile.getTextField().setText(String.valueOf(aGameBoard.getSpecificValue(aX, aY)));
            boardTile.getTextField().setEditable(true);
            valuesPane.setCenter(boardTile);
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
            boardTile.getTextField().setStyle("-fx-background-color: " + color);
            boardTile.getTextField().setStyle("-fx-border-color: black");
            controller.throwError("");
        });
        boardTile.getTextField().addEventHandler(KeyEvent.KEY_TYPED, (e) -> {
            String character = e.getCharacter();
            try {
                int value = Integer.parseInt(character);

                if (value <= 0 || value > 9) {
                    controller.throwError("Enter 1 < number < 10 !");
                    boardTile.getTextField().setText("");
                    return;
                }
                aGameBoard.setSpecificValue(aX, aY, value);
                controller.refreshGui();
            } catch (NumberFormatException ex) {
                controller.throwError("Wrong format!");
            }
        });


    }
}
