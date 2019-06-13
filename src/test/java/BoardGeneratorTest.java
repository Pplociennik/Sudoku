import org.junit.Test;
import pl.sudoku.game.entities.enums.Difficulties;
import pl.sudoku.game.processing.BoardGenerator;

import static junit.framework.TestCase.assertEquals;
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
    @Test
    public void shouldRemove20DigitsOnEasyMode(){
        BoardGenerator generator = new BoardGenerator();
        generator.prepare(9, Difficulties.EASY.getDiffCode());
        generator.fillValues();
        generator.removeKDigits();
        int [][] result = generator.getMat();
        int count = 0;
        for(int i= 0 ; i < 9 ; i++)
            for(int j= 0 ; j < 9; j++)
                if(result[i][j] == 0){
                    count++;
                }

        assertEquals(count,20);

    }
    @Test
    public void shouldRemove30DigitsOnMediumMode(){
        BoardGenerator generator = new BoardGenerator();
        generator.prepare(9, Difficulties.MEDIUM.getDiffCode());
        generator.fillValues();
        generator.removeKDigits();
        int [][] result = generator.getMat();
        int count = 0;
        for(int i= 0 ; i < 9 ; i++)
            for(int j= 0 ; j < 9; j++)
                if(result[i][j] == 0){
                    count++;
                }

        assertEquals(count,30);

    }
    @Test
    public void shouldRemove40DigitsOnMediumMode(){
        BoardGenerator generator = new BoardGenerator();
        generator.prepare(9, Difficulties.HARD.getDiffCode());
        generator.fillValues();
        generator.removeKDigits();
        int [][] result = generator.getMat();
        int count = 0;
        for(int i= 0 ; i < 9 ; i++)
            for(int j= 0 ; j < 9; j++)
                if(result[i][j] == 0){
                    count++;
                }

        assertEquals(count,40);

    }

}
