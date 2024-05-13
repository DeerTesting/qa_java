import com.example.Feline;
import com.example.LionAlex;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionAlexTest {
    @Mock
    Feline feline;
    LionAlex alex;


    @Before
    public void setUpAlex() throws Exception {
        alex = new LionAlex(feline);
    }

    @Test
    public void getPlaceOfLiving(){
        String actualResult = alex.getPlaceOfLiving();
        String expectedResult = "Нью-Йоркский зоопарк";
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void gerFriends(){
        List<String> actualResult = alex.getFriends();
        List <String> expectedResult = new ArrayList<>(Arrays.asList("Марти", "Глория", "Мелман"));
        assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
    }

    @Test
    public void getKittensArguments(){
        alex.getKittens();
        Mockito.verify(feline).getKittens(0);
    }

    @Test
    public void getKittens(){
        Mockito.when(feline.getKittens(0)).thenReturn(5);
        assertEquals(5, alex.getKittens());
    }
}
