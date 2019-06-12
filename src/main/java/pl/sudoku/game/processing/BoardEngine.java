package pl.sudoku.game.processing;

import pl.sudoku.game.entities.Board;
import pl.sudoku.game.entities.enums.Difficulties;

public class BoardEngine {

    private BoardGenerator boardGenerator = new BoardGenerator();

    private void generateBoardAndSolution(Board aGameBoard, Board aSolutionBoard, Integer aBoardSize, Difficulties aDifficulty) {
        boardGenerator.prepare(aBoardSize, aDifficulty.getDiffCode());
        boardGenerator.fillValues();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                aSolutionBoard.setSpecificValue(i, j, boardGenerator.getMat()[i][j]);
            }
        }
        boardGenerator.removeKDigits();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                aGameBoard.setSpecificValue(i, j, boardGenerator.getMat()[i][j]);
            }
        }
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
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (aGameBoard.getSpecificValue(i, j) != aSolutionBoard.getSpecificValue(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void setValueInSpecificLocation(Board aGameBoard, int height, int width, int value) {
        aGameBoard.setSpecificValue(height, width, value);
    }

    public void generateNewBoard(Board aGameBoard, Board aSolutionBoard, Difficulties diff) {
        generateBoardAndSolution(aGameBoard, aSolutionBoard, 9, diff);
    }
}
