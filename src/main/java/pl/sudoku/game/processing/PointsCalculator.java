package pl.sudoku.game.processing;

import pl.sudoku.game.entities.enums.Difficulties;

public class PointsCalculator {

    private long startTime;
    private long endTime;
    private Difficulties diff;

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public void setDiff(Difficulties diff) {
        this.diff = diff;
    }

    public long countPlayerPoints() {
        return (endTime - startTime) * (1 - diff.getDiffCode() / 100);
    }
}
