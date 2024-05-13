import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.example.Predator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    Cat cat;


    @Before
    public void setUp(){
        cat = new Cat(feline);
    }

    @Test
    public void getSoundTest(){
        String actualResult = cat.getSound();
        String expectedResult = "Мяу";
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void eatMeat() throws Exception {
        List <String> expectedResult = new ArrayList<>(Arrays.asList("Животные", "Птицы", "Рыба"));
        Mockito.when(feline.eatMeat()).thenReturn(expectedResult);
        assertArrayEquals(expectedResult.toArray(), cat.getFood().toArray());
    }

}
