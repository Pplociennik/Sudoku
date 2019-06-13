package pl.sudoku.game.entities.enums;

public enum Difficulties {
    EASY(30), MEDIUM(40), HARD(50);

    private final int diffCode;

    Difficulties(int value) {
        this.diffCode = value;
    }

    public int getDiffCode() {
        return this.diffCode;
    }
}
