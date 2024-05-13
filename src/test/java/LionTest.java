import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;
    Lion lion;

    @Before
    public void setUpLion() throws Exception {
        lion = new Lion(feline, "Самец");
    }


    @Test
    public void getKittens(){
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actualResult = lion.getKittens();
        int expectedResult = 1;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getKittensNoArgument(){
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test(expected = Exception.class)
    public void hasManeException() throws Exception {
        lion = new Lion(feline, "undefined");
    }

    @Test
    public void getFood() throws Exception {
        List<String> expectedFood = new ArrayList<>(Arrays.asList("Животные", "Птицы", "Рыба"));
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        assertArrayEquals(expectedFood.toArray(), lion.getFood().toArray());
    }

    @Test
    public void getFoodTypeAnimal() throws Exception{
        lion.getFood();
        Mockito.verify(feline).getFood("Хищник");
    }
}
