import org.junit.Test;
import pl.sudoku.game.processing.BoardGenerator;

import static junit.framework.TestCase.assertNotNull;

public class BoardGeneratorTest {

    @Test
    public void shouldGenerateNotEmptyArray() {
        BoardGenerator generator = new BoardGenerator();
        generator.prepare(9, 30);
        generator.fillValues();
        int[][] result = generator.getMat();

        assertNotNull(result);
    }
}
