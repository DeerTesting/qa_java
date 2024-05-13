import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline feline;

    @Test
    public void eatMeatFeline() throws Exception{
        List<String> actualFood = new ArrayList<>(feline.eatMeat());
        List <String> expectedFood = new ArrayList<>(Arrays.asList("Животные", "Птицы", "Рыба"));
        assertArrayEquals(expectedFood.toArray(), actualFood.toArray());
    }

    @Test
    public void eatMeatNeededParam() throws Exception{
        feline.eatMeat();
        Mockito.verify(feline).getFood("Хищник");
    }

    @Test
    public void getFamily(){
        String actualResult = "Кошачьи";
        String expectedResult = feline.getFamily();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getKittensMoreThanZero(){
        int expectedResult = 2;
        int actualResult = feline.getKittens(2);
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void getKittensNoParam(){
        feline.getKittens();
        Mockito.verify(feline).getKittens(1);
    }

}
