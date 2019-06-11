package pl.sudoku.game.entities.enums;

public enum Difficulties {
    EASY(20), MEDIUM(30), HARD(40);

    private final int diffCode;

    Difficulties(int value) {
        this.diffCode = value;
    }

    public int getDiffCode() {
        return this.diffCode;
    }
}
