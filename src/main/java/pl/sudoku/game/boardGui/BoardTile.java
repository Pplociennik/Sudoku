package pl.sudoku.game.boardGui;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.TextField;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Font;
import java.awt.*;
import java.awt.event.KeyEvent;

public class BoardTile extends StackPane {

    private final Point position;
    private  final TextField textField;
    BoardTile(int aX, int aY) {

        position = new Point(aX, aY);
        textField = new TextField();
        textField.setPrefSize(60,60);
        textField.setFont(Font.font("Comic Sans", FontWeight.BOLD, FontPosture.REGULAR, 30));
       getChildren().add(textField);
    }


    public TextField getTextField() {
        return textField;
    }

    Point getPosition() {
        return position;
    }

}