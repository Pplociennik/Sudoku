package pl.sudoku.game.processing;

import pl.sudoku.game.entities.Board;
import pl.sudoku.game.entities.enums.Difficulties;

import java.util.Arrays;

public class BoardEngine {

    private BoardGenerator boardGenerator = new BoardGenerator();

    private void generateBoardAndSolution(Board aGameBoard, Board aSolutionBoard, Integer aBoardSize, Difficulties aDifficulty) {
        boardGenerator.prepare(aBoardSize, aDifficulty.getDiffCode());
        boardGenerator.fillValues();
        aSolutionBoard.setValues(boardGenerator.getMat());
        boardGenerator.removeKDigits();
        aGameBoard.setValues(boardGenerator.getMat());
    }

//    public void generateNewEasyBoard(Board aGameBoard, Board aSolutionBoard) {
//        generateBoardAndSolution(aGameBoard, aSolutionBoard, 9, Difficulties.EASY);
//    }
//
//    public void generateNewMediumBoard(Board aGameBoard, Board aSolutionBoard) {
//        generateBoardAndSolution(aGameBoard, aSolutionBoard, 9, Difficulties.MEDIUM);
//    }
//
//    public void generateNewHardBoard(Board aGameBoard, Board aSolutionBoard) {
//        generateBoardAndSolution(aGameBoard, aSolutionBoard, 9, Difficulties.HARD);
//    }

    public boolean checkIfSolutionCorrect(Board aGameBoard, Board aSolutionBoard) {
        return Arrays.equals(aGameBoard.getValues(), aSolutionBoard.getValues());
    }

    public void setValueInSpecificLocation(Board aGameBoard, int height, int width, int value) {
        aGameBoard.setSpecificValue(height, width, value);
    }

    public void generateNewBoard(Board aGameBoard, Board aSolutionBoard, Difficulties diff) {
        generateBoardAndSolution(aGameBoard, aSolutionBoard, 9, diff);
    }
}
