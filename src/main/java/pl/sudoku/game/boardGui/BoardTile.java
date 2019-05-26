package pl.sudoku.game.boardGui;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

import java.awt.*;

public class BoardTile extends StackPane {

    private final Rectangle rect;
    private final Point position;

    BoardTile(int aX, int aY) {

        position = new Point(aX, aY);
        rect = new Rectangle(60, 60);

        getChildren().add(rect);
    }

    public Rectangle getRect() {
        return rect;
    }

    Point getPosition() {
        return position;
    }

}