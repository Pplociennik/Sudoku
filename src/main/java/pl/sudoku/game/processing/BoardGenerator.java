package pl.sudoku.game.processing;

public class BoardGenerator {

    private int[][] mat;
    private int size; // number of columns/rows.
    private int SRN; // square root of size
    private int emptyTilesNo; // No. Of missing digits

    public void prepare(Integer size, Integer emptyTilesNo) {
        this.size = size;
        this.emptyTilesNo = emptyTilesNo;

        // Compute square root of size
        Double SRNd = Math.sqrt(size);
        SRN = SRNd.intValue();

        mat = new int[size][size];
    }

    // Sudoku Generator
    public void fillValues() {
        // Fill the diagonal of SRN x SRN matrices
        fillDiagonal();

        // Fill remaining blocks
        fillRemaining(0, SRN);

        // Remove Randomly emptyTilesNo digits to make game
//        removeKDigits();
    }

    // Fill the diagonal SRN number of SRN x SRN matrices
    void fillDiagonal() {

        for (int i = 0; i < size; i = i + SRN)

            // for diagonal box, start coordinates->i==j
            fillBox(i, i);
    }

    // Returns false if given 3 x 3 block contains num.
    boolean unUsedInBox(Integer rowStart, Integer colStart, Integer num) {
        for (int i = 0; i < SRN; i++)
            for (int j = 0; j < SRN; j++)
                if (mat[rowStart + i][colStart + j] == num)
                    return false;

        return true;
    }

    // Fill a 3 x 3 matrix.
    void fillBox(Integer row, Integer col) {
        int num;
        for (int i = 0; i < SRN; i++) {
            for (int j = 0; j < SRN; j++) {
                do {
                    num = randomGenerator(size);
                }
                while (!unUsedInBox(row, col, num));

                mat[row + i][col + j] = num;
            }
        }
    }

    // Random generator
    int randomGenerator(Integer num) {
        return (int) Math.floor((Math.random() * num + 1));
    }

    // Check if safe to put in cell
    boolean CheckIfSafe(int i, int j, int num) {
        return (unUsedInRow(i, num) &&
                unUsedInCol(j, num) &&
                unUsedInBox(i - i % SRN, j - j % SRN, num));
    }

    // check in the row for existence
    boolean unUsedInRow(Integer i, Integer num) {
        for (int j = 0; j < size; j++)
            if (mat[i][j] == num)
                return false;
        return true;
    }

    // check in the row for existence
    boolean unUsedInCol(Integer j, Integer num) {
        for (int i = 0; i < size; i++)
            if (mat[i][j] == num)
                return false;
        return true;
    }

    // A recursive function to fill remaining
    // matrix
    boolean fillRemaining(Integer i, Integer j) {
        //  System.out.println(i+" "+j);
        if (j >= size && i < size - 1) {
            i = i + 1;
            j = 0;
        }
        if (i >= size && j >= size)
            return true;

        if (i < SRN) {
            if (j < SRN)
                j = SRN;
        } else if (i < size - SRN) {
            if (j == (int) (i / SRN) * SRN)
                j = j + SRN;
        } else {
            if (j == size - SRN) {
                i = i + 1;
                j = 0;
                if (i >= size)
                    return true;
            }
        }

        for (int num = 1; num <= size; num++) {
            if (CheckIfSafe(i, j, num)) {
                mat[i][j] = num;
                if (fillRemaining(i, j + 1))
                    return true;

                mat[i][j] = 0;
            }
        }
        return false;
    }

    // Remove the emptyTilesNo no. of digits to
    // complete game
    public void removeKDigits() {
        int count = emptyTilesNo;
        while (count != 0) {
            int cellId = randomGenerator(size * size);

            //System.out.println(cellId);
            // extract coordinates i  and j
            int i = (cellId / size);
            int j = cellId % 9;
            if (j != 0)
                j = j - 1;

            //System.out.println(i+" "+j);
            if (mat[i][j] != 0) {
                count--;
                mat[i][j] = 0;
            }
        }
    }


    public int[][] getMat() {
        return mat;
    }

}
