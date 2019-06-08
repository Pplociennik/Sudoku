package pl.sudoku.game.boardGui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import pl.sudoku.game.controllers.BoardController;
import pl.sudoku.game.entities.Board;

public class InputScene extends Scene {

    private Label inputText;
    private TextField inputField;
    private Button insert;

    public InputScene(double width, double height, Board aGameBoard, Integer aX, Integer aY, BoardController controller) {
        super(new VBox(), width, height);

        prepareInputText();
        prepareInputField();
        prepareInsertButton(aGameBoard, aX, aY, controller);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(inputText, inputField, insert);
        setRoot(vBox);
    }

    private void prepareInputText() {
        inputText = new Label("Podaj liczbę z zakresu 1 - 9:");
        inputText.setAlignment(Pos.TOP_CENTER);
        inputText.setPrefSize(300, 90);
    }

    private void prepareInputField() {
        inputField = new TextField();
        inputField.setAlignment(Pos.CENTER);
    }

    private void prepareInsertButton(Board aGameBoard, Integer aX, Integer aY, BoardController controller) {
        insert = new Button("Wstaw");
        insert.setAlignment(Pos.BOTTOM_CENTER);
//
        insert.setPrefSize(300, 90);
        insert.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, (e) -> {
            try {
                int value = Integer.parseInt(inputField.getText());

                if (value < 1 || value > 9) {
                    inputText.setTextFill(Color.RED);
                    inputText.setText("Podaj 1 < cyfrę < 9 !");
                    return;
                }

                aGameBoard.setSpecificValue(aX, aY, value);
                controller.refreshGui();
                Stage toClose = (Stage) getWindow();
                toClose.close();
            } catch (NumberFormatException n) {
                inputText.setTextFill(Color.RED);
                inputText.setText("Zły typ!");
            }
        });
    }
}
