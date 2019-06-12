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
        long difference = endTime - startTime;
        return (long) ((((10000) - (difference/10000)) * (1 - diff.getDiffCode() / 100)) % (Math.pow(2, 9) * 6));
    }
}
